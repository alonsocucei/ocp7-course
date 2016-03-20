package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - Use the executeUpdate() method to INSERT, DELETE or UPDATE records.
 * - This method can be used to execute DDL queries too.
 */
public class TestExecuteUpdates {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String insertQuery = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, "
                + "PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP,"
                + "AVAILABLE, DESCRIPTION) VALUES(1, 19985678, 'SW', 50.0, 1, 40.0, 'TRUE', 'Java Course')";
        String removeQuery = "DELETE FROM PRODUCT WHERE PRODUCT_ID = 1";
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement();) {
            int rowsUpdated = statement.executeUpdate(insertQuery);
            System.out.printf("%d row(s) added\n", rowsUpdated);
            
//            int rowsUpdated = statement.executeUpdate(removeQuery);
//            System.out.printf("%d row(s) removed\n", rowsUpdated);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What happens if a SELECT query is executed using the executeUpdate() method?
 */