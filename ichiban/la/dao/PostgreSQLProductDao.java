package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.OrderAnalyzeBean;
import la.bean.OrderBean;
import la.bean.ProductBean;
import la.java.CalcMonth;

public class PostgreSQLProductDao {
	private Connection con;

	public PostgreSQLProductDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

	public List<ProductBean> selectAll() throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT code, name FROM product";
		// PreparedStatementオブジェクトの取得
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			// 結果の取得および表示

			List<ProductBean> list = new ArrayList<ProductBean>();
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				ProductBean bean = new ProductBean(code, name);
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

	public OrderBean selectById(String id) throws DataAccessException {
		return null;

	}

	public OrderBean selectByCustomerCode(String customer_code) throws DataAccessException {
		return null;
	}

	public OrderBean selectByEmployeeCode(String employee_code) throws DataAccessException {
		return null;
	}

	public List<OrderAnalyzeBean> selectByProductId(String year, String month) throws DataAccessException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;

		Date thisDate = null;
		try {
			thisDate = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
		} catch (ParseException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		}

		Date nextDate = CalcMonth.getCalcMonth(thisDate, 1);
		Date preDate = CalcMonth.getCalcMonth(thisDate, -1);

		java.sql.Date sqlThisDate = CalcMonth.CastToSQLDate(thisDate);
		java.sql.Date sqlNextDate = CalcMonth.CastToSQLDate(nextDate);
		java.sql.Date sqlPreDate = CalcMonth.CastToSQLDate(preDate);

		try {

			// SQL文の作成
			String sql = "select this.code, this.name, this.sum_sales, pre.sum_sales, (this.sum_sales - pre.sum_sales) as result " +
					"FROM " +
					"( " +
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
					") pre";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setDate(1, sqlThisDate);
			st.setDate(2, sqlNextDate);
			st.setDate(3, sqlPreDate);
			st.setDate(4, sqlThisDate);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<OrderAnalyzeBean> list = new ArrayList<OrderAnalyzeBean>();

			while (rs.next()) {
				String product_code = rs.getString(1);
				String product_name = rs.getString(2);
				int this_quantity = rs.getInt(3);
				int pre_quantity = rs.getInt(4);
				int compare_quantity = rs.getInt(5);
				OrderAnalyzeBean bean = new OrderAnalyzeBean(product_code, product_name, this_quantity, pre_quantity, compare_quantity);
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
