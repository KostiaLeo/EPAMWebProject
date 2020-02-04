package admin_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.servlets.actions.Action;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationAdminAction implements Action {
    private Logger logger = Logger.getLogger(RegistrationAdminAction.class);

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth/admin_role_page.jsp").forward(req, resp);
        logger.info("attempt to sign up like admin");
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
