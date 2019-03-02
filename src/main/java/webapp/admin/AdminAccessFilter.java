package webapp.admin;



import webapp.Role;
import webapp.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "adminAccessFilter", servletNames = "adminContent")
public class AdminAccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User userObj = (User) session.getAttribute("userObj");
        if (Role.ADMIN.equals(userObj.getRole())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else servletResponse.getWriter().append("ACCES DENIED");
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }


    @Override
    public void destroy() {

    }
}
