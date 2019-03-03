package webapp.authorization;

import webapp.User;
import webapp.UserRepository;
import webapp.login.AuthorizationResult;
import webapp.login.AuthorizationResultType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        if (UserRepository.getInstance().existUser(user) && UserRepository.getInstance().checkPassword(user)) {
            user.setRole(UserRepository.getInstance().getUserRole(user));
            req.getSession().setAttribute("userObj", user);
            AuthorizationResult authorizationResult = new AuthorizationResult("Successful login", AuthorizationResultType.SUCCESS);
            req.setAttribute("authResult", authorizationResult);
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        } else {
            AuthorizationResult authorizationResult = new AuthorizationResult("Falied login", AuthorizationResultType.ERROR);
            req.setAttribute("authResult", authorizationResult);
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
