package user_files.database.base;

public interface DataBaseInfo {
    String DRIVER = "com.mysql.jdbc.Driver",
    DATABASE = "my_java_db",
    URL = "jdbc:mysql://localhost:3306/" + DATABASE,
    USER = "root",
    PASSWORD = "1111",
    ORDERS_TABLE = "orders",
    USERS_TABLE = "users",
    RESPONSES_TABLE = "responses";
}
