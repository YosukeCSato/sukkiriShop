package test;

import dao.AccountDAO;
import entity.Account;
import entity.LoginUser;

public class AccountDAOTest {

	public static void main(String[] args) {

		testFindByLogin1();
		testFindByLogin2();
		test();

	}

	public static void testFindByLogin1() { // 正しいユーザーIDとパスワードでログインする

		LoginUser login = new LoginUser("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);

		if(result != null &&
				result.getUserId().contentEquals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("minato@sukkiri.com") &&
				result.getName().equals("湊　雄輔") &&
				result.getAge() == 23) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogin2() { // 正しいユーザーIDと間違ったパスワードでログインする

		LoginUser login = new LoginUser("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);

		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}

	public static void test() { // 正しいユーザーIDと間違ったパスワードでログインする

		Account account = new Account("aaaa", "aadfsasdf", "faffd", "fdaffd", 2);
		AccountDAO dao = new AccountDAO();
		Account result = dao.createUser(account);

		if(result == null) {
			System.out.println("test:成功しました");
		} else {
			System.out.println("test:失敗しました");
		}
	}

}
