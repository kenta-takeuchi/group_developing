package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class OrderSearchDetail
 */
@WebServlet("/OrderSearchDetail")
public class OrderSearchDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSearchDetailServlet() {
        super();
        // TODO Auto-generated constructor stub



    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/OrderSearchDetail.jsp");


/*		try {
			String action = request.getParameter("action");
			if (false) {
				PostgreSQLOrderDetailDao dao = new PostgreSQLOrderDetailDao();
				gotoPage(request, response, "/OrderSearchDetail.jsp");
			}
*/		}

private void gotoPage(HttpServletRequest request, HttpServletResponse response, String string) {
	// TODO 自動生成されたメソッド・スタブ
}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
