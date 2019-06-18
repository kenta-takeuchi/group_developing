package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.SearchResultBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * @param action
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//パラメーターの解析
		String ordered_date = request.getParameter("ordered_date");
		String customer_code = request.getParameter("customer_code");
		String employee_code = request.getParameter("employee_code");
		//パラメータチェック
		boolean flg = true;
		String add_sql = "";
		if (ordered_date.length() != 0) {
			if (ordered_date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
				add_sql += " AND ordered_date ='" + ordered_date + "'";
			} else {
				flg = false;
			}
		}
		if (customer_code.length() != 0) {
			if (customer_code.matches("[0-9]{4}")) {
				add_sql += " AND customer_code ='" + customer_code + "'";
			} else {
				flg = false;
			}
		}
		if (employee_code.length() != 0) {
			if (employee_code.matches("[0-9]{4}")) {
				add_sql += " AND employee_code ='" + employee_code + "'";
			} else {
				flg = false;
			}
		}
		if (!flg) {
			RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
			rd.forward(request, response);
		}

		try {
			PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
			List<SearchResultBean> list = dao.select(add_sql);
			request.setAttribute("searchResults", list);
			RequestDispatcher rd = request.getRequestDispatcher("/OrderSearchResult.jsp");
			rd.forward(request, response);
		} catch (DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
