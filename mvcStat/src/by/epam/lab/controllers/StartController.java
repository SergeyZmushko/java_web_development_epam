package by.epam.lab.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.factory.NumberFactory;
import by.epam.lab.exceptions.InitException;

import static by.epam.lab.utils.ConstantsJSP.*;

/**
 * Servlet implementation class StartController
 */
@WebServlet(urlPatterns = { "/start" }, 
			initParams = { 
					@WebInitParam(name = "min.size", value = "12"),
					@WebInitParam(name = "factory.number", value = "memory") 
			})
public class StartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException{
		super.init(sc);
		try {
			final int MIN_SIZE = Integer.parseInt(sc.getInitParameter("min.size"));
			NumberFactory.init(sc.getInitParameter("factory.number"));
			NumberDAO numberDAO = NumberFactory.getClassFromFactory();
			List<Double> numbers = numberDAO.getNumbers();
			if(numbers.size() < MIN_SIZE) {
				throw new InitException("Few numbers found " + numbers.size());
			}
			getServletContext().setAttribute(NUMBERS_NAME, numbers);
			getServletContext().setAttribute(MAX_VALUE_NAME, numbers.size());
		}catch(InitException e) {
			throw new ServletException(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strNumber = request.getParameter(NUMBER_NAME);
		int number = Integer.parseInt(strNumber);
		request.setAttribute(NUMBER_NAME, number);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(START_PAGE_URL);
		rd.forward(request, response);
	}
}
