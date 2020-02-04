package user_files.models;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user_files.database.registration.User;
import user_files.database.requests.Order;
import user_files.database.requests.OrdersClientDataBase;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;

public class OrdersClientModelTest {
    OrdersClientDataBase dataBase;
    OrdersClientModel model;
    List<Order> orders = new ArrayList<>();
    Order order;
    User user;

    void mockOrder() {
        order = mock(Order.class);
        doReturn("something").when(order).getInfo();
        doReturn(0).when(order).getPrice();
        doReturn(0).when(order).getStatus();
        doReturn("").when(order).getComment();
        doReturn(26).when(order).getUserId();
        doReturn(new Timestamp(new java.util.Date().getTime())).when(order).getCreatingDate();
    }

    void mockUser() {
        user = Mockito.mock(User.class);
        doReturn("ivannn").when(user).getLogin();
        doReturn("van").when(user).getPassword();
        doReturn(26).when(user).getId();
    }

    void mockDataBase() {
        dataBase = mock(OrdersClientDataBase.class);
        doReturn(orders).when(dataBase).retrieveFromDataBase();
        doReturn(1).when(dataBase).acceptRegistration(order);
    }

    void mockOrdersList() {
        orders = new ArrayList<>();
        orders.add(order);
    }

    @BeforeClass
    public void setUp() {
        mockUser();
        mockOrder();
        mockOrdersList();
        mockDataBase();
        model = new OrdersClientModel(user);
        model.setUpDataBase(dataBase);
    }

    @Test
    public void testRetrieving() {
        List<Order> orders = model.getItems();
        verify(dataBase).retrieveFromDataBase();
        assertEquals(orders.get(0).getUserId(), user.getId());
        assertNotEquals(orders.size(), 0);
        assertNotEquals(orders.size(), 2);
    }

    @Test
    public void testRegistration() {
        int registered = model.registerItem(order);
        verify(dataBase).acceptRegistration(order);
        assertEquals(registered, 1);
    }
}