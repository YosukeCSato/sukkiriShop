package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Account;

public class AccountDAO {

	private static AccountDAO dao = new AccountDAO();

	private AccountDAO() {

	}

	public static AccountDAO getInstance() {
		return dao;
	}

	public List<String> getUsersList() {
		Connection conn = null;
		List<String> userIdList = new ArrayList<String>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// DBに接続
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/ythe/Projects/sukkiriShop/sukkiriShop", "sa", "pass");

			// SELECT文を準備
			String sql = "SELECT USER_ID FROM ACCOUNT";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// パスワードを返却
			while(rs.next()) {
				// 結果表からデータを取得し、リストに追加する
				userIdList.add(rs.getString("USER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		// 取得したuserIdを格納したリストを返す
		return userIdList;

	}

	public String getPassword(String userId) {

		Connection conn = null;
		String pass = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// DBに接続
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/ythe/Projects/sukkiriShop/sukkiriShop", "sa", "pass");

			// SELECT文を準備
			String sql = "SELECT PASS FROM ACCOUNT WHERE USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// パスワードを返却
			if(rs.next()) {
				// 結果表からデータを取得
				pass = rs.getString("PASS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		// 見つかったpasswordまたはnullを返す
		return pass;

	}

	public Account findByUserId(String userId, String passwordInDB) {

		Connection conn = null;
		Account account = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// DBに接続
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/ythe/Projects/sukkiriShop/sukkiriShop", "sa", "pass");

			// SELECT文を準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				// 結果表からデータを取得
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				account = new Account(userId, passwordInDB, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		// 見つかったユーザーまたはnullを返す
		return account;
	}

	public Account createUser(Account account) {

		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// DBに接続
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/ythe/Projects/sukkiriShop/sukkiriShop", "sa", "pass");

			// INSERT文を準備
			String sql = "INSERT INTO account (user_id, pass, mail, name, age) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			// INSERTを実行
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
				e.printStackTrace();
				return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		// 見つかったユーザーまたはnullを返す

		return account;
	}

}
