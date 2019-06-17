package la.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderTotalBean;
import la.java.CalcMonth;

public class PostgreSQLProductDao {
	private Connection con;

	public PostgreSQLProductDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

	public OrderBean selectById(String id) throws DataAccessException {
		return null;

	}

	public OrderBean selectByCustomerCode(String customer_code) throws DataAccessException {
		return null;
	}

	public OrderBean selectByEmployeeCode(String employee_code) throws DataAccessException {
		return null;
	}

	public List<OrderTotalBean> selectByOrderedDate(String year, String month) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;

		Date startDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
		} catch (ParseException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		}
		Date endDate = null;
		CalcMonth calc = new CalcMonth();

		try {
			endDate = calc.getNextMonth(startDate);
		} catch (ParseException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		java.sql.Date sqlStartDate = calc.CastToSQLDate(startDate);
		java.sql.Date sqlEndDate = calc.CastToSQLDate(endDate);

		try {

			// SQL文の作成
			String sql = "select this.code, this.name, this.sum_sales, pre.sum_sales, (this.sum_sales - pre.sum_sales) as result\r\n" +
					"FROM " +
					"SELECT p.code, p.name, sum(od.quantity) AS sum_sales FROM product p " +
					"JOIN order_detail od ON p.code = od.product_code " +
					"JOIN ‘order’ o ON od.order_id = o.id " +
					"WHERE o.ordered_date BETWEEN ? AND ? " +
					"GROUP BY p.code " +
					") this" +
					", " +
					"( " +
					"SELECT p.code, p.name, sum(od.quantity) AS sum_sales FROM product p " +
					"JOIN order_detail od ON p.code = od.product_code " +
					"JOIN ‘order’ o ON od.order_id = o.id " +
					"WHERE o.ordered_date BETWEEN ? AND ? " +
					"GROUP BY p.code " +
					")pre";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setDate(1, sqlStartDate);
			st.setDate(2, sqlEndDate);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<OrderTotalBean> list = new ArrayList<OrderTotalBean>();

			while (rs.next()) {
				java.sql.Date ordered_date = rs.getDate(1);
				int count_of_order_detail = rs.getInt(2);
				BigDecimal total_fee = rs.getBigDecimal(3);
				BigDecimal average_fee = rs.getBigDecimal(4);
				BigDecimal max_fee = rs.getBigDecimal(5);
				OrderTotalBean bean = new OrderTotalBean(ordered_date, count_of_order_detail, total_fee, average_fee, max_fee);
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの取得に失敗しました。");
		} finally {
			try {
				DBManager database = new DBManager();
				// リソースの開放
				if(rs != null) database.close(rs);
				if(st != null) database.close(st);
				database.close(con);
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

	public Boolean update(String id) throws DataAccessException {
		return null;
	}

	public Boolean createOrderFromResultSet(ResultSet rs) throws DataAccessException {
		return null;
	}
	public int nameUpdate(String productName) throws DataAccessException{
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "UPDATE product SET name = ?";
			st = con.prepareStatement(sql);
			st.setString(1,productName);
			//行数を返す。しかしこの行数は使用しない
			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの取得に失敗しました。");
		} finally {
			try {
				DBManager database = new DBManager();
				// リソースの開放
				if(rs != null) database.close(rs);
				if(st != null) database.close(st);
				database.close(con);
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

}
