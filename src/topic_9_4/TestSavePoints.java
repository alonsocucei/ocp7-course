package topic_9_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * - Use Savepoint  interface to create virtual markers where you can come back
 * and try again or something different when an error happens.
 * - Call setSavepoint() method from Connection interface to create a Savepoint.
 * - JDBC drivers support different number of Savepoint. Java DB only supports 1
 * per transaction.
 */
public class TestSavePoints {

    public static void main(String[] args) throws SQLException {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";
        String insertQuery = "INSERT INTO PRODUCT(PRODUCT_ID, MANUFACTURER_ID, "
                + "PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP,"
                + "AVAILABLE, DESCRIPTION) VALUES(1, 19985678, 'SW', 50.0, 1, 40.0, 'TRUE', 'Java Course')";
        String removeQuery = "DELETE FROM PRODUCT WHERE PRODUCT_ID = 1";

        Connection rollBackConnectionReference = null;
        Savepoint savePoint = null;
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            rollBackConnectionReference = connection; //used only to rollback
            connection.setAutoCommit(false);
            int rowsInserted = statement.executeUpdate(insertQuery);
            savePoint = connection.setSavepoint("Insert product");
            
            if (true) {
                throw new SQLException("Something bad happened");
            }
            
            int rowsRemoved = statement.executeUpdate(removeQuery);

            System.out.printf("%d row(s) affected\n", rowsInserted);
            System.out.printf("%d row(s) affected\n", rowsRemoved);
            connection.commit();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            rollBackConnectionReference.rollback(savePoint); //throws SQLException
            rollBackConnectionReference.commit();
        }
    }
}

/**
 * To check:
 * - What happens if there are 2 Savepoints and then transaction is rollback 
 * to the first one?
 * - What DatabaseMetaData interface method returns info about Savepoint supporting?
 * - How a Savepoint can be reused?
 */