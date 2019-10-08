package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bcrypt.PasswordGenerator;
import dao.AccountDAO;
import entity.Account;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountDAO dao = AccountDAO.getInstance();
	public PasswordGenerator pg = new PasswordGenerator();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		if (action == null) {
			this.confirmCreateAccount(request, response);
			return;
		}

		if (action.equals("confirm")) {
			this.createAccount(request, response);
			return;
		}
	}

	private void confirmCreateAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// この時点でパスワードをハッシュ化する
		String pass = pg.generatePassword(request.getParameter("pass"));
		Account account = this.parseAccountFromRequest(request, pass);

		// セッションスコープに入力された情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		// 内容確認画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
		dispatcher.forward(request, response);
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("pass");
		Account account = this.parseAccountFromRequest(request, pass);
		this.dao.createUser(account);
		// セッションスコープに新規作成したアカウントを保存
		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		// 登録完了画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registered.jsp");
		dispatcher.forward(request, response);

	}

	private Account parseAccountFromRequest(HttpServletRequest request, String pass) {

		String userId = request.getParameter("userId");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String ageString = request.getParameter("age");
		String errorMsg = this.checkInputValue(userId, ageString);

		HttpSession session = request.getSession();
		session.setAttribute("errorMsg", errorMsg);

		if (errorMsg == null) {
			int age = Integer.parseInt(ageString);
			return new Account(userId, pass, mail, name, age);
		}
		return null;
	}

	private String checkInputValue(String userId, String ageString) {

		List<String> userIdList = this.dao.checkUserId(userId);

		for(String s : userIdList) {
			if (s.equals(userId)) {
				return "入力されたユーザーIDは使用できません。";
			}
		}

		if (userId.length() > 20) {
			return "ユーザーIDは20文字以下にしてください。";
		}
		try {
			Integer.parseInt(ageString);
			return null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "年齢は数値を入力してください。";
		}

	}

}
