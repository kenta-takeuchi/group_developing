package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.CustomerBean;

public class PostgreSQLCustomerDao {
	private Connection con;

	public PostgreSQLCustomerDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

	public List<CustomerBean> selectAll() throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT code, name FROM customer";
		// PreparedStatementオブジェクトの取得
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			// 結果の取得および表示

			List<CustomerBean> list = new ArrayList<CustomerBean>();
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				CustomerBean bean = new CustomerBean(code, name);
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

	public CustomerBean selectByCode(String customer_code) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT code, name FROM customer WHERE code = ?";
		// PreparedStatementオブジェクトの取得
		try {
			st = con.prepareStatement(sql);
			st.setString(1, customer_code);
			rs = st.executeQuery();
			// 結果の取得および表示
			CustomerBean bean = new CustomerBean();
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				bean.setCode(code);
				bean.setName(name);
			}
			return bean;
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