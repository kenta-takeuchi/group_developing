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
import la.java.LoginManager;

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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 一般従業員でログイン済みかチェック
		boolean flg = LoginManager.checkEmployee(request, response);
		if (flg == false) {
			return;
		}

		//パラメーターの解析
		String ordered_date = request.getParameter("ordered_date");
		String customer_code = request.getParameter("customer_code");
		String employee_code = request.getParameter("employee_code");

		//パラメータチェック
		flg = true;
		String add_sql = "";
		//ordered_dateがnullではない、かつ、ordered_dateの長さが0でないとき
		if (ordered_date != null && ordered_date.length() != 0) {
			//ordered_dateが0~9で4桁、0~9で2桁,0~9で2桁の時、以下のsql文を実行する。
			if (ordered_date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
				add_sql += " AND ordered_date ='" + ordered_date + "'";
			} else {
				flg = false;
			}
		}
		if (customer_code != null && customer_code.length() != 0) {
			//customer_codeが0~9で4桁の時以下のsql文を実行する。
			if (customer_code.matches("[0-9]{4}")) {
				add_sql += " AND customer_code ='" + customer_code + "'";
			} else {
				flg = false;
			}
		}
		if (employee_code != null && employee_code.length() != 0) {
			//employee_codeが0~9で4桁の時以下のsql文を実行する。
			if (employee_code.matches("[0-9]{4}")) {
				add_sql += " AND employee_code ='" + employee_code + "'";
			} else {
				flg = false;
			}
		}
		//何も入力されていない状態で検索ボタンが押されたとき、messageにエラーメッセージを入れて元の検索画面に戻す。
		if (flg == false && ordered_date.length() == 0 && customer_code.length() == 0 && employee_code.length() == 0) {
			request.setAttribute("message", "数値を入力してください。");
			RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
			rd.forward(request, response);
		}

		//list型の"searchResults"で検索結果画面にforwardする。
		try {
			PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
			List<SearchResultBean> list = dao.select(add_sql);
			//検索結果が存在しないとき
			if (list.size() == 0) {
				request.setAttribute("message", "検索結果がありません。");
				RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("searchResults", list);
				RequestDispatcher rd = request.getRequestDispatcher("/OrderSearchResult.jsp");
				rd.forward(request, response);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
	}

	//Postで送られてきた場合、Getに送る。
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
