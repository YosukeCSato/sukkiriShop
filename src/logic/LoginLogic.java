package logic;

import org.springframework.security.crypto.bcrypt.BCrypt;

import dao.AccountDAO;

public class LoginLogic {

	private AccountDAO dao = AccountDAO.getInstance();

	public boolean execute(String userId, String pass) {
		String passwordInDB = this.dao.getPassword(userId);

		boolean checkPassword = BCrypt.checkpw(pass, passwordInDB);
		System.out.println(checkPassword);
		System.out.println(pass);
		System.out.println(passwordInDB);
		return checkPassword;

	}

}
