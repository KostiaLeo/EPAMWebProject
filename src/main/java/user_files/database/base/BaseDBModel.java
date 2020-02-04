package user_files.database.base;

import java.util.List;

public abstract class BaseDBModel<T> {
    private BaseDB<T> dataBase;

    public List<T> getItems() {
        return dataBase.retrieveFromDataBase();
    }

    public int registerItem(T t) {
        return dataBase.acceptRegistration(t);
    }

    public void setUpDataBase(BaseDB<T> db) {
        dataBase = db;
    }

//    protected void setUpOrdersClientDB(User user) {
//        dataBase = (BaseDB<T>) new OrdersClientDataBase(user);
//    }
//
//    protected void setUpAdminOrdersDB(){
//        dataBase = (BaseDB<T>) new OrdersAdminDataBase();
//    }
}
