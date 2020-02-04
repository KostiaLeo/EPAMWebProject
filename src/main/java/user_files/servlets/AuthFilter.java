package user_files.servlets;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import user_files.database.registration.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
    private HttpSession session;
    private String uri;
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (req.getCharacterEncoding() == null) {
            req.setCharacterEncoding(encoding);
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        session = httpReq.getSession();
        uri = httpReq.getRequestURI();

        if (!isUserRegistered() && isRestrictedPage()) {
            httpReq.getRequestDispatcher("/auth/user_registration.jsp").forward(httpReq, httpResp);
        }
        filterChain.doFilter(req, resp);
    }

    private boolean isUserRegistered() {
        User user = (User) session.getAttribute("user");
        return user != null;
    }

    private boolean isRestrictedPage() {
        return (uri.endsWith("home") || uri.endsWith("response") || uri.endsWith("home.jsp"));
    }

    @Override
    public void destroy() {
    }
}
