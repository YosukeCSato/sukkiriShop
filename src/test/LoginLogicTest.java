package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {

		testExecute1();
		testExecute2();
	}

	public static void testExecute1() {

		Login login = new Login("minato", "1234");
		LoginLogic bo = new LoginLogic();

		if (bo.execute(login)) {
			System.out.println("testExecute1:成功しました");
		} else {
			System.out.println("testExecute1:失敗しました");
		}
	}

	public static void testExecute2() {

		Login login = new Login("minato", "12345");
		LoginLogic bo = new LoginLogic();

		if (!bo.execute(login)) {
			System.out.println("testExecute2:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}

}
