package topic_9_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - Use rollback method when there's an error which makes the complete transaction
 * not to be valid.
 */
public class TestRollBack {

    public static void main(String[] args) throws SQLException {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";
        String insertQuery = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, "
                + "PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP,"
                + "AVAILABLE, DESCRIPTION) VALUES(1, 19985678, 'SW', 50.0, 1, 40.0, 'TRUE', 'Java Course')";
        String removeQuery = "DELETE FROM PRODUCT WHERE PRODUCT_ID = 1";

        Connection rollBackConnectionReference = null;
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            rollBackConnectionReference = connection; //used only to rollback
            connection.setAutoCommit(false);
            int rowsInserted = statement.executeUpdate(insertQuery);
            
            if (true) {
                throw new SQLException("Something bad happened");
            }
            
            int rowsRemoved = statement.executeUpdate(removeQuery);

            System.out.printf("%d row(s) affected\n", rowsInserted);
            System.out.printf("%d row(s) affected\n", rowsRemoved);
            connection.commit();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            rollBackConnectionReference.rollback(); //throws SQLException
        }
    }
}

/**
 * To check:
 * - What happens if commit() or rollback() methods are invoked when auto-commit
 * is on in a database?
 * - What happens if auto-commit is turned back on during a transaction?
 */
