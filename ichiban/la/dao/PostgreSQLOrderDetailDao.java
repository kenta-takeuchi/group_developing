package la.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderDetailBean;
import la.bean.UpdateBean;

public class PostgreSQLOrderDetailDao {
	private Connection con;
	private List<OrderBean> list;

	public PostgreSQLOrderDetailDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
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

	public int deleteByOrderId(String id) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			// SQL文の作成
			String sql = "DELETE FROM order_detail WHERE order_id = ?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setString(1, id);
			// SQLの実行
			int rows = st.executeUpdate();
			// 結果の取得および表示
			return rows;
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


	public List<OrderDetailBean> selectByOrderId(String order_id) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "SELECT * FROM order_detail WHERE order_id=?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setString(1,order_id);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<OrderDetailBean> list = new ArrayList<OrderDetailBean>();

			while (rs.next()) {
				String product_code = rs.getString("product_code");
				int quantity = rs.getInt("quantity");
				BigDecimal total_fee = rs.getBigDecimal("total_fee");
				OrderDetailBean bean = new OrderDetailBean(order_id, product_code, quantity, total_fee);
				System.out.println(order_id + ", " + product_code);
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


	public List<UpdateBean> findByUpdateCode(String order_id) throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT p.code, od.quantity FROM product p JOIN order_detail od ON p.code = od.product_code WHERE od.order_id = ?";
				st = con.prepareStatement(sql);
				st.setString(1,order_id);
				rs = st.executeQuery();

				List<UpdateBean> list = new ArrayList<UpdateBean>();
				int cnt = 10;
				while(rs.next()) {
					String code = rs.getString("code");
					int quantity = rs.getInt("quantity");
					UpdateBean bean = new UpdateBean(order_id, code, quantity);
					list.add(bean);
					cnt--;
				}

				for (int i=0; i < cnt; i++) {
					list.add(null);
				}

				return list;
			} catch (Exception e) {
					e.printStackTrace();
				throw new DataAccessException("レコードの取得に失敗しました。");
			}finally {
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

