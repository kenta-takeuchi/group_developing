package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CustomerBean;
import la.bean.OrderBean;
import la.bean.ProductBean;
import la.bean.UpdateBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLCustomerDao;
import la.dao.PostgreSQLOrderDao;
import la.dao.PostgreSQLOrderDetailDao;
import la.dao.PostgreSQLProductDao;
import la.java.LoginManager;

/**
 * Servlet implementation class ShowUpdateFormServlet
 */
@WebServlet("/ShowOrderUpdateFormServlet")
public class ShowOrderUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOrderUpdateFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			//OrderDetailから送られてきたorder_idを取得しorder_idに代入
			String order_id = request.getParameter("order_id");
			//OrderDaoのオブジェクト生成
			PostgreSQLOrderDao orderDao = new PostgreSQLOrderDao();
			//OrderBeanにorderDaoのselectByIDメソッドで取得したorder_idで受注テーブルのデータを検索し代入する
			OrderBean bean = orderDao.selectByID(order_id);
			//OrderBeanのgetCustomer_codeメソッドでcustomer_codeを取得する
			String customer_code = bean.getCustomer_code();

			//DetailDaoのオブジェクトを作成
			PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
			//detailDaoのfindByUpdateCodeメソッドでorder_idによって、
			//アップデートで必要なのデータを検索しList型の入するUpdateBeanに代入する
			List<UpdateBean> order_details = detailDao.findByUpdateCode(order_id);

			//商品テーブルからデータを取得する
			PostgreSQLProductDao productDao = new PostgreSQLProductDao();
			List<ProductBean> products = productDao.selectAll();

			PostgreSQLCustomerDao customerDao = null;
			List<CustomerBean> customers = null;
			try {
				customerDao = new PostgreSQLCustomerDao();
				customers = customerDao.selectAll();
			} catch (DataAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}


			//OrderUpdate.jspで表示させるために必要な情報を送る
			request.setAttribute("order_id", order_id);
			request.setAttribute("customer_code", customer_code);
			request.setAttribute("customers", customers);
			request.setAttribute("order_details", order_details);
			request.setAttribute("products", products);
			gotoPage(request, response, "/OrderUpdate.jsp");
		//データが取得できなかった時のエラー
		}catch(DataAccessException e){
			e.printStackTrace();
			request.setAttribute("message", "データが取得できませんでした。");
			gotoPage(request, response,"Message.jsp");
		}finally {

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
