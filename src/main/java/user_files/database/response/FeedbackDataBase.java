package user_files.database.response;

import user_files.database.base.BaseDB;
import user_files.database.base.DataBaseInfo;
import user_files.database.base.Insert;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDataBase extends BaseDB<Feedback> {
    String table = DataBaseInfo.RESPONSES_TABLE;

    public FeedbackDataBase() {
        super(DataBaseInfo.RESPONSES_TABLE);
    }

    @Override
    protected Feedback formatData(ResultSet resultSet) throws SQLException {
        return new Feedback(
                resultSet.getString(2),
                resultSet.getInt(3)
        );
    }

    @Override
    protected String makeInsertQuery(Feedback feedback) {
        String info = feedback.getResponse();
        if (info.contains("'")) {
            info = info.replace("'", Character.toString('`'));
        }
        return new Insert().into(table).toFields("response", "userId").values(info, feedback.getUserId()).build();
    }
}
