package user_files.models;

import user_files.database.base.BaseDBModel;
import user_files.database.response.Feedback;
import user_files.database.response.FeedbackDataBase;

public class ResponseModel extends BaseDBModel<Feedback> {
    public ResponseModel() {
        setUpDataBase(new FeedbackDataBase());
    }
}
