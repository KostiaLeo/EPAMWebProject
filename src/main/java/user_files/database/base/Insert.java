package user_files.database.base;

import java.util.Arrays;
import java.util.Iterator;

public class Insert {
    private StringBuilder query = new StringBuilder("INSERT INTO ");

    public Insert into(String table) {
        query.append(table);
        return this;
    }

    public Insert toFields(String... f) {
        query.append(" (");
        Iterator<String> fields = Arrays.asList(f).iterator();

        while (fields.hasNext()) {
            query.append(fields.next());
            if (fields.hasNext()) {
                query.append(", ");
            }
        }

        query.append(")");
        return this;
    }

    public Insert values(Object... v) {
        query.append(" VALUES (");
        Iterator<Object> values = Arrays.asList(v).iterator();

        while (values.hasNext()) {
            query.append("'").append(values.next().toString()).append("'");
            if (values.hasNext()) {
                query.append(", ");
            }
        }
        query.append(")");
        return this;
    }

    public String build() {
        return query.toString();
    }
}