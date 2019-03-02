package webapp.login;



import webapp.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoggedUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User userObj = (User) session.getAttribute("userObj");
        if (userObj != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else servletResponse.getWriter().append("User not login in!");
    }


    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
}
