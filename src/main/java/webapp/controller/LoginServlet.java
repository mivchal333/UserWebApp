package webapp.controller;

import webapp.model.User;
import webapp.service.UserService;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        String login = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> optUser = userService.loginUser(login, password);

        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setRole(userService.getUserRole(user));
            session.setAttribute("userObj", user);
            ValidateResult authResult = new ValidateResult("Successful login", ValidateResultType.SUCCESS);
            req.setAttribute("authResult", authResult);
            resp.sendRedirect("/posts");
        } else {
            ValidateResult authorizationResult = new ValidateResult("Falied login", ValidateResultType.ERROR);
            req.setAttribute("authResult", authorizationResult);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
