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

import la.bean.UpdateBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDetailDao;



/**
 * Servlet implementation class ShowUpdateFormController
 */
@WebServlet("/OrderUpdateServlet")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     *
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	 public UpdateServlet() {
//	        super();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");

			if(action == null || action.length() == 0 || action.equals("")) {
				request.setAttribute("message", "エラー");
			}else if(action.equals("regist")) {
				String order_id = request.getParameter("order_id");

				String product_name = request.getParameter("product_name");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();

				List<UpdateBean> order_details = new ArrayList<UpdateBean>();
				UpdateBean bean;
				for (int i=0; i<10; i++) {
					String cnt = request.getParameter("quantity_" + i);
					//cntが空っぽだったら次の処理へ
					if ((cnt == null) || (cnt.length() == 0)) {
						continue;
					}else if ((cnt != null) || (cnt.length() >= 0))
						try {
							//既存のデータを消去する処理
							detailDao.deleteByOrderId(order_id);

							Integer.parseInt(cnt);
							bean = new UpdateBean(order_id, product_name, quantity);
							order_details.add(bean);
							} catch (Exception e) {
								request.setAttribute("message", "正しく操作してください");
								gotoPage(request, response,"/Message.jsp");
								return;
					}

					//resistOrderDetailは仮名、登録するメソッド名
					detailDao.resistOrderDetail(order_details);


					request.setAttribute("message", "更新しました。");
					gotoPage(request, response,"/Message.jsp");
				}






				// DAOに接続してください



//				detailDao.(code);
//
//
//				PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
//				detailDao.quantityUpdate(quantity);
//
////				if(code != null || productName != null || quantity > 0) {
////
////				}
//
//				//得意先コードを変更
//				PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
//				dao.codeUpdate(code);
//
//
//				PostgreSQLProductDao productDao = new PostgreSQLProductDao();
//				productDao.nameUpdate(productName);
//
//				//商品数量を変更





			}
		}catch(DataAccessException e){
			e.printStackTrace();
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response,"/Message.jsp");
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
