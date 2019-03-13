package webapp.filter;

import org.apache.commons.lang.StringUtils;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "inputFieldsValidate", servletNames = "loginServlet")
public class InputFieldsValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String login = request.getParameter("email");
        String password = request.getParameter("password");
        if (StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ValidateResult authorizationResult = new ValidateResult("Please, type email and password", ValidateResultType.ERROR);
            request.setAttribute("authResult", authorizationResult);
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }
    }


    @Override
    public void init(FilterConfig filterConfig) {

    }


    @Override
    public void destroy() {

    }
}
