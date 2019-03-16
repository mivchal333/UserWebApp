package webapp.filter;

import webapp.model.User;
import webapp.service.PostService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//TODO: nie działa, przeba naprawić filtr
@WebFilter(filterName = "objectOwnerFilter", servletNames = {"deletePostServlet"})
public class ObjectOwnerFilter implements Filter {
    private PostService postService = PostService.getInstance();


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String title = req.getParameter("title");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("userObj");
        User postUser = postService.getUser(title);
        if (postUser.equals(sessionUser)) {
            filterChain.doFilter(req, res);
        } else req.getRequestDispatcher("/posts").forward(req, res);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void destroy() {

    }
}
