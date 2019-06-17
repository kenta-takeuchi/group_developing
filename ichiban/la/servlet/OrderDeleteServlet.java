package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.dao.PostgreSQLOrderDetailDao;
import la.java.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/OrderDeleteServlet")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		boolean flg = LoginManager.checkEmployee(request, response);
		if (flg == false) {
			return;
		}

		String order_id = request.getParameter("order_id");

		PostgreSQLOrderDao daoOrder = null;
		try {
			daoOrder = new PostgreSQLOrderDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		PostgreSQLOrderDetailDao daoOrderDetail = null;
		try {
			daoOrderDetail = new PostgreSQLOrderDetailDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try {
			daoOrderDetail.deleteByOrderId(order_id);
			daoOrder.deleteById(order_id);
			gotoPage(request,response, "/MainMenu.jsp");
		} catch (DataAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			gotoPage(request,response, "/MainMenu.jsp");
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

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
