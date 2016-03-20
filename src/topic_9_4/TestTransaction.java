package topic_9_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - Use the setAutoCommit() method to change the way of handle transactions.
 * A false value means the developer must call the commit method after all
 * queries were executed. Only 1 transaction will be created.
 * A true value means every query will be executed in a different transaction.
 */
public class TestTransaction {

    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";
        String insertQuery = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, "
                + "PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP,"
                + "AVAILABLE, DESCRIPTION) VALUES(1, 19985678, 'SW', 50.0, 1, 40.0, 'TRUE', 'Java Course')";
        String removeQuery = "DELETE FROM PRODUCT WHERE PRODUCT_ID = 1";

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            connection.setAutoCommit(false);
//            int rowsUpdated = statement.executeUpdate(insertQuery);
            int rowsUpdated = statement.executeUpdate(removeQuery);

            System.out.printf("%d row(s) affected\n", rowsUpdated);
            connection.commit();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

/**
 * To check:
 * - When a transaction is started?
 * - How a transactions is committed to the database? 
 * - What happens if commit method is not called?
 */
