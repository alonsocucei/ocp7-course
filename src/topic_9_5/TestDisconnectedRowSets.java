package topic_9_5;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * - Disconnected RowSets just need to connect at the beginning and then be
 * disconnected. Next time the RowSet is connected it will synchronize with the
 * database.
 * - Disconnected RowSet implementations are: CachedRowSet, WebRowSet, 
 * FilteredRowSet and JoinRowSet.
 */
public class TestDisconnectedRowSets {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";

        try (CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet()) {
            rowSet.setCommand(query);
            rowSet.setUrl("jdbc:derby://localhost:1527/sample");
            rowSet.setUsername(user);
            rowSet.setPassword(pwd);
            rowSet.execute();
            insertRow(rowSet);
            rowSet.acceptChanges();
            rowSet.execute();
//            printRows(rowSet);
//            System.out.println("Deleting a row.....");
            deleteRow(rowSet, 1);
            rowSet.acceptChanges();
            rowSet.execute();
            printRows(rowSet);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    private static void insertRow(RowSet rowSet) throws SQLException {
        rowSet.moveToInsertRow();
        rowSet.updateInt("PRODUCT_ID", 1);
        rowSet.updateInt("MANUFACTURER_ID", 19986982);
        rowSet.updateString("PRODUCT_CODE", "SW");
        rowSet.updateDouble("PURCHASE_COST", 110.5);
        rowSet.updateInt("QUANTITY_ON_HAND", 10);
        rowSet.updateDouble("MARKUP", 10.5);
        rowSet.updateString("AVAILABLE", "TRUE");
        rowSet.updateString("DESCRIPTION", "Java Certification Course Software");
        rowSet.insertRow();
        rowSet.moveToCurrentRow();
    }
    
    private static void deleteRow(RowSet rowSet, int productId) throws SQLException {
        int columnIndex = rowSet.findColumn("PRODUCT_ID");
        
        while (rowSet.next()) {
            if (rowSet.getInt(columnIndex) == productId) {
                System.out.printf("Deleting product id: %d\n", productId);
                rowSet.deleteRow();
            }
        }
    }
    
    private static void printRows(RowSet rowSet) throws SQLException {
        ResultSetMetaData resultMeta = rowSet.getMetaData();
        
        for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
            System.out.printf("%s\t", resultMeta.getColumnName(i));
        }

        System.out.println();

        while (rowSet.next()) {
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.printf("%" + resultMeta.getColumnName(i).length() + "s\t", rowSet.getString(i));
            }

            System.out.println();
        }
    }
}

/**
 * To check:
 * - When the RowSet is disconnected?
 * - How RowSet is connected again?
 * - What's the difference between CachedRowSet and JdbcRowSet?
 */