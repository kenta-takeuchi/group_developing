package la.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.OrderBean;
import la.bean.OrderDetailBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;

/**
 * Servlet implementation class ConfirmControllerServlet
 */
@WebServlet("/ConfirmControllerServlet")
public class ConfirmControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html:charset=UTF-8");
		HttpSession session = request.getSession(false);

		if (session == null) {
			request.setAttribute("message", "セッションが切れています、もう一度ログインしてください");
		}

		//String order_id = request.getParameter("order_id");
		String customer_code = request.getParameter("customer_code");
		System.out.println("customer_code:" + customer_code);

		//if(order_id != null && customer_code != null) {
		if (customer_code != null) {
			try {
				OrderBean bean = new OrderBean("", customer_code, "", Date.valueOf("2019-06-17"), BigDecimal.valueOf(0),0, BigDecimal.valueOf(0));

				// DAOに渡すリストを準備
				ArrayList<OrderDetailBean> list= new ArrayList<OrderDetailBean>();
				for (int cnt = 1; cnt < 11; cnt++) {
					// 前画面から渡された１明細ごとにBeanを作成し、リストに追加
					OrderDetailBean beanDetail = new OrderDetailBean();
					if (request.getParameter("quantity_" + cnt) == null) {
						break;
					}
					beanDetail.setOrder_id(request.getParameter("order_id_" + cnt));
					beanDetail.setQuantity(Integer.parseInt(request.getParameter("quantity_" + cnt)));
					beanDetail.setProductCode(request.getParameter("order_id_" + cnt));
					list.add(beanDetail);
				}

				PostgreSQLOrderDao regist = new PostgreSQLOrderDao();
				regist.insertOrder(bean, list);

			} catch (DataAccessException e) {
				e.printStackTrace();
				// TODO 足りない項目を後で追加
			}
			gotoPage(request, response, "/OrderRegistResult.jsp");

		} else {

			gotoPage(request, response, "/OrderRegistError.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
