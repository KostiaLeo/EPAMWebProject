package user_files.database.base;

import user_files.database.requests.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public abstract class BaseOrderDB extends BaseDB<Order> {

    public BaseOrderDB() {
        super(DataBaseInfo.ORDERS_TABLE);
    }

    @Override
    protected Order formatData(ResultSet set) throws SQLException {
        return new Order(
                set.getInt(2),      // user_id
                set.getString(3),   // info
                set.getInt(4),      // price
                set.getInt(5),      // status
                set.getString(6),   // comment
                set.getTimestamp(7),// creating_date
                set.getTimestamp(8),// managing_date
                set.getTimestamp(9) // completing_date
        );
    }

    @Override
    protected String makeInsertQuery(Order order) {
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        String info = order.getInfo();

        if (info.contains("'")){
            info = info.replace("'", Character.toString('`'));
        }
        return new Insert().into(DataBaseInfo.ORDERS_TABLE).toFields("user_id", "info", "price", "status", "creating_date")
                .values(order.getUserId(), info, order.getPrice(), order.getStatus(), timestamp)
                .build();
    }
}