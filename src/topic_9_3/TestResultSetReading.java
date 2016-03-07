package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - JDBC provides methods to match SQL types:
 * SQL BOOLEAN -> getBoolean(), SQL DOUBLE, FLOAT -> getDouble(), 
 * SQL INTEGER -> getInt(),SQL REAL -> getFloat(), SQL BIGINT -> getLong(),
 * SQL DATE -> getDate(), SQL CHAR, VARCHAR, LONGVARCHAR -> getString(),
 * SQL TIME -> getTime(), SQL TIMESTAMP -> getTimestamp(), 
 * GENERAL PURPOSE -> getObject()
 */
public class TestResultSetReading {

    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT DESCRIPTION, QUANTITY_ON_HAND, PURCHASE_COST FROM PRODUCT";

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
                    System.out.printf("%" + resultMeta.getColumnName(i).length() + "s\t", resultSet.getString(i));
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
 * - How can data type be determined?
 * - What happens when reading a column using a method not compatible with data type?
 */