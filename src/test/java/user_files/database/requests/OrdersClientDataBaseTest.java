package user_files.database.requests;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user_files.database.registration.User;

import java.sql.Timestamp;
import java.util.List;

import static org.testng.Assert.*;

public class OrdersClientDataBaseTest {

    User user;
    OrdersClientDataBase dataBase;

    @BeforeMethod
    public void setUp() {
        user = Mockito.mock(User.class);
        Mockito.doReturn("ivannn").when(user).getLogin();
        Mockito.doReturn("van").when(user).getPassword();
        Mockito.doReturn(26).when(user).getId();
        dataBase = new OrdersClientDataBase(user);
    }

//    @AfterClass
//    public void tearDown() {}

    @Test
    public void testFormatData() {

    }

    @Test
    public void testMakeInsertQuery() {
    }

    @Test
    public void testRetrieveFromDataBase() {
        List<Order> orders = dataBase.retrieveFromDataBase();
        assertEquals(orders.get(0).getPrice(), 500);
    }

    @Test
    public void testAcceptRegistration() {
        Order order = Mockito.mock(Order.class);
        Mockito.doReturn("something").when(order).getInfo();
        Mockito.doReturn(0).when(order).getPrice();
        Mockito.doReturn(0).when(order).getStatus();
        Mockito.doReturn("").when(order).getComment();
        Mockito.doReturn(user.getId()).when(order).getUserId();
        Mockito.doReturn(new Timestamp(new java.util.Date().getTime())).when(order).getCreatingDate();
        int inserted = dataBase.acceptRegistration(order);
        assertEquals(inserted, 1);
    }

    @Test
    public void testGetConn() {

    }

    @Test
    public void testTestMakeSelectQuery() {
    }
}