package la.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DataAccessException;
import la.dao.PostgreSQLEmployeeDao;

/*
// ログインしていないときにURLを直接入力したらログインページに飛ばす
LoginCheck logincheck = new LoginCheck();
logincheck.check(request, response);
*/

public class LoginManager {
	public static boolean login(HttpServletRequest request, HttpServletResponse response,
			String employee_code, String password) throws ServletException, IOException, DataAccessException {

		PostgreSQLEmployeeDao dao = null;
		try {
			dao = new PostgreSQLEmployeeDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		Boolean isLogin = dao.loginEmployee(employee_code, password);
		if (isLogin == true) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "employee");
			session.setAttribute("employee_code", employee_code);
			return true;
		} else {
			return false;
		}
	}


	public static boolean login(HttpServletRequest request, HttpServletResponse response,
			String employee_code, String password, String admin_code) throws ServletException, IOException, DataAccessException {

		PostgreSQLEmployeeDao dao = null;
		try {
			dao = new PostgreSQLEmployeeDao();
		} catch (DataAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		Boolean isLogin = dao.loginAdmin(employee_code, password, admin_code);
		if (isLogin == true) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "admin");
			session.setAttribute("employee_code", employee_code);
			return true;
		} else {
			return false;
		}
	}


	public static void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
	}


	public static boolean checkEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションからログインしているかを確認する
		HttpSession session = request.getSession(false);
		if (session == null) {
			gotoPage(request, response, "/login.html");
			return false;
		} else {
			String isLogin = (String)session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.equals("employee")) {
				gotoPage(request, response, "/login.html");
				return false;
			}
		}
		return true;
	}


	public static boolean checkAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションからログインしているかを確認する
		HttpSession session = request.getSession(false);
		if (session == null) {
			gotoPage(request, response, "/adminLogin.html");
			return false;
		} else {
			String isLogin = (String)session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.equals("admin")) {
				gotoPage(request, response, "/adminLogin.html");
				return false;
			}
		}
		return true;
	}


	private static void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
