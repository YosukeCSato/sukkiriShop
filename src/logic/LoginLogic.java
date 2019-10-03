package logic;

import dao.AccountDAO;
import entity.Account;
import entity.LoginUser;

public class LoginLogic {

	public boolean execute(LoginUser login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null; // nullでなければtrue、nullならfalseが返る
	}

}
