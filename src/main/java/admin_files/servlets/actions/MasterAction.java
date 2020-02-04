package admin_files.servlets.actions;

import admin_files.models.MasterOrderModel;
import org.apache.log4j.Logger;
import user_files.database.requests.Order;
import user_files.servlets.actions.Action;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MasterAction implements Action {
    private MasterOrderModel model;
    private Logger logger = Logger.getLogger(MasterAction.class);

    public MasterAction() {
        model = new MasterOrderModel();
    }

    @Override
    public void executeGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = loadSubmittedOrders();
        req.getSession().setAttribute("submittedOrders", orders);
        resp.sendRedirect("auth/masterPage.jsp");
    }

    private List<Order> loadSubmittedOrders() {
        List<Order> orders = model.getItems();
        logger.info(orders.size() + " items of order retrieved to manager page");
        return orders;
    }

    @Override
    public void executePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("id"));
        model.updateCompleting(orderId);
        executeGet(req, resp);
        logger.info("order is updated by master: order's id: " + orderId);
    }
}
