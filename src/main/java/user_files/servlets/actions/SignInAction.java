package user_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.database.registration.User;
import user_files.database.registration.UsersDataBase;
import user_files.models.UsersModel;
import user_files.servlets.UserServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInAction implements Action {
    private UsersModel usersModel;
    private User user;
    private Logger logger = Logger.getLogger(SignInAction.class);

    public SignInAction() {
        usersModel = new UsersModel(new UsersDataBase());
    }

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (areInputsValid(login, password, confirmPassword)) {
            createUser(login, password);
            doRegistration(req, resp);
        } else {
            notifyIncorrectInputs(resp);
        }
    }

    private boolean areInputsValid(String login, String password, String confirmPassword) {
        return password.equals(confirmPassword) && password.length() != 0 && login.length() != 0;
    }

    private void createUser(String login, String password) {
        user = new User();
        user.setLogin(login);
        user.setPassword(password);

        logger.info("new user creating: " + login);
    }

    private void doRegistration(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!usersModel.isUserRegistered(user)) {
            usersModel.registerItem(user);

            req.getSession().setAttribute("user", usersModel.getUser(user.getLogin(), user.getPassword()));
            redirectToHome(req, resp);

            logger.info("user registration: " + user.getLogin());
        } else {
            notifyIncorrectInputs(resp);
        }
    }

    private void redirectToHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("action", "home");
        resp.sendRedirect("user");
    }

    private void notifyIncorrectInputs(HttpServletResponse resp) throws IOException {
        resp.getWriter().write(
                "<script>" +
                        "alert('Incorrect password confirmation or login typing');" +
                        "window.location = 'user_registration.jsp';" +
                        "</script>");
        logger.info("Incorrect user's data input (such user is already exist)");
    }

}
