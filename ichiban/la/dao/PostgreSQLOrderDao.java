package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderTotalBean;

public class PostgreSQLOrderDao {
	private Connection con;

	public PostgreSQLOrderDao() throws DataAccessException {
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


			List<OrderTotalBean> list = new ArrayList<OrderTotalBean>();

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

	public int insertOrder(OrderBean bean) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int intRet = -1;

		try {
			// idの最大値を取得する
			String max = "select max(cast(id as integer)) from ‘order’;";
			st = con.prepareStatement(max);
			rs = st.executeQuery();

			rs.next();
			int intMax = rs.getInt(1) + 1;

			// 0文字付加
			int intTmp = intMax;
			String strTmp = ("0000" + intTmp);
			//System.out.println("b4 strTmp:" + strTmp);
			strTmp = strTmp.substring(strTmp.length() - 4, strTmp.length());
			//System.out.println("af strTmp:" + strTmp);



			//SQL文の作成
			String sql = "INSERT INTO ‘order’ VALUES(?, ?, ?, ?, ? ,? , ?);";
			st = con.prepareStatement(sql);
			st.setString(1, strTmp);
			st.setString(2, bean.getCustomer_code());
			st.setString(3, "0001");
			st.setDate(4, Date.valueOf("2019-06-17"));
			st.setInt(5, 1);
			st.setInt(6, 1);
			st.setInt(7, 1);

			//SQLの実行
			intRet = st.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの追加に失敗しました");
		}

		return intRet;
	}

}
