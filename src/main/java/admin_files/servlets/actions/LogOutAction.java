package admin_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.servlets.actions.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutAction implements Action {
    private Logger logger = Logger.getLogger(LogOutAction.class);

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.setAttribute("admin_action", "registration");
        resp.sendRedirect("admin");

        logger.info("admin logs out");
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
