package user_files.models;

import user_files.database.base.BaseDBModel;
import user_files.database.registration.User;
import user_files.database.requests.Order;
import user_files.database.requests.OrdersClientDataBase;

import java.util.List;

public class OrdersClientModel extends BaseDBModel<Order> {

    public OrdersClientModel(User user) {
        setUpDataBase(new OrdersClientDataBase(user));
    }

    @Override
    public List<Order> getItems() {
        return super.getItems();
    }

    @Override
    public int registerItem(Order order) {
        return super.registerItem(order);
    }
}
