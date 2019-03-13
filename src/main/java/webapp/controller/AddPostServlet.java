package webapp.controller;

import webapp.service.PostService;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addPostServlet", urlPatterns = "/add-post")
public class AddPostServlet extends HttpServlet {
    private PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        ValidateResult result = postService.validatePost(title, content);
        if (result.getType() == ValidateResultType.ERROR) {
            req.setAttribute("addResult", result);
            req.getRequestDispatcher("/add_post.jsp").forward(req, resp);
        }
        postService.addPost(title, content, session);
        req.setAttribute("addResult", result);
        req.getRequestDispatcher("/add_post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
