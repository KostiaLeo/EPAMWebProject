package admin_files.database;

import user_files.database.base.BaseOrderDB;
import user_files.database.requests.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseAdminDataBase extends BaseOrderDB {
    private Connection conn = getConn();
    private PreparedStatement statement = null;

    public abstract PreparedStatement update(int id, int price, Connection conn, int status, String comment) throws SQLException;
    public abstract PreparedStatement update(int id, Connection conn) throws SQLException;

    public void updateCompleting(int id) {
        PreparedStatement statement = null;
        try{
            statement = update(id, conn);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                    //conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updatePrice(int id, int price, int status, String comment) {
        try{
            statement = update(id, price, conn, status, comment);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                    //conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected String makeSelectQuery() {
        return "SELECT orders.id, login, info, price, status, creating_date " +
                "FROM orders INNER JOIN users u ON orders.user_id = u.id " +
                "WHERE orders.status = 0 ORDER BY creating_date ASC";
    }

    @Override
    protected Order formatData(ResultSet set) throws SQLException {
        return new Order(
                set.getInt(1),      // id
                set.getString(2),   // user_login
                set.getString(3),   // info
                set.getInt(4),      // price
                set.getInt(5),      // status
                set.getTimestamp(6) // creating_date
        );
    }
}
