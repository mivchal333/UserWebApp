package webapp.filter;

import webapp.model.User;
import webapp.service.PostService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(filterName = "objectOwnerFilter", servletNames = {"deletePostServlet"})
public class ObjectOwnerFilter implements Filter {
    private PostService postService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String postId = req.getParameter("id");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("userObj");
        Optional<User> postOwnerOpt = postService.getUser(postId);
        if (postOwnerOpt.isPresent()) {
            User postOwner = postOwnerOpt.get();
            if (postOwner.equals(sessionUser)) {
                filterChain.doFilter(req, res);
            } else req.getRequestDispatcher("/posts").forward(req, res);
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        postService = PostService.getInstance();

    }


    @Override
    public void destroy() {

    }
}
