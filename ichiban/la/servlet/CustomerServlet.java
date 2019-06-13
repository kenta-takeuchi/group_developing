package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session == null) {
			out.println("<html><head><meta charset=\"UTF-8\"><title>CustomerServlet</title></head><body>");
			out.println("<h1>名前、住所、電話番号を登録してください</h1>");
			out.println("</body></html>");
		} else {
			String isLogin = (String)session.getAttribute("isLogin");

			if (isLogin == null || !isLogin.equals("true")) {
				out.println("<html><head><meta charset=\"UTF-8\"><title>CustomerServlet</title></head><body>");
				out.println("<h1>名前、住所、電話番号を登録してください</h1>");
				out.println("</body></html>");
			} else {
				String ans = request.getParameter("ans");

				if (ans.equals("confirm")) {
					String name = (String)session.getAttribute("name");
					String address = (String)session.getAttribute("address");
					String phone = (String)session.getAttribute("phone");

					out.println("<html><head><meta charset=\"UTF-8\"><title>BBSServlet</title></head><body>");
					out.println("名前：" + name + "<br>");
					out.println("住所：" + address + "<br>");
					out.println("電話：" + phone + "<br>");
					out.println("</body></html>");
				} else {
					out.println("<html><head><meta charset=\"UTF-8\"><title>BBSServlet</title></head><body>");
					out.println("<h1>エラー</h1>" + ans);
					out.println("</body></html>");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		session.setAttribute("isLogin", "true");
		session.setAttribute("name", name);
		session.setAttribute("address", address);
		session.setAttribute("phone", phone);

		out.println("<html><head><meta charset=\"UTF-8\"><title>BBSServlet</title></head><body>");
		out.println("<h1>登録しました！</h1>");
		out.println("</body></html>");
	}
}
