package la.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;;



public class Lesson10_3_2 {

	public static void main(String[] args) {
		int code = Integer.parseInt(args[0]);
		String name = args[1];
		int age = Integer.parseInt(args[2]);
		String tel = args[3];

		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			// データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			String sql =
					"INSERT INTO emp(code, name, age, tel) VALUES(?, ?, ?, ?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, code);
			st.setString(2, name);
			st.setInt(3, age);
			st.setString(4, tel);

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
