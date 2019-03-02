package webapp.authorization;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "inputFieldsValidate", servletNames = "loginServlet")
public class InputFieldsValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else servletResponse.getWriter().append("Login or Password input error. Please try again later");
    }


    @Override
    public void init(FilterConfig filterConfig) {

    }


    @Override
    public void destroy() {

    }
}
