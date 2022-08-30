package by.epam.lab.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import by.epam.lab.utils.ConstantsJSP;

/**
 * Servlet Filter implementation class ServletSecurityFilter
 */
@WebFilter({ "/result", "/start" })
public class TypedUrlFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String refferer = httpRequest.getHeader(ConstantsJSP.REFERER_HEADER);
		if (refferer == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}

	public void init(Filter fConfig) throws ServletException{
	}

	public void destroy() {
	}

}