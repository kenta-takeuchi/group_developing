package la.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;;


public class InsertTest {

	public static void main(String[] args) {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			// データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql =
					"INSERT INTO emp(code, name, age, tel) VALUES(7, '半田', 24, '0120-117-117')";
			PreparedStatement st = con.prepareStatement(sql);
			int rows = st.executeUpdate();
			System.out.println(rows + "件、データベースに追加しました。");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
