package la.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
// ログインしていないときにURLを直接入力したらログインページに飛ばす
LoginCheck logincheck = new LoginCheck();
logincheck.check(request, response);
*/

public class LoginCheck {
	public void check(HttpServletRequest request, HttpServletResponse response) {
		// セッションからログインしているかを確認する
		HttpSession session = request.getSession(false);
		if (session == null) {
			try {
				gotoPage(request, response, "/login.html");
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String isLogin = (String)session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.equals("true")) {
				try {
					gotoPage(request, response, "/login.html");
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
