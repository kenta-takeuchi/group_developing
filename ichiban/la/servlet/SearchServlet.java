package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderBean;
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
			HttpServletResponse response, Object action) throws ServletException, IOException {
		if (action.equals("search")) {
			OrderBean bean = new OrderBean();
			bean.setId(request.getParameter("id"));
			bean.setCustomer_code(request.getParameter("customer_code"));
			bean.setEmployee_code(request.getParameter("employee_code"));			
			//bean.setOrdered_date(request.getParameter("ordered_date"));
			bean.setId(request.getParameter("tax"));
			gotoPage(request, response, "/OrderSearchResult.jsp");
			
			
			try {
				PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String strOrdered_date = request.getParameter("ordered_date");
		String strEmployee_code = request.getParameter("employee_code");
		String strId = request.getParameter("id");
		String strCustomer_code = request.getParameter("customer_code");
		//パラメータチェック
		if (strOrdered_date == null || strEmployee_code == null || strCustomer_code == null ||
				strOrdered_date.length() == 0 || strCustomer_code.length() == 0 || strEmployee_code.length() == 0) {
			request.setAttribute("message", "未入力の項目があります。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}

		int ordered_date, id, employee_code, customer_code;

		try {
			ordered_date = Integer.parseInt(strOrdered_date);
			employee_code = Integer.parseInt(strEmployee_code);
			customer_code = Integer.parseInt(strCustomer_code);

		} catch (NumberFormatException e) {
			request.setAttribute("message", "半角数字で入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}
		OrderBean p = new OrderBean();
		request.setAttribute("result", p);
		RequestDispatcher rd = request.getRequestDispatcher("/OrderSearchResult.jsp");
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
