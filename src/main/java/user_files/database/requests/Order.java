package user_files.database.requests;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private int userId, price, status = OrderStatus.CREATED;
    private String info;
    private String userLogin;
    private int id;
    private String statusString;
    private String comment;
    private Timestamp creatingDate, managingDate, completingDate;

    // user retrieving
    public Order(int userId, String info, int price, int status, String comment, Timestamp creatingDate, Timestamp managingDate, Timestamp completingDate) {
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.info = info;
        this.comment = comment;
        this.creatingDate = creatingDate;
        this.managingDate = managingDate;
        this.completingDate = completingDate;
        this.statusString = setUpStringStatus(status);
    }

    // user creating
    public Order(int userId, String info, int price, int status) {
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.info = info;
        this.statusString = setUpStringStatus(status);
    }

    // manager retrieving
    public Order(int id, String userLogin, String info, int price, int status, Timestamp creatingDate) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.info = info;
        this.userLogin = userLogin;
        this.creatingDate = creatingDate;
        this.statusString = setUpStringStatus(status);
    }

    public Order() {
    }

    public String setUpStringStatus(int status) {
        switch (status) {
            case 0:
                return OrderStringStatus.CREATED;
            case 1:
                return OrderStringStatus.SUBMITTED;
            case 2:
                return OrderStringStatus.COMPLETED;
            case 3:
                return OrderStringStatus.REMOVED;
            default:
                return "";
        }
    }

    public Timestamp getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Timestamp creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Timestamp getManagingDate() {
        return managingDate;
    }

    public void setManagingDate(Timestamp managingDate) {
        this.managingDate = managingDate;
    }

    public Timestamp getCompletingDate() {
        return completingDate;
    }

    public void setCompletingDate(Timestamp completingDate) {
        this.completingDate = completingDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        setUpStringStatus(status);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", price=" + price +
                ", status=" + status +
                ", info='" + info + '\'' +
                '}';
    }
}
