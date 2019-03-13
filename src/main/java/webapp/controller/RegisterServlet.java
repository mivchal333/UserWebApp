package webapp.controller;

import webapp.service.RegistrationService;
import webapp.util.ValidateResult;
import webapp.util.ValidateResultType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private RegistrationService regService = RegistrationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String login = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(login + password);
        if (!regService.checkUserExist(login)) {
            regService.registerUser(login,password);
            ValidateResult result = new ValidateResult("Registration success", ValidateResultType.SUCCESS);
            req.setAttribute("regResult", result);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            ValidateResult result = new ValidateResult("That email already exist", ValidateResultType.ERROR);
            req.setAttribute("regResult", result);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
