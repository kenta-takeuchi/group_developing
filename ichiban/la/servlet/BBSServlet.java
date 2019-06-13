package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet("/BBSServlet")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> array = new ArrayList<String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String message = request.getParameter("message");

		array.add(message);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset=\"UTF-8\"><title>BBSServlet</title></head><body>");
		out.println("<form action=\"/jmaster/BBSServlet\" method=\"POST\">");
		out.println("メッセージ：<br>");
		out.println("<textarea name=\"message\"></textarea><br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("</form>");
		out.println("<hr>");
		for (String s: array) {
			out.println(s + "<br>");
			out.println("<hr>");
		}
		out.println("</body></html>");
	}

}
