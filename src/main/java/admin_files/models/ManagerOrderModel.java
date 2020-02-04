package admin_files.models;

import admin_files.database.BaseAdminDataBase;
import admin_files.database.ManagerBaseDataBase;
import user_files.database.base.BaseDBModel;
import user_files.database.requests.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ManagerOrderModel extends BaseDBModel<Order> {
    private BaseAdminDataBase dataBase = new ManagerBaseDataBase() {
        @Override
        public PreparedStatement update(int id, Connection conn) throws SQLException {
            return null;
        }
    };

    public ManagerOrderModel() {
        setUpDataBase(dataBase);
    }

    @Override
    public List<Order> getItems() {
        return super.getItems();
    }

    public void updatePrice(int id, int price, int status, String comment) {
        dataBase.updatePrice(id, price, status, comment);
    }
}
