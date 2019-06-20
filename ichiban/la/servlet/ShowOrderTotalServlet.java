package la.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.OrderTotalBean;
import la.dao.DataAccessException;
import la.dao.PostgreSQLOrderDao;
import la.java.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ShowOrderTotalServlet")
public class ShowOrderTotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOrderTotalServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 管理者でログインしているかチェック
		boolean flg = LoginManager.checkAdmin(request, response);
		if (flg == false) {
			return;
		}

		String year = request.getParameter("year");
		String month = request.getParameter("month");

		PostgreSQLOrderDao dao = null;

		try {
			dao = new PostgreSQLOrderDao();

		} catch (DataAccessException e1) {
			e1.printStackTrace();
		}

		try {
			List<OrderTotalBean> list = dao.selectByOrderedDate(year, month);

			// 集計対象月ごとの合計金額と受注件数を計算する
			BigDecimal total_fee = BigDecimal.valueOf(0);
			int count_of_order_detail = 0;

			for (OrderTotalBean bean: list) {
				total_fee = total_fee.add(bean.getTotal_fee());
				count_of_order_detail += bean.getCount_of_order_detail();
			}

			// リクエストスコープに情報追加
			request.setAttribute("order_totals", list);
			request.setAttribute("total_fee", total_fee);
			request.setAttribute("count_of_order_detail", count_of_order_detail);

			gotoPage(request,response, "/orderTotal.jsp");

		} catch (DataAccessException e) {
			e.printStackTrace();
			request.setAttribute("message", "データベースと接続できず集計できませんでした。");
			gotoPage(request, response,"/AdminMessage.jsp");

		} catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response,"/AdminMessage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
