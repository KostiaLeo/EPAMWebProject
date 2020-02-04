package admin_files.models;

import admin_files.database.MasterBaseDataBase;
import user_files.database.base.BaseDBModel;
import user_files.database.requests.Order;

import java.util.List;

public class MasterOrderModel extends BaseDBModel<Order> {
    private MasterBaseDataBase dataBase = new MasterBaseDataBase();

    public MasterOrderModel() {
        setUpDataBase(dataBase);
    }

    public void updateCompleting(int id) {
        dataBase.updateCompleting(id);
    }

    @Override
    public List<Order> getItems() {
        return super.getItems();
    }
}
