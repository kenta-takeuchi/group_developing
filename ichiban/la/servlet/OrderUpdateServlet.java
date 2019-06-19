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
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDetailDao;
import la.java.LoginManager;



/**
 * Servlet implementation class ShowUpdateFormController
 */
@WebServlet("/OrderUpdateServlet")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 public OrderUpdateServlet() {
	        super();
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 一般従業員でログイン済みかチェック
		boolean flg = LoginManager.checkEmployee(request, response);
		if (flg == false) {
			return;
		}

		try {
			String order_id = request.getParameter("order_id");

			ArrayList<OrderDetailBean> order_details = new ArrayList<OrderDetailBean>();

			for (int i=0; i<10; i++) {

				String strQuantity = request.getParameter("quantity_" + i);
				String product_code = request.getParameter("product_code_" + i);

				//strCountが「null」か「空文字」だったら次へ
				if ((strQuantity == null) || (strQuantity.length() == 0)) {
					continue;
				}

				//product_codeが「null」か「-----」だったら次の処理へ
				if (strQuantity == "-----") {
					continue;
				}

				int quantity = Integer.parseInt(strQuantity);

				OrderDetailBean beanDetail = new OrderDetailBean(order_id, product_code, quantity);
				System.out.println(beanDetail.getProduct_code());
				order_details.add(beanDetail);
			}

			PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
			//既存のデータを消去する処理
			detailDao.deleteByOrderId(order_id);

			//resistOrderDetailは仮名、登録するメソッド名
			detailDao = new PostgreSQLOrderDetailDao();
			detailDao.insertOrderDetail(order_details);

			request.setAttribute("message", "更新しました。");
			gotoPage(request, response,"/Message.jsp");
		} catch (NumberFormatException e) {
			request.setAttribute("message", "受注数には数字を入力してください。");
			gotoPage(request, response,"/OrderUpdate.jsp");
			return;
		}  catch(DataAccessException e){
			e.printStackTrace();
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response,"/Message.jsp");
		} catch (Exception e) {
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response,"/Message.jsp");
			return;
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
