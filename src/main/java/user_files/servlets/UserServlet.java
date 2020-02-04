package user_files.servlets;

import admin_files.servlets.BaseServlet;
import user_files.servlets.actions.*;

import java.util.HashMap;

public class UserServlet extends BaseServlet {

    public UserServlet() {
        super("action", UserServlet.class);
    }

    @Override
    protected HashMap<String, Action> setUpActionsMap() {
        HashMap<String, Action> actions = new HashMap<>();
        actions.put("signIn", new SignInAction());
        actions.put("signUp", new SignUpAction());
        actions.put("home", new HomeAction());
        actions.put("feedback", new FeedBackAction());
        return actions;
    }
}
