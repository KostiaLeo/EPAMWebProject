package user_files.servlets.actions;

import org.apache.log4j.Logger;
import user_files.database.registration.User;
import user_files.database.requests.Order;
import user_files.database.requests.OrderStatus;
import user_files.models.OrdersClientModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomeAction implements Action {
    private OrdersClientModel model;
    private User user;
    private HttpSession session;
    private Logger logger = Logger.getLogger(HomeAction.class);

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initHomeParams(req);
        loadMyOrders();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }

    private void initHomeParams(HttpServletRequest req) {
        session = req.getSession();
        user = (User) session.getAttribute("user");
        logger.info("user from home page:" + user.toString());
        if (model == null) {
            model = new OrdersClientModel(user);
        }
    }

    private void loadMyOrders() {
        List<Order> orders = model.getItems();
        session.setAttribute("myOrders", orders);
        logger.info("loaded " + orders.size() + " order items");
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getParameter("info");
        if (areWrongInputInfo(info)) {
            executeGet(req, resp);
            return;
        }

        Order order = new Order(user.getId(), info, 0, OrderStatus.CREATED);

        logger.info("creating new order: " + order.toString());

        model.registerItem(order);
        executeGet(req, resp);
    }

    private boolean areWrongInputInfo(String info) {
        return user == null || info == null || info.length() == 0;
    }
}