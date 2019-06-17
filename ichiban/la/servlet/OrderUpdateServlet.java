package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.dao.PostgreSQLOrderDetailDao;
import la.dao.PostgreSQLProductDao;



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
				String code = request.getParameter("code");
				String productName = request.getParameter("productName");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if(code != null || productName != null || quantity > 0) {

				}

				//受注コードを変更
				PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
				dao.codeUpdate(code);

				//商品名を変更
				PostgreSQLProductDao productDao = new PostgreSQLProductDao();
				productDao.nameUpdate(productName);

				//商品数量を変更
				PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
				detailDao.quantityUpdate(quantity);


				request.setAttribute("message", "更新しました。");
				gotoPage(request, response,"/Message.jsp");

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
