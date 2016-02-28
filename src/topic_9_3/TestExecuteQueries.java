package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - executeQuery() method from Statement returns a ResultSet which must be
 * iterated in order to get the records from database.
 * - Do not use this statement for DDL queries.
 */
public class TestExecuteQueries {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            
            ResultSetMetaData resultMeta = resultSet.getMetaData();
            for (int i = 1; i <= resultMeta.getColumnCount(); i ++) {
                System.out.printf("%s\t", resultMeta.getColumnName(i));
            }
            
            System.out.println();
            
            while (resultSet.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i ++) {
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
 * - What happens if the query is not a SELECT query?
 * - What executeQuery returns if there are no records to return?
 */