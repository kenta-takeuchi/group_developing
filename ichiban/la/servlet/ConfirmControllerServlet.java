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

import la.bean.OrderBean;
import la.bean.OrderDetailBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.java.LoginManager;

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

		boolean flg = LoginManager.checkEmployee(request, response);
		if (flg == false) {
			return;
		}

		String customer_code = request.getParameter("customer_code");

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
					beanDetail.setQuantity(Integer.parseInt(request.getParameter("quantity_" + cnt)));
					beanDetail.setProduct_code(request.getParameter("product_code_" + cnt));
					list.add(beanDetail);
				}

				PostgreSQLOrderDao regist = new PostgreSQLOrderDao();
				String employee = LoginManager.getEmployeeCode(request.getSession());
				regist.insertOrder(bean, list, employee);

			} catch (DataAccessException e) {
				e.printStackTrace();
				e.printStackTrace();
				request.setAttribute("message", "データベースと接続できず処理できませんでした。");
				gotoPage(request, response,"/Message.jsp");
				// TODO 足りない項目を後で追加
			}

			gotoPage(request, response, "/OrderRegistResult.jsp");

		} else {
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response,"/Message.jsp");
			return;
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
