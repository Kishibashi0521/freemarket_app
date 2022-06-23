package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.*;

public class SalesDAO {
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

//	売上げ情報全件取得
	public ArrayList<Sales> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Sales> list = new ArrayList<Sales>();
		try {
			String sql = "select * from salesinfo";

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Sales s = new Sales();
				s.setSalesid(rs.getInt("salesid"));
				s.setUserid(rs.getString("userid"));
				s.setItemid(rs.getInt("itemid"));
				s.setSalesDate(rs.getDate("salesdate"));
				s.setSend(rs.getString("send"));
				s.setPayment(rs.getString("payment"));
				s.setTransaction(rs.getString("transaction_completed"));

				list.add(s);
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

//	売上げ登録
	public void insert(Sales sales) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "insert into salesinfo values(NULL, '" + sales.getUserid() + "'," + sales.getItemid() + ","
					+ sales.getSalesDate() + ",'" + sales.getSend() + "','" + sales.getPayment() + "','"
					+ sales.getTransaction() + "'";
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

//	該当ユーザーの売上or購入情報取得
	public  ArrayList<Sales> selectByUser(User user) {
		Connection con = null;
		Statement smt = null;

		ArrayList<Sales> list = new ArrayList<Sales>();
		try {
			String sql = "select * from salesinfo where userid = '" + user.getUserid() + "'";

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Sales s = new Sales();
				s.setSalesid(rs.getInt("salesid"));
				s.setUserid(rs.getString("userid"));
				s.setItemid(rs.getInt("itemid"));
				s.setSalesDate(rs.getDate("salesdate"));
				s.setSend(rs.getString("send"));
				s.setPayment(rs.getString("payment"));
				s.setTransaction(rs.getString("transaction_completed"));

				list.add(s);
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



//	発送、入金、受取時の 0→1 (前→済)変更処理
	public void to_send(Sales sales) {
		Connection con = null;
		Statement smt = null;

		try {
			String sql =  "update salesinfo set send = '1' where itemid  = " + sales.getSalesid();

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

	public void to_payment(Sales sales) {
		Connection con = null;
		Statement smt = null;

		try {
			String sql =  "update salesinfo set payment = '1' where itemid  = " + sales.getSalesid();
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

	public void to_transaction(Sales sales) {
		Connection con = null;
		Statement smt = null;

		try {
			String sql =  "update salesinfo set transaction_completed = '1' where itemid  = " + sales.getSalesid();
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

}
