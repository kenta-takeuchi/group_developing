package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDetailDao;

/**
 * Servlet implementation class OrderSearchDetail
 */
@WebServlet("/OrderSearchDetailServlet")
public class OrderSearchDetailServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");
			if (action.equals("detail")) {
				PostgreSQLOrderDetailDao dao = new PostgreSQLOrderDetailDao();
				List<OrderBean> list = dao.select();
				request.setAttribute("order", list);
				RequestDispatcher rd = request.getRequestDispatcher("/OrderSearchDetail.jsp");
				rd.forward(request, response);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
