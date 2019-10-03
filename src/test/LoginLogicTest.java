package test;

import logic.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {

		testExecute1();
		testExecute2();
	}

	public static void testExecute1() {

		LoginLogic bo = new LoginLogic();

		if (bo.execute("minato", "1234")) {
			System.out.println("testExecute1:成功しました");
		} else {
			System.out.println("testExecute1:失敗しました");
		}
	}

	public static void testExecute2() {

		LoginLogic bo = new LoginLogic();

		if (!bo.execute("minato", "12345")) {
			System.out.println("testExecute2:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}

}
