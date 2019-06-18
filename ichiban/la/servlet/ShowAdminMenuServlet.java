package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DataAccessException;
import la.java.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ShowAdminMenuServlet")
public class ShowAdminMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAdminMenuServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 管理者でログインしているかチェックする
		String action = request.getParameter("action");

		if ((action!=null) && (action.length()!=0) && (action.equals("adminLogin"))) {
			String employee_code = request.getParameter("employee_code");
			String password = request.getParameter("password");
			try {
				boolean isLogin = LoginManager.login(request, response, employee_code, password, "0001");
				if (isLogin) {
					gotoPage(request,response, "/adminMenu.jsp");
				} else {
					gotoPage(request,response, "/loginError.jsp");
				}
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				gotoPage(request,response, "/loginError.jsp");
			}
		} else {
			boolean flg = LoginManager.checkAdmin(request, response);
			if (flg == false) {
				return;
			}
		}

		gotoPage(request,response, "/adminMenu.jsp");

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
