package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Item;

public class ItemDAO {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/rakuhandb";
	private static String USER = "root";
	private static String PASSWD = "root123";

//	DBコネクション
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

//	出品登録
	public static void insert(Item item) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "insert into iteminfo values(NULL, '" + item.getUserid() + "','" + item.getItemname() + "','"
					+ item.getType() + "', " + item.getPrice() + " ,'" + item.getComment() + "','" + item.getStatus()
					+ "'," + item.getCreate_at() + "," + item.getUpdate_at();
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

//	出品情報全件取得
	public static ArrayList<Item> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Item> list = new ArrayList<Item>();
		try {
			String sql = "select * from iteminfo";

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Item item = new Item();
				item.setItemid(rs.getInt("itemid"));
				item.setUserid(rs.getString("userid"));
				item.setItemname(rs.getString("itemname"));
				item.setType(rs.getString("type"));
				item.setPrice(rs.getInt("price"));
				item.setComment(rs.getString("comment"));
				item.setCreated_at(rs.getDate("created_at"));
				item.setUpdated_at(rs.getDate("update_at"));

				list.add(item);
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

//	出品情報1件取得
	public static Item selectByItemid(int itemid) {
		Connection con = null;
		Statement smt = null;

		Item item = new Item();

		try {
			String sql = "SELECT * FROM iteminfo WHERE itemid = " + itemid + "";
			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				item.setItemid(rs.getInt("itemid"));
				item.setUserid(rs.getString("userid"));
				item.setItemname(rs.getString("itemname"));
				item.setType(rs.getString("type"));
				item.setPrice(rs.getInt("price"));
				item.setComment(rs.getString("comment"));
				item.setCreated_at(rs.getDate("created_at"));
				item.setUpdated_at(rs.getDate("update_at"));
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
		return item;
	}

//	出品削除
	public void delete(int itemid) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "delete  FROM iteminfo WHERE itemid = " + itemid;
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

//	出品更新
	public void update(Item item) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "update iteminfo set itemname = '" + item.getItemname() + "', type = '" + item.getType()
					+ "', price = " + item.getPrice() + " , comment = '" + item.getComment() + "', status= '"
					+ item.getStatus() + "', updated_at=  " + item.getUpdate_at() + "where itemid  = "
					+ item.getItemid();

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
