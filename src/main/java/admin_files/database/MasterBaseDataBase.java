package admin_files.database;

import user_files.database.requests.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MasterBaseDataBase extends BaseAdminDataBase {

    @Override
    protected String makeSelectQuery() {
        return "SELECT orders.id, login, info, price, status, creating_date " +
                "FROM orders INNER JOIN users u ON orders.user_id = u.id " +
                "WHERE orders.status = 1 ORDER BY creating_date ASC";
    }

    @Override
    public PreparedStatement update(int id, int price, Connection conn, int status, String comment) throws SQLException { return null; }

    @Override
    public PreparedStatement update(int id, Connection conn) throws SQLException {
        PreparedStatement statement = null;
        int updated = 0;
        statement = conn.prepareStatement(
                "UPDATE orders SET status = " + OrderStatus.COMPLETED + ", completing_date = now()" +
                        "WHERE id = " + id);
        updated = statement.executeUpdate();
        System.out.println(updated + " lines updated");

        return statement;
    }

}
