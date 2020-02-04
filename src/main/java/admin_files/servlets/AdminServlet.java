package admin_files.servlets;

import admin_files.servlets.actions.LogOutAction;
import admin_files.servlets.actions.ManagerAction;
import admin_files.servlets.actions.MasterAction;
import admin_files.servlets.actions.RegistrationAdminAction;
import user_files.servlets.actions.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/admin")
public class AdminServlet extends BaseServlet {

    public AdminServlet() {
        super("admin_action", AdminServlet.class);
    }

    @Override
    protected HashMap<String, Action> setUpActionsMap() {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put("registration", new RegistrationAdminAction());
        actions.put("logout", new LogOutAction());
        actions.put("manager", new ManagerAction());
        actions.put("master", new MasterAction());
        return actions;
    }
}
