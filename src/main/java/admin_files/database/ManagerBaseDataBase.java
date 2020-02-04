package admin_files.database;

import user_files.database.requests.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerBaseDataBase extends BaseAdminDataBase {
    @Override
    public PreparedStatement update(int id, int price, Connection conn, int status, String comment) throws SQLException {
        PreparedStatement statement;
        int updated;
        if (comment.contains("'")){
            comment = comment.replace("'", Character.toString('`'));
        }

        statement = conn.prepareStatement(
                "UPDATE orders SET status = " + status + ", price = " + price + ", comment = '" + comment + "', managing_date = now() WHERE id = " + id);
        updated = statement.executeUpdate();
        System.out.println(updated + " lines updated");

        return statement;
    }

    @Override
    public PreparedStatement update(int id, Connection conn) throws SQLException { return null; }

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
