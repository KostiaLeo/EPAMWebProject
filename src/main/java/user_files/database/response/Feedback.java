package user_files.database.response;

public class Feedback {
    private String response;
    private int userId;

    public Feedback(String response, int userId) {
        this.response = response;
        this.userId = userId;
    }

    public Feedback() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
