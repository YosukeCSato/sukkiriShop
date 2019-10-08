package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountDAO dao = AccountDAO.getInstance();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		List<String> usersList = this.dao.getUsersList();

		request.setAttribute("usersList", usersList);

		String action = request.getParameter("action");

		if (action == null) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp");
			dispatcher.forward(request, response);

		} else if (action.equals("confirm")) {

			String userId = request.getParameter("userId");
			System.out.println(userId);

			request.setAttribute("userId", userId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteUser.jsp");
			dispatcher.forward(request, response);

		} else if (action.equals("delete")) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteUser.jsp");
			System.out.println(action);
			String userId = request.getParameter("userId");
			request.setAttribute("userId", userId);

			request.setAttribute("action", action);
			dispatcher.forward(request, response);
		}




	}

}
