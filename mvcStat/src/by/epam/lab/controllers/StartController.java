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
import by.epam.lab.controllers.factory.impl.NumberFactory;
import by.epam.lab.exceptions.InitException;
import by.epam.lab.exceptions.InitRuntimeException;

import static by.epam.lab.utils.ConstantsDAO.MAX_NUMBER;
import static by.epam.lab.utils.ConstantsDAO.MIN_NUMBER;
import static by.epam.lab.utils.ConstantsJSP.*;

/**
 * Servlet implementation class StartController
 */
/*
 * Change value of "factory.number" parameter to chose different implementation.
 * "MEMORY_INITIALIZATION_PARAM" - for memory implementation;
 * "DB_INITIALIZATION_PARAM" - for database implementation;
 * "CSV_INITIALIZATION_PARAM" - for csv implementation;
 * 
 */
@WebServlet(urlPatterns = { "/start" }, initParams = {
		@WebInitParam(name = MIN_SIZE_NUMBERS, value = MIN_SIZE_NUMBERS_VALUE),
		@WebInitParam(name = FACTORY_NUMBER, value = CSV_INITIALIZATION_PARAM) })
public class StartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		try {
			final int MIN_SIZE = Integer.parseInt(sc.getInitParameter(MIN_SIZE_NUMBERS));
			try {
				NumberFactory.init(sc);
			} catch (InitRuntimeException e) {
				throw new InitException(LOAD_DB_DRIVER_ERROR);
			}
			
			NumberDAO numberDAO = NumberFactory.getClassFromFactory();
			List<Double> numbers = numberDAO.getNumbers().stream()
					.filter(i -> i <= MAX_NUMBER && i >= MIN_NUMBER)
					.toList();

			if (numbers.size() < MIN_SIZE) {
				throw new InitException(NUMBERS_FOUND + numbers.size());
			}
			getServletContext().setAttribute(NUMBERS_NAME, numbers);
			getServletContext().setAttribute(MAX_VALUE_NAME, numbers.size());
		} catch (InitException e) {
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
