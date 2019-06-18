package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import la.bean.OrderBean;
import la.bean.OrderDetailBean;
import la.bean.OrderTotalBean;
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

	public int insertOrder(OrderBean bean, ArrayList<OrderDetailBean> listDetail) throws DataAccessException {
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

			//従業員コードの取得


			//税込みの計算
			rs.close();
			int intSum = 0;
			for(int i = 0; i < listDetail.size(); i++){
				String tax = "select price from product where code = ?;";
				st = con.prepareStatement(tax);
				st.setString(1, listDetail.get(i).getProductCode());
				System.out.println("i:" + i);
				System.out.println("listDetail.get(i).getProductCode():" + listDetail.get(i).getProductCode());
				rs = st.executeQuery();
				rs.next();
				intSum = intSum + rs.getInt(1);
				rs.close();
			}
			int taxSum = (int)(intSum * 0.08);



			//登録日の取得


			//受注数の表示


			//受注合計額の計算



			//SQL文の作成
			String sql = "INSERT INTO ‘order’ VALUES(?, ?, ?, ?, ? ,? , ?);";
			st = con.prepareStatement(sql);
			st.setString(1, strTmp);
			st.setString(2, bean.getCustomer_code());
			st.setString(3, "0001");
			st.setDate(4, Date.valueOf("2019-06-18"));
			st.setInt(5, taxSum);
			st.setInt(6, 1);
			st.setInt(7, intSum);

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
