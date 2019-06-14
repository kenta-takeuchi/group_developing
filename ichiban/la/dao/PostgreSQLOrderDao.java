package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgreSQLOrderDao {
	private Connection con;

	public PostgreSQLOrderDao() throws DataAccessException {
		DBManager database = new DBManager();
		con = database.getConnection();
	}

//	public List<OrderBean> select() throws DataAccessException {
//		PreparedStatement st = null;
//		ResultSet rs = null;
//
//		try {
//			// SQL文の作成
//			String sql = "SELECT * FROM item";
//			// PreparedStatementオブジェクトの取得
//			st = con.prepareStatement(sql);
//			// SQLの実行
//			rs = st.executeQuery();
//			// 結果の取得および表示
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DataAccessException("レコードの取得に失敗しました。");
//		} finally {
//			try {
//				DBManager database = new DBManager();
//				// リソースの開放
//				if(rs != null) database.close(rs);
//				if(st != null) database.close(st);
//				database.close(con);
//			} catch (Exception e) {
//				throw new DataAccessException("リソースの開放に失敗しました。");
//			}
//		}
//	}


		
		

	}

//	public OrderBean selectById(String id) throws DataAccessException {
//	}
//
//	public OrderBean selectByCustomerCode(String customer_code) throws DataAccessException {
//	}
//
//	public OrderBean selectByEmployeeCode(String employee_code) throws DataAccessException {
//	}
//
//	public OrderBean selectByOrderedDate(Date ordered_date) throws DataAccessException {
//	}
//
//	public OrderBean selectById(String id) throws DataAccessException {
//	}
//
//	public Boolean update(String id) throws DataAccessException {
//	}
//
//	public  update(String id) throws DataAccessException {
//	}
//
//	public  createOrderFromResultSet(ResultSet rs) throws DataAccessException {
//	}
//

}
