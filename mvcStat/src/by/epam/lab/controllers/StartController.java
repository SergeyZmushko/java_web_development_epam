package by.epam.lab.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.lab.utils.ConstantsJSP.*;

/**
 * Servlet implementation class StartController
 */
@WebServlet("/start")
public class StartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String refferer = request.getHeader(HEADER_NAME);
		if (refferer == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String number = request.getParameter(NUMBER_NAME);
		request.setAttribute(NUMBER_NAME, Integer.parseInt(number) - 1);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(START_PAGE_URL);
		rd.forward(request, response);
	}

}
