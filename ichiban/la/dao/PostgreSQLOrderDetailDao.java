package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderDetailBean;


public class PostgreSQLOrderDetailDao {
	private Connection con;
	private List<OrderBean> list;

	public PostgreSQLOrderDetailDao() throws DataAccessException {
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



	public OrderDetailBean selectByOrderId(String order_id) throws DataAccessException {
		return null;
	}

	public OrderDetailBean selectByProductCode(String product_code) throws DataAccessException {
		return null;
	}

	public OrderDetailBean selectById(String order_id, String product_code) throws DataAccessException {
		return null;
	}

	public Boolean update(String order_id, String product_code) throws DataAccessException {
		return null;
	}

	public OrderDetailBean update(String id) throws DataAccessException {
		return null;
	}

	public OrderDetailBean createOrderDetailFromResultSet(ResultSet rs) throws DataAccessException {
		return null;
	}

}
