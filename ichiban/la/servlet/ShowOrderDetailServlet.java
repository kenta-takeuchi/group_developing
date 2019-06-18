package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderDetailBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDetailDao;

/**
 * Servlet implementation class OrderSearchDetail
 */
@WebServlet("/ShowOrderDetailServlet")
public class ShowOrderDetailServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOrderDetailServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(0);
		try {
			//パラメータの取得
			System.out.println(1);
			String action = request.getParameter("action");
			if (action.equals("detail")) {
				String order_id = request.getParameter("order_id");
				PostgreSQLOrderDetailDao dao = new PostgreSQLOrderDetailDao();
				List<OrderDetailBean> list = dao.selectByOrderId(order_id);
				request.setAttribute("order_id", order_id);
				request.setAttribute("orderDetails", list);
				RequestDispatcher rd = request.getRequestDispatcher("/OrderDetail.jsp");
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
