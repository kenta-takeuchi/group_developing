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
import la.bean.ProductBean;
import la.bean.UpdateBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.dao.PostgreSQLOrderDetailDao;
import la.dao.PostgreSQLProductDao;

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

		//gotoPage(request, response,"/OrderUpdateView.jsp");
		// TODO Auto-generated method stub

		try {
			String order_id = request.getParameter("order_id");
			PostgreSQLOrderDetailDao detailDao = new PostgreSQLOrderDetailDao();
			List<UpdateBean> order_details = detailDao.findByUpdateCode(order_id);
			PostgreSQLProductDao productDao = new PostgreSQLProductDao();
			PostgreSQLOrderDao dao = new PostgreSQLOrderDao();
			CustomerBean customer_code = dao.findBycustomer_code(order_id);
			List<ProductBean> products = productDao.selectAll();
			request.setAttribute("order_details", order_details);
			request.setAttribute("order_id", order_id);
			request.setAttribute("products", products);
			request.setAttribute("customer_code", customer_code);
			gotoPage(request, response, "/OrderUpdate.jsp");
		}catch(DataAccessException e){
			e.printStackTrace();
			request.setAttribute("message", "エラー");
			gotoPage(request, response,"");
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
