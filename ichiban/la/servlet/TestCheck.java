package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCheck
 */
@WebServlet("/test")
public class TestCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>TestCheck</title></head><body>");
		out.println("<form action='/jmaster/test' method='POST'>");
		out.println("国語：<input type='text' name='Japanese'><br>");
		out.println("英語：<input type='text' name='English'><br>");
		out.println("<input type='submit' value='合否'>");
		out.println("<script>");
		out.println("</script>");
		out.println("<form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String japanese = request.getParameter("Japanese");
		String english = request.getParameter("English");

		int num1 = Integer.parseInt(japanese);
		int num2 = Integer.parseInt(english);
		String answer = judge(num1, num2);

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>TestCheck</title></head><body>");
		out.println("国語：" + japanese + "点<br>");
		out.println("英語：" + english + "点<br>");
		out.println("合計点：" + (num1 + num2) + "点<br>");
		out.println(answer);
		out.println("</body></html>");
	}

	String judge (int num1, int num2) {
		String result;
		int sum = num1 + num2;
		if (sum >= 70) {
			result = "合";
		} else {
			result = "否";
		}
		return result;

	}

}
