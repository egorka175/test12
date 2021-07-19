package Homeworl_27_TMS.web.servlet;

import Homeworl_27_TMS.entity.Operation;
import Homeworl_27_TMS.entity.User;
import Homeworl_27_TMS.service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

	private final CalcService calcService = new CalcService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double num1 = Double.parseDouble(req.getParameter("num1"));
		double num2 = Double.parseDouble(req.getParameter("num2"));
		String operation = req.getParameter("operation");
		Operation calc = calcService.calc(num1, num2, operation);
		req.setAttribute("rez2", "Result"+calc);
		getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
	}

}
