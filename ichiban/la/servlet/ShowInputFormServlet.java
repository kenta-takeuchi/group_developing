package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ProductBean;

@WebServlet("/ShowInputFormServlet")
public class ShowInputFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");
			if(action == null || action.length() == 0 || action.equals("")) {
				
				gotoPage(request, response, "/Login.jsp");

			}else if(action.equals("regist")) {
				ProductBean bean = new ProductBean();
				bean.setName(request.getParameter("name"));
				bean.setCode(request.getParameter("code"));
				bean.setCategory_Code(request.getParameter("category_code"));
				gotoPage(request, response, "/OrderRegistConfirm.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/OrderRegistError.jsp");
			}

	}
	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,IOException {

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
