package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		if(action == null) {
			String userId = request.getParameter("userId");
			String pass = request.getParameter("pass");
			String mail = request.getParameter("mail");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));

			Account account = new Account(userId, pass, mail, name, age);

			// セッションスコープに作成したアカウントを保存
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			// 内容確認画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp");
			dispatcher.forward(request, response);
		} else {
			Account account = (Account)request.getAttribute("account");
			AccountDAO dao = new AccountDAO();
			dao.CreateUser(account);

			System.out.println(account.getName());


			// 登録完了画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registered.jsp");
			dispatcher.forward(request, response);
		}

	}

}
