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
@WebServlet("/MyMessageServlet")
public class MyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String message = request.getParameter("message");
		String size = request.getParameter("size");
		String tag_start;
		String tag_end;

		switch(size) {
			case "大":
				tag_start = "<h1>";
				tag_end   = "</h1>";
				break;
			case "中":
				tag_start = "<h3>";
				tag_end   = "</h3>";
				break;
			case "小":
				tag_start = "<h5>";
				tag_end   = "</h5>";
				break;
			default:
				tag_start = "";
				tag_end   = "";
				break;
		}

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>MyMessageServlet</title></head><body>");
		out.println(tag_start + message + tag_end + size);
		out.println("</body></html>");
	}

}
