package la.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderDetailBean;
import la.bean.ProductBean;
import la.bean.UpdateBean;

public class PostgreSQLOrderDetailDao {
	private Connection con;
	private List<OrderBean> list;

	public PostgreSQLOrderDetailDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

	public int insertOrderDetail(ArrayList<OrderDetailBean> listDetail) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int intRet = -1;

		try {

			for (OrderDetailBean bean: listDetail) {
				//SQL文の作成
				String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?);";
				st = con.prepareStatement(sql);
				st.setString(1, bean.getOrder_id());
				st.setString(2, bean.getProduct_code());
				st.setInt(3, bean.getQuantity());

				PostgreSQLProductDao productDao = new PostgreSQLProductDao();
				String product_code = bean.getProduct_code();
				ProductBean productBean = productDao.selectByProductId(product_code);
				BigDecimal total_fee = BigDecimal.valueOf(bean.getQuantity() * productBean.getPrice());
				st.setBigDecimal(4, total_fee);
				//SQLの実行
				intRet = st.executeUpdate();
			}

			return intRet;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの追加に失敗しました");
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


	public int insertOrderDetail(ArrayList<OrderDetailBean> listDetail, String order_id) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int intRet = -1;

		try {

			for (OrderDetailBean bean: listDetail) {
				//SQL文の作成
				String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?);";
				st = con.prepareStatement(sql);
				st.setString(1, order_id);
				st.setString(2, bean.getProduct_code());
				st.setInt(3, bean.getQuantity());

				PostgreSQLProductDao productDao = new PostgreSQLProductDao();
				String product_code = bean.getProduct_code();
				ProductBean productBean = productDao.selectByProductId(product_code);
				BigDecimal total_fee = BigDecimal.valueOf(bean.getQuantity() * productBean.getPrice());
				st.setBigDecimal(4, total_fee);
				//SQLの実行
				intRet = st.executeUpdate();
			}

			return intRet;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの追加に失敗しました");
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


	//ShowOrderUpdateFormから取得した情報からOrderUpdate.jspで必要なデータを取得する
	public List<UpdateBean> findByUpdateCode(String order_id) throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				//order_detailと‘order’からproduct_code、od.quantity、o.customer_codeを取得する
				String sql = "SELECT product_code, quantity FROM order_detail WHERE order_id = ?";
				st = con.prepareStatement(sql);
				st.setString(1,order_id);
				rs = st.executeQuery();

				List<UpdateBean> list = new ArrayList<UpdateBean>();
				//受注明細の数だけorderCountを引くため
				int orderCount = 10;
				while(rs.next()) {
					String product_code = rs.getString("product_code");
					int quantity = rs.getInt("quantity");
					UpdateBean bean = new UpdateBean(order_id, product_code, quantity);
					list.add(bean);
					//Listの数からorderCount（10）を引き、OrderUpdat.jspで10個の情報を表示させる
					orderCount--;
				}

				//Listが10になるまでnullを入れるため
				for (int i=0; i < orderCount; i++) {
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

