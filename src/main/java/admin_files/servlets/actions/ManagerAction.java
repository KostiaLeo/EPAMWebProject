package admin_files.servlets.actions;

import admin_files.models.ManagerOrderModel;
import org.apache.log4j.Logger;
import user_files.database.requests.Order;
import user_files.servlets.actions.Action;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagerAction implements Action {
    private ManagerOrderModel model;
    private Logger logger = Logger.getLogger(ManagerAction.class);

    public ManagerAction() {
        model = new ManagerOrderModel();
    }

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = loadOrders();
        req.getSession().setAttribute("allOrders", orders);
        resp.sendRedirect("auth/managerPage.jsp");
    }

    private List<Order> loadOrders() {
        List<Order> orders = model.getItems();
        logger.info(orders.size() + " items of order retrieved to manager page");
        return orders;
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        int price;
        try {
            price = Integer.parseInt(req.getParameter("price"));
        } catch (NumberFormatException e){
            price = 0;
        }

        int status = Integer.parseInt(req.getParameter("status"));
        String comment = req.getParameter("comment");
        model.updatePrice(orderId, price, status, comment);
        executeGet(req, resp);
        logger.info("order is updated by manager: order's id: " + orderId);
    }
}
