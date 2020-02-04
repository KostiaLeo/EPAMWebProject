package user_files.models;

import user_files.database.base.BaseDBModel;
import user_files.database.registration.User;
import user_files.database.registration.UsersDataBase;
import java.util.List;

public class UsersModel extends BaseDBModel<User> {
    private UsersDataBase dataBase;

    public UsersModel(UsersDataBase dataBase) {
        setUpDataBase(dataBase);
        this.dataBase = dataBase;
    }

    @Override
    public List<User> getItems() {
        return super.getItems();
    }

    @Override
    public int registerItem(User user) {
        return super.registerItem(user);
    }

    public boolean isUserRegistered(User user) {
        return dataBase.isUserInDatabase(user);
    }

    public User getUser(String login, String password) {
        return dataBase.getUser(login, password);
    }
}
