package la.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DataAccessException;
import la.dao.PostgreSQLEmployeeDao;


public class LoginManager {
	/*
		ログイン情報を管理するクラス
	*/
	public static boolean login(HttpServletRequest request, HttpServletResponse response,
			String employee_code, String password) throws ServletException, IOException, DataAccessException {
		/*
			機能：
				一般従業員としてログインする
			結果：
				true：ログイン成功
				false：ログイン失敗
			引数：
				employee_code：従業員コード
				password：パスワード
		*/

		// Daoに接続
		PostgreSQLEmployeeDao dao = null;
		try {
			dao = new PostgreSQLEmployeeDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
			return false;
		}

		// 従業員データベースに登録されていか確認
		Boolean isLogin = dao.loginEmployee(employee_code, password);
		if (isLogin == true) {
			HttpSession session = request.getSession();
			// セッションに一般従業員ログインを追加
			session.setAttribute("isLogin", "employee");
			// セッションに従業員コードを追加
			session.setAttribute("employee_code", employee_code);
			return true;
		} else {
			return false;
		}
	}


	public static boolean login(HttpServletRequest request, HttpServletResponse response,
			String employee_code, String password, String admin_code) throws ServletException, IOException, DataAccessException {
		/*
			機能：
				管理者としてログインする
			結果：
				true：ログイン成功
				false：ログイン失敗
			引数：
				employee_code：従業員コード
				password：従業員パスワード
		*/

		// Daoに接続
		PostgreSQLEmployeeDao dao = null;
		try {
			dao = new PostgreSQLEmployeeDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
			return false;
		}

		// 従業員データベースに登録されていか確認
		Boolean isLogin = dao.loginAdmin(employee_code, password, admin_code);
		if (isLogin == true) {
			HttpSession session = request.getSession();
			// セッションに管理者ログインを追加
			session.setAttribute("isLogin", "admin");
			// セッションに従業員コードを追加
			session.setAttribute("employee_code", employee_code);
			return true;
		} else {
			return false;
		}
	}


	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*
			機能：
				セッションを切断する（ログアウトする）
		*/
		HttpSession session = request.getSession();
		// セッションの切断
		session.invalidate();
	}


	public static boolean checkEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			機能：
				従業員としてログインしているかチェックする
				ログインしていなければ「login.html」を表示する
			結果：
				true：ログイン済み
				false：未ログイン
			引数：
				employee_code：従業員コード
				password：従業員コード
		*/

		// セッションの取得
		HttpSession session = request.getSession(false);
		// セッションがなければlogin.htmlに遷移
		if (session == null) {
			gotoPage(request, response, "/login.html");
			return false;
		} else {
			// ログイン形態を取得（一般従業員 or 管理者）
			String isLogin = (String)session.getAttribute("isLogin");
			// 一般従業員でなければlogin.htmlに遷移
			if (isLogin == null || !isLogin.equals("employee")) {
				gotoPage(request, response, "/login.html");
				return false;
			}
		}
		return true;
	}


	public static boolean checkAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			機能：
				従業員としてログインしているかチェックする
				ログインしていなければadminLogin.htmlを表示する
			結果：
				true：ログイン済み
				false：未ログイン
			引数：
				employee_code：従業員コード
				password：従業員コード
		*/

		// セッションの取得
		HttpSession session = request.getSession(false);
		// セッションがなければadminLogin.htmlに遷移
		if (session == null) {
			gotoPage(request, response, "/adminLogin.html");
			return false;
		} else {
			// ログイン形態を取得（一般従業員 or 管理者）
			String isLogin = (String)session.getAttribute("isLogin");
			// 管理者でなければasminLogin.htmlに遷移
			if (isLogin == null || !isLogin.equals("admin")) {
				gotoPage(request, response, "/adminLogin.html");
				return false;
			}
		}
		return true;
	}

	
	public static String getEmployeeCode(HttpSession session) throws ServletException, IOException {
		/*
			機能：
				従業員コードを取得する
			結果：
				String：従業員コード
			引数：
				session：セッション
		*/

		String employee_code = (String)session.getAttribute("employee_code");
		return employee_code;

	}

	
	private static void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
