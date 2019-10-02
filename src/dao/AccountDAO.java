package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	public Account findByLogin(Login login) {

		Connection conn = null;
		Account account = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// DBに接続
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/ythe/Projects/sukkiriShop/sukkiriShop", "sa", "pass");

			// SELECT文を準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID=? AND PASS=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				// 結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				account = new Account(userId, pass, mail, name, age);
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
			System.out.println("INSERTをジッコゥしました");

		} catch (SQLException e) {
			System.out.println("????????????");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("!!!!!!!!!!!!!");
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
