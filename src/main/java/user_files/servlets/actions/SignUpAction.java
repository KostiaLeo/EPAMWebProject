package user_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.database.registration.User;
import user_files.database.registration.UsersDataBase;
import user_files.models.UsersModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpAction implements Action {
    private UsersModel usersModel;
    private Logger logger = Logger.getLogger(SignUpAction.class);

    public SignUpAction() {
        usersModel = new UsersModel(new UsersDataBase());
    }

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (areInputsWrong(login, password)) {
            notifyAboutWrongInputs(resp);
            return;
        }

        User user = usersModel.getUser(login, password);

        req.getSession().setAttribute("user", user);

        req.getSession().setAttribute("action", "home");
//        req.getRequestDispatcher("/user").forward(req, resp);
        resp.sendRedirect("user");

        logger.info("Current user:\n" + user.toString());
    }

    private boolean areInputsWrong(String login, String password) {
        return login.length() == 0 && password.length() == 0;
    }

    private void notifyAboutWrongInputs(HttpServletResponse resp) throws IOException {
        logger.info("wrong data typed (empty fields)");
        resp.getWriter().write(
                "<script>" +
                        "alert('Password and login mustn't be empty');" +
                        "window.location = 'user_registration.jsp';" +
                   "</script>");
    }
}