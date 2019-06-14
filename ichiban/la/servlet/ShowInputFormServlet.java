package la.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderDetailBean;

@WebServlet("/ShowInputFormServlet")
public class ShowInputFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");


 				if(action.equals("regist")) {
 					// 次のサーブレットに渡すリストを準備
 					ArrayList<OrderDetailBean> list= new ArrayList<OrderDetailBean>();
 					for (int cnt = 1; cnt < 11; cnt++) {
 						// 前画面から渡された１明細ごとにBeanを作成し、リストに追加
 	 					OrderDetailBean bean = new OrderDetailBean();
 	 					if (request.getParameter("order_id" + cnt).length() > 0) {
 	 	 					bean.setOrder_id(request.getParameter("order_id" + cnt));
 	 	 					bean.setQuantity(Integer.parseInt(request.getParameter("quantity" + cnt)));
 	 	 					list.add(bean);
 	 					}
 					}
					request.setAttribute("list", list);

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
