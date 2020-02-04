package user_files.database.registration;

import org.apache.log4j.Logger;
import user_files.database.base.BaseDB;
import user_files.database.base.DataBaseInfo;
import user_files.database.base.Insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDataBase extends BaseDB<User> {
    private String table = DataBaseInfo.USERS_TABLE;
    private Logger logger = Logger.getLogger(UsersDataBase.class);

    public UsersDataBase() {
        super(DataBaseInfo.USERS_TABLE);
    }

    @Override
    protected User formatData(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    }

    @Override
    protected String makeInsertQuery(User user) {
        return new Insert().into(table).toFields("login", "password").values(user.getLogin(), user.getPassword()).build();
    }

    public User getUser(String login, String password){
        Connection connection = getConn();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM " + table +" WHERE login = '" + login + "' AND password = '" + password + "'"
            );
            set = statement.executeQuery();
            if (set.next()) {
                return new User(
                        set.getInt(1),   // id
                        set.getString(2),// login
                        set.getString(3) // password
                );
            }
            return null;
            } catch (SQLException e) {
            e.printStackTrace();
            logger.error("getting user from database failed", e);
            return null;
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isUserInDatabase(User user) {
        Connection connection = getConn();
        int count = 0;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            statement = connection.prepareStatement("SELECT COUNT(id) FROM users WHERE" +
                    " login = '" + user.getLogin() +
                    "' AND password = '" + user.getPassword() + "'");
            set = statement.executeQuery();

            if (set.next()) {
                count = set.getInt(1);
                System.out.println(count);
            }
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}