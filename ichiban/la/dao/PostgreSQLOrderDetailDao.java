package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.UpdateBean;


public class PostgreSQLOrderDetailDao {
	private Connection con;

	public PostgreSQLOrderDetailDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

//	public List<OrderBean> select() throws DataAccessException {
//		PreparedStatement st = null;
//		ResultSet rs = null;

		public List<UpdateBean> findByUpdateCode(String orderCode) throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT p.name, od.quantity FROM product p JOIN order_detail od ON p.code = od.product_code WHERE od.order_id = ?";
				st = con.prepareStatement(sql);
				st.setString(1,orderCode);
				rs = st.executeQuery();

				List<UpdateBean> list = new ArrayList<UpdateBean>();
				while(rs.next()) {
					String productName = rs.getString("name");
					int quantity = rs.getInt("quantity");
					UpdateBean bean = new UpdateBean(orderCode, productName, quantity);
					list.add(bean);
				}
				return list;

//		try {
//			// SQL文の作成
//			String sql = "SELECT * FROM item";
//			// PreparedStatementオブジェクトの取得
//			st = con.prepareStatement(sql);
//			// SQLの実行
//			rs = st.executeQuery();
//			// 結果の取得および表示
//			return list;
		}catch (Exception e) {
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
//
//
//
//	public OrderDetailBean selectByOrderId(String order_id) throws DataAccessException {
//	}
//
//	public OrderDetailBean selectByProductCode(String product_code) throws DataAccessException {
//	}
//
//	public OrderDetailBean selectById(String order_id, String product_code) throws DataAccessException {
//	}
//
//	public Boolean update(String order_id, String product_code) throws DataAccessException {
//	}
//
//	public OrderDetailBean update(String id) throws DataAccessException {
//	}
//
//	public OrderDetailBean createOrderDetailFromResultSet(ResultSet rs) throws DataAccessException {
//	}
//	public updateTest(String code) {
//	if(con == null)
//		getConnetction();
//		PreparedStatement st = null;
//		ResultSet rs = null;
//
//
//
