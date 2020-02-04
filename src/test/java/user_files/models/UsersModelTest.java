package user_files.models;

import org.junit.Before;
import org.mockito.Mock;
import user_files.database.registration.User;
import user_files.database.registration.UsersDataBase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;

public class UsersModelTest {
    UsersModel model;
    @Mock
    UsersDataBase dataBase;
    String login = "ivannn", password = "van";
    User user = new User(26, login, password);
    List<User> users = new ArrayList<>();

    void mockUser() {
        users.add(user);
    }

    void mockDataBase() {
        dataBase = mock(UsersDataBase.class);
        doReturn(users).when(dataBase).retrieveFromDataBase();
        doReturn(user).when(dataBase).getUser(login, password);
        doReturn(1).when(dataBase).acceptRegistration(user);

        model = new UsersModel(dataBase);
        //model.setUpDataBase(dataBase);
    }

    void setUpModel() {

    }

    @Before
    public void beforeClass() {
        mockUser();
        mockDataBase();
        setUpModel();
    }

    @Test
    public void testRegisterItem() {
        assertEquals(model.registerItem(user), 1);
        verify(dataBase).acceptRegistration(user);
    }

    @Test
    public void testGetUser() {
        assertEquals(user, model.getUser(login, password));
        verify(dataBase).getUser(login, password);
    }

    @Test
    public void testRetrievingFromDataBase() {
        assertEquals(user, model.getItems().get(0));
        verify(dataBase).retrieveFromDataBase();
    }
}