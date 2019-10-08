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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> usersList = this.dao.getUsersList();

		request.setAttribute("usersList", usersList);

		String action = request.getParameter("action");

		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("delete")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteUser.jsp");
			dispatcher.forward(request, response);
		}




	}

}
