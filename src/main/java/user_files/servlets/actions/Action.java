package user_files.servlets.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
