package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.*;

public class UserDAO {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/rakuhandb";
	private static String USER = "root";
	private static String PASSWD = "root123";

//		DBコネクション
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

//		ユーザー登録
	public void insert(User user) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "insert into userinfo values(" + user.getUserid() + "', '" + user.getPassword() + "','"
					+ user.getAuthority() + "','" + user.getName() + "', '" + user.getNickname() + "' ,'"
					+ user.getAddress() + "','" + user.getEmail() + "','" + user.getCreated_at() + "','"
					+ user.getUpdated_at() + "'";
			con = getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);

			con.close();
			smt.close();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

//	ユーザー情報全件取得(一覧機能)
	public ArrayList<User> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<User> list = new ArrayList<User>();
		try {
			String sql = "select * from userinfo";

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				User u = new User();
				u.setUserid(rs.getString("userid"));
				u.setPassword(rs.getString("password"));
				u.setAuthority(rs.getString("authority"));
				u.setName(rs.getString("name"));
				u.setNickname(rs.getString("nickname"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setCreated_at(rs.getDate("created_at"));
				u.setUpdated_at(rs.getDate("updated_at"));

				list.add(u);
			}

			smt.close();
			con.close();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;
	}

//	ユーザー情報1件取得(詳細機能)
	public User selectByUserid(String userid) {
		Connection con = null;
		Statement smt = null;

		User user = new User();

		try {
			String sql = "SELECT * FROM userinfo WHERE userid = '" + userid + "'";
			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setName(rs.getString("name"));
				user.setNickname(rs.getString("nickname"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setCreated_at(rs.getDate("created_at"));
				user.setUpdated_at(rs.getDate("updated_at"));
			}

			con.close();
			smt.close();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return user;
	}

//	ユーザー削除
	public void delete(String userid) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "delete  FROM userinfo WHERE userid = '" + userid + "'";
			con = getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);

			smt.close();
			con.close();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

//	ユーザー情報更新
	public void update(User user) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "update userinfo set password = '" + user.getPassword() + "', authority = '"
					+ user.getAuthority() + "', name = '" + user.getName() + "' , nickname = '" + user.getNickname()
					+ "', address= '" + user.getAddress() + "' email= '" + user.getEmail() + "', updated_at= ' "
					+ user.getUpdated_at() + "' where userid  = '" + user.getUserid() + "'";

			con = getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);

			smt.close();
			con.close();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
