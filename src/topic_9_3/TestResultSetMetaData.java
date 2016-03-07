package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - ResultSetMetaData contains data about data regarding the ResultSet, to
 * get the data use the methods: getColumnCount(), getColumnName(), getColumnLabel(),
 * getTableName(), getColumnDisplaySize(), getScale(), etc.
 */
public class TestResultSetMetaData {

    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData resultMeta = resultSet.getMetaData();
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.printf("%s\t", resultMeta.getColumnName(i));
            }

            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.printf("%-" + resultMeta.getColumnName(i).length() + "s\t", resultSet.getString(i));
                }

                System.out.println();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

/**
 * To check:
 * - When getTableName() method is used?
 * - What's the difference between getColumnName() and getColumnLabel() methods?
 * - What getScale() method returns when called for a non decimal type?
 */