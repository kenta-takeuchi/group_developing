package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

public class ItemDAO {
	private Connection con;

	public ItemDAO() throws DAOException{
		getConnection();
	}

	public List<ItemBean> findAll() throws DAOException {
		if(con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM item;";
					st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code, name, price);
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new DAOException("レコードの取得に失敗しました。");
			}
		}
	}

		private void getConnection() throws DAOException {
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql:sample";
				String user = "student";
				String pass = "himitu";
				con = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				throw new DAOException("接続に失敗しました。");
			}
		}

		private void close() throws SQLException {
			if(con != null) {
				con.close();
				con = null;
			}
		}



	}
