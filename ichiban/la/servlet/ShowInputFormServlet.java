package la.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CustomerBean;
import la.bean.OrderDetailBean;
import la.bean.ProductBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLCustomerDao;
import la.dao.PostgreSQLProductDao;
import la.java.LoginManager;

@WebServlet("/ShowInputFormServlet")
public class ShowInputFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 一般従業員でログイン済みかチェック
		boolean flg = LoginManager.checkEmployee(request, response);
		if (flg == false) {
			return;
		}


		String action = request.getParameter("action");

		//formのactionがregistの場合の処理
		if (action.equals("regist")) {
			String customer_code = request.getParameter("customer_code");
			request.setAttribute("customer_code", customer_code);
			// 次のサーブレットに渡すリストを準備
			ArrayList<OrderDetailBean> list = new ArrayList<OrderDetailBean>();

			for (int cnt = 1; cnt < 11; cnt++) {
				// 前画面から渡された１明細ごとにBeanを作成し、リストに追加
				OrderDetailBean bean = new OrderDetailBean();

				//0以上の場合＝商品がある場合
				if (request.getParameter("quantity_" + cnt).length() > 0) {
				//順番にProduct_codeをセットする
					bean.setProduct_code(request.getParameter("product_code_" + cnt));
				//Product_codeをキャストする
					bean.setQuantity(Integer.parseInt(request.getParameter("quantity_" + cnt)));
					list.add(bean);
				}
			}

			PostgreSQLProductDao productDao = null;
			List<ProductBean> products = null;
			try {
				productDao = new PostgreSQLProductDao();
				products = productDao.selectAll();
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			request.setAttribute("products", products);

			request.setAttribute("list", list);
			gotoPage(request, response, "/OrderRegistConfirm.jsp");

		//formのactionがlistの場合の処理
		} else if (action.equals("list")) {
			PostgreSQLProductDao productDao = null;
			List<ProductBean> products = null;
			try {
				productDao = new PostgreSQLProductDao();
				products = productDao.selectAll();
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			PostgreSQLCustomerDao customerDao = null;
			List<CustomerBean> customers = null;
			try {
				customerDao = new PostgreSQLCustomerDao();
				customers = customerDao.selectAll();
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			request.setAttribute("customers", customers);
			request.setAttribute("products", products);

			gotoPage(request, response, "/OrderRegist.jsp");
		} else {
			gotoPage(request, response, "/OrderRegistError.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
