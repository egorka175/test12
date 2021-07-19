package Homeworl_27_TMS.web.servlet;

import Homeworl_27_TMS.entity.User;
import Homeworl_27_TMS.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private final UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(name, username, password);
		boolean add = userService.add(user);

		if (add){
			req.setAttribute("rez" ,"Ok");
		} else {
			req.setAttribute("rez" ,"Error");
		}
		getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);


	}
}
