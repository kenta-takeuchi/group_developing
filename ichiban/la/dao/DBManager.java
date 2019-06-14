package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	private String DRIVER = "org.postgresql.Driver";
	private String URL = "jdbc:postgresql:ichiban";
	private String USER  = "ichiban";
	private String PASS = "ichiban";

	public Connection getConnection() throws DataAccessException {
		try {
			Connection conn;
			// JDBCドライバの登録
			Class.forName(DRIVER);
			// URL、ユーザ名、パスワードの設定
			// データベースへの接続
			conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("接続に失敗しました。");
		}

	}

	public void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public void close(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	public void close(Statement stmt, Connection conn) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void close(ResultSet rs,Statement stmt, Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

}
