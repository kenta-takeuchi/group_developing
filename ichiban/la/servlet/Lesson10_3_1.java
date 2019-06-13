package la.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Lesson10_3_1 {

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
					"SELECT * FROM emp ORDER BY age";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				System.out.print(rs.getInt("code") + ":");
				System.out.print(rs.getString("name") + ":");
				System.out.print(rs.getInt("age") + ":");
				System.out.println(rs.getString("tel") + ":");
			}


			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
