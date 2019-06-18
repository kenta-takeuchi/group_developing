package la.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderTotalBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.java.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ShowOrderTotalServlet")
public class ShowOrderTotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOrderTotalServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		boolean flg = LoginManager.checkAdmin(request, response);
		if (flg == false) {
			return;
		}

		String year = request.getParameter("year");
		String month = request.getParameter("month");

		PostgreSQLOrderDao dao = null;

		try {
			dao = new PostgreSQLOrderDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();

		}

		try {
			List<OrderTotalBean> list = dao.selectByOrderedDate(year, month);
			request.setAttribute("List", list);
			gotoPage(request,response, "/orderTotal.jsp");
		} catch (DataAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			gotoPage(request,response, "/AdminMenu.jsp");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			gotoPage(request,response, "/AdminMenu.jsp");
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
