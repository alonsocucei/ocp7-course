package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - execute() method is used when query type is decided at runtime, it can be
 * either a SELECT query or one of DELETE, UPDATE, INSERT or a DDL query.
 * - User getResultSet() and getUpdatedCount() methods to retrieve the data 
 * according to the type of query executed.
 */
public class TestExecute {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String selectQuery = "SELECT * FROM PRODUCT";
        String updateQuery = "DELETE FROM PRODUCT WHERE PRODUCT_ID = 1";
        
        String query = Math.random() > 0.5 ? selectQuery : updateQuery;
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement();) {
            
            boolean resultSetAvailable = statement.execute(query);
            
            if (resultSetAvailable) {
                ResultSet resultSet = statement.getResultSet();
                
                while (resultSet.next()) {
                    System.out.printf("%s\n", resultSet.getString("DESCRIPTION"));
                }
                
                statement.close();
            } else {
                System.out.printf("%d rows updated\n", statement.getUpdateCount());
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What the getResultSet() method returns when execute() method is called with
 * a non SELECT query?
 * - What the getUpdateCount() method returns when execute() method is called
 * with a SELECT query?
 */