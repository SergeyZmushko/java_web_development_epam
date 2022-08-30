package by.epam.lab.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import by.epam.lab.model.Operation;

import static by.epam.lab.utils.ConstantsJSP.*;

/**
 * Servlet implementation class ResultController
 */
@WebServlet("/result")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 2L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operatName = request.getParameter(OPERATION_NAME);
		String[] strId = request.getParameterValues(STAT_NAME);
		
		List<Double> numbers = (List<Double>) request.getServletContext().getAttribute(NUMBERS_NAME);
		
		double[] stats = Arrays.stream(strId)
				.mapToInt(Integer::parseInt)
				.mapToDouble(numbers::get)
				.toArray();

		Operation operation = Operation.valueOf(operatName.toUpperCase());

		double result = operation.result(stats);

		request.setAttribute(RESULT_NAME, result);
		request.setAttribute(OPERATION_NAME, operation.name().toLowerCase());
		request.setAttribute(STAT_NAME, stats);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(RESULT_PAGE_URL);
		rd.forward(request, response);
	}
}