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

import la.bean.OrderAnalyzeBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLProductDao;
import la.java.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ShowOrderAnalyzeServlet")
public class ShowOrderAnalyzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOrderAnalyzeServlet() {
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

		PostgreSQLProductDao dao = null;

		try {
			dao = new PostgreSQLProductDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();

		}
		try {
			List<OrderAnalyzeBean> list = dao.selectByProductId(year, month);
			request.setAttribute("order_analyzes", list);
			gotoPage(request,response, "/orderAnalyze.jsp");
		} catch (DataAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			gotoPage(request,response, "/adminMenu.jsp");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			gotoPage(request,response, "/adminMenu.jsp");
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
