package logic;

import dao.AccountDAO;
import entity.Account;

public class LoginLogic {

//	public boolean execute(LoginUser login) {
//		AccountDAO dao = new AccountDAO();
//		Account account = dao.findByLogin(login);
//		return account != null; // nullでなければtrue、nullならfalseが返る
//	}

	public boolean execute(String userId, String pass) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByUserId(userId, pass);
		return account != null;

	}

}
