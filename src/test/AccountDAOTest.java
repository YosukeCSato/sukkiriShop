package test;

import dao.AccountDAO;
import entity.Account;

public class AccountDAOTest {

	public static void main(String[] args) {

		testFindByUserId1();
		testFindByUserId2();
		test();

	}

	public static void testFindByUserId1() { // 正しいユーザーIDとパスワードでログインする

		AccountDAO dao = AccountDAO.getInstance();
		Account result = dao.findByUserId("minato", "1234");

		if(result != null &&
				result.getUserId().contentEquals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("minato@sukkiri.com") &&
				result.getName().equals("湊　雄輔") &&
				result.getAge() == 23) {
			System.out.println("testFindByUserID1:成功しました");
		} else {
			System.out.println("testFindByUserId1:失敗しました");
		}
	}

	public static void testFindByUserId2() { // 正しいユーザーIDと間違ったパスワードでログインする

		AccountDAO dao = AccountDAO.getInstance();
		Account result = dao.findByUserId("minato", "12345");

		if(result == null) {
			System.out.println("testFindByUserId2:成功しました");
		} else {
			System.out.println("testFindByUserId2:失敗しました");
		}
	}

	public static void test() { // 正しいユーザーIDと間違ったパスワードでログインする

		Account account = new Account("aaaa", "aadfsasdf", "faffd", "fdaffd", 2);
		AccountDAO dao = AccountDAO.getInstance();
		Account result = dao.createUser(account);

		if(result == null) {
			System.out.println("test:成功しました");
		} else {
			System.out.println("test:失敗しました");
		}
	}

}
