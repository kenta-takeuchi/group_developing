package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.UpdateBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
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
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");

			if(action == null || action.length() == 0 || action.equals("")) {
				request.setAttribute("message", "エラー");
			}else if(action.equals("regist")) {
				String code = request.getParameter("code");
				String productName = request.getParameter("productName");
				int quantity = Integer.parseInt(request.getParameter("quantity"));

				PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
				PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
				request.setAttribute("code", code);
				UpdateBean bean = new UpdateBean();
				bean.setOrderCode(code);
				bean.setProductName(productName);
				bean.setQuantity(quantity);


				List<UpdateBean> list = detailDao.findByUpdateCode(code);
				request.setAttribute("items", list);
				gotoPage(request, response, "/MainMenu.jsp");
			}
		}catch(DataAccessException e){
			e.printStackTrace();
			request.setAttribute("message", "エラー");
			gotoPage(request, response,"");
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
