package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bcrypt.PasswordGenerator;
import logic.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PasswordGenerator pg = new PasswordGenerator();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");


		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(userId, pass);

		// ログイン処理の成否によって処理を分岐

		if (result && userId.equals("admin")) { // Admin
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			dispatcher.forward(request, response);

		} else if (result) { // ログイン成功時

			// セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);

		} else { // ログイン失敗時

			//response.sendRedirect("/sukkiriShop/WelcomeServlet");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginNG.jsp");
			dispatcher.forward(request, response);

		}

	}

}
