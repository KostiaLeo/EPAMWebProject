package admin_files.servlets;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import user_files.servlets.actions.Action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public abstract class BaseServlet extends HttpServlet {
    private HashMap<String, Action> actions;
    private String actionParameter;
    private Logger logger;

    public <T extends HttpServlet> BaseServlet(String actionParameter, Class<T> servletClass) {
        this.actionParameter = actionParameter;
        logger = setUpServletLogger(servletClass);
    }

    private  <T extends HttpServlet> Logger setUpServletLogger(Class<T> servletClass) {
        return Logger.getLogger(servletClass);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        actions = setUpActionsMap();
        initLogger(config);

        super.init(config);
    }

    protected abstract HashMap<String, Action> setUpActionsMap();

    private void initLogger(ServletConfig config) {
        String log4jLocation = config.getInitParameter("log4jprop-location");
        ServletContext sc = config.getServletContext();
        String webAppPath = sc.getRealPath("/");
        String log4jPath = webAppPath + log4jLocation;
        File log4jFile = new File(log4jPath);

        if (log4jFile.exists()) {
            PropertyConfigurator.configure(log4jPath);
        } else {
            BasicConfigurator.configure();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = getProperAction(req);
        action.executeGet(req, resp);
        logger.info(action.getClass().getName() + " action executes doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = getProperAction(req);
        action.executePost(req, resp);
        logger.info(action.getClass().getName() + " action executes doPost()");
    }

    private Action getProperAction(HttpServletRequest req) {
        String actionKey = req.getParameter(actionParameter);

        String actionAttribute = (String) req.getSession().getAttribute(actionParameter);

        if (isEmpty(actionAttribute) && isEmpty(actionKey)) {
            actionKey = "registration";
        } else if (!isEmpty(actionAttribute) && isEmpty(actionKey)){
            actionKey = actionAttribute;
        }
        req.getSession().setAttribute(actionParameter, null);

        logger.info("actionKey - " + actionKey);
        return actions.get(actionKey);
    }

    private boolean isEmpty(String key) {
        return key == null || key.length() == 0;
    }
}
