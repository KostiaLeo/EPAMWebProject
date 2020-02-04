package user_files.database.base;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseDB<T> {
    private String table;
    private Connection conn;
    private DataSource ds;
    private Logger logger = Logger.getLogger(BaseDB.class);
    //private T t;
    {
        try {
            InitialContext initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/projectPool");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            logger.error("failed connection pool creating", e);
        }
    }

    public BaseDB(String table) {
        this.table = table;
    }

    public List<T> retrieveFromDataBase() {
        try {
            conn = ds.getConnection();
            List<T> list = handleDataBase();
            conn.close();
            logger.info("retrieved " + list.size() + " items from database");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<T> handleDataBase() throws SQLException {
        ResultSet result = fetchResultSet(makeSelectQuery());
        List<T> selData = new ArrayList<>();

        while (result.next()) {
            selData.add(formatData(result));
        }
        //result.close();
        //System.out.println("list's size from baseDB: " + selData.size());
        //conn.close();
        return selData;
    }

    protected abstract T formatData(ResultSet resultSet) throws SQLException;

    private ResultSet fetchResultSet(String query) throws SQLException {
//        conn = DataBaseConnection.getConnection();
        conn = ds.getConnection();

        PreparedStatement sData = Objects.requireNonNull(conn).prepareStatement(query);
        ResultSet set = sData.executeQuery();
        //conn.close();
        return set;
    }

    protected String makeSelectQuery() {
        String selectQuery = "SELECT * FROM ";
        return selectQuery + table;
    }

    protected abstract String makeInsertQuery(T t);

    private int register(T t) throws SQLException {
        conn = ds.getConnection();
        PreparedStatement statement = Objects.requireNonNull(conn).prepareStatement(makeInsertQuery(t));
        int inserted = statement.executeUpdate();
        //conn.close();
        logger.info("inserted " + inserted + " items of " + t.getClass().getName());
        return inserted;
    }

    public int acceptRegistration(T t) {
        try {
            return register(t);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected Connection getConn() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("getConnection failed", e);
            return null;
        }
    }
}