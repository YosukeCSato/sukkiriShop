package logic;

import org.springframework.security.crypto.bcrypt.BCrypt;

import dao.AccountDAO;

public class LoginLogic {

	private AccountDAO dao = new AccountDAO();

//	public boolean execute(LoginUser login) {
//		AccountDAO dao = new AccountDAO();
//		Account account = dao.findByLogin(login);
//		return account != null; // nullでなければtrue、nullならfalseが返る
//	}

	public boolean execute(String userId, String pass) {
		String passwordInDB = this.dao.getPassword(userId);
		boolean checkPassword = BCrypt.checkpw(pass, passwordInDB);
		System.out.println(checkPassword);
		System.out.println(pass);
		System.out.println(passwordInDB);
		return checkPassword;
//		if (checkPassword) {
//			Account account = dao.findByUserId(userId, passwordInDB);
//			return account != null;
//		} else {
//			return false;
//		}

	}

}
