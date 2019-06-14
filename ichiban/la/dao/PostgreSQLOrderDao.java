package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.OrderBean;

public class PostgreSQLOrderDao {
	private Connection con;

	public PostgreSQLOrderDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

	public List<OrderBean> select() throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// SQL文の作成
			String sql = "SELECT * FROM item";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<OrderBean> list = new ArrayList<OrderBean>();
			while (rs.next()) {
				String id = rs.getString("id");
				String customer_code = rs.getString("customer_code");
				String employee_code = rs.getString("employee_code");
				java.sql.Date ordered_date = rs.getDate("ordered_date");
				java.math.BigDecimal tax = rs.getBigDecimal("tax");
				int count_of_order_detail = rs.getInt("count_of_order_detail");
				java.math.BigDecimal total_fee = rs.getBigDecimal("total_fee");
				OrderBean bean = new OrderBean(id, customer_code, employee_code, ordered_date, tax,
						count_of_order_detail, total_fee);
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
				if (rs != null)
					database.close(rs);
				if (st != null)
					database.close(st);
				database.close(con);
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}




	public OrderBean selectByCustomerCode(String customer_code) throws DataAccessException {
	}

	public OrderBean selectByEmployeeCode(String employee_code) throws DataAccessException {
	}

	public OrderBean selectByOrderedDate(Date ordered_date) throws DataAccessException {
	}

	public OrderBean selectById(String id) throws DataAccessException {
	}

/*	public Boolean update(String id) throws DataAccessException {
	}

	public  update(String id) throws DataAccessException {
	}

	public  createOrderFromResultSet(ResultSet rs) throws DataAccessException {
	}

*/
