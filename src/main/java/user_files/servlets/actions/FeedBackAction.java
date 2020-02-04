package user_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.database.registration.User;
import user_files.database.response.Feedback;
import user_files.models.ResponseModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FeedBackAction implements Action {
    private ResponseModel model;
    private String feedback;
    private User user;
    private Logger logger = Logger.getLogger(FeedBackAction.class);

    public FeedBackAction() {
        model = new ResponseModel();
    }

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        feedback = req.getParameter("feedback");
        user = (User) req.getSession().getAttribute("user");

        if (isValidInputs()) {
            registerFeedback(req, resp);
        } else {
            notifyIncorrectInput(resp);
        }
    }

    private boolean isValidInputs() {
        return feedback.length() != 0 && user != null;
    }

    private void registerFeedback(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        model.registerItem(new Feedback(feedback, user.getId()));
        logger.info("new feedback sending");
        req.getSession().setAttribute("action", "home");
        resp.sendRedirect("user");
    }

    private void notifyIncorrectInput(HttpServletResponse resp) throws IOException {
        logger.warn("invalid feedback text");
        resp.getWriter().write(
                "<script>" +
                        "alert('Feedback text shouldn't be empty');" +
                        "window.location = 'home.jsp';" +
                   "</script>");
    }
}
