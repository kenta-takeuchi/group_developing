package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyMessageServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
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

		String ans = request.getParameter("ans");
		String message;
		switch(ans) {
			case "1":
				message = "正解";
				break;
			case "2":
				message = "不正解";
				break;
			case "3":
				message = "不正解";
				break;
			default:
				message = "不正解";
				break;
		}

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>MyMessageServlet</title></head><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}

}
