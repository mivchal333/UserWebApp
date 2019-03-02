package webapp.authorization;

import webapp.User;
import webapp.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        if (UserRepository.existUser(user)) {
            if (UserRepository.checkPassword(user)) {
                user.setRole(UserRepository.getUserRole(user));
                req.getSession().setAttribute("userObj", user);
                resp.getWriter().append("Logged in successful");
            } else resp.getWriter().append("Password incorrect");
        } else resp.getWriter().append("User with such login doesn't exist. Try enter correct login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
