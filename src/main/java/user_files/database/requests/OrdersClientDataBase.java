package user_files.database.requests;

import user_files.database.base.BaseOrderDB;
import user_files.database.base.DataBaseInfo;
import user_files.database.registration.User;

public class OrdersClientDataBase extends BaseOrderDB {
    private User user;

    public OrdersClientDataBase(User user) {
        this.user = user;
    }

    @Override
    protected String makeSelectQuery() {
        String query = "SELECT * FROM " + DataBaseInfo.ORDERS_TABLE + " WHERE user_id = " +
                "(SELECT id FROM " + DataBaseInfo.USERS_TABLE + " WHERE login = '" + user.getLogin() +
                "' and password = '"+ user.getPassword() +"') ORDER BY creating_date DESC";
        System.out.println(query);
        return query;
    }
}