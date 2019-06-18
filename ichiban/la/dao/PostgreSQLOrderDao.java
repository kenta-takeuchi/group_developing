package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderTotalBean;
import la.bean.SearchResultBean;
import la.java.CalcMonth;

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

	public List<SearchResultBean> select(String add_sql) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			// SQL文の作成
			String sql = "SELECT * FROM ‘order’ WHERE 1=1" + add_sql;
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<SearchResultBean> list = new ArrayList<SearchResultBean>();

			while (rs.next()) {
				String id = rs.getString("id");
				java.sql.Date ordered_date = rs.getDate("ordered_date");
				String customer_code = rs.getString("customer_code");
				String employee_code = rs.getString("employee_code");
				SearchResultBean bean = new SearchResultBean(id, ordered_date, customer_code, employee_code);
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


	public List<OrderTotalBean> selectByOrderedDate(String year, String month) throws DataAccessException, ParseException {

		PreparedStatement st = null;
		ResultSet rs = null;

		Date thisDate = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");

		System.out.println(0);
		Date nextDate = CalcMonth.getCalcMonth(thisDate, 1);

		System.out.println(1);

		java.sql.Date sqlThisDate = CalcMonth.CastToSQLDate(thisDate);
		java.sql.Date sqlNextDate = CalcMonth.CastToSQLDate(nextDate);
		System.out.println(2);

		System.out.println(sqlThisDate);
		System.out.println(sqlNextDate);

		try {

			// SQL文の作成
			String sql = "SELECT ordered_date, count(*), sum(total_fee), avg(total_fee), max(total_fee) FROM ‘order’ WHERE ordered_date BETWEEN ? AND ? GROUP BY ordered_date";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setDate(1, sqlThisDate);
			st.setDate(2, sqlNextDate);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示

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

	public int deleteById(String id) throws DataAccessException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			// SQL文の作成
			String sql = "DELETE FROM ‘order’ WHERE id = ?";
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
				if(rs != null) database.close(rs);
				if(st != null) database.close(st);
				database.close(con);
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

}
