package topic_9_5;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * - A RowSet replaces the use of Connection, Statement and ResultSet interfaces. 
 * - RowSets follow JavaBeans naming conventions. 
 * - There are 2 types: connected and disconnected. - JdbcRowSet is an implementation of
 * connected RowSet. - RowSet adds methods for those operations that modify the
 * tables: updateRow(), insertRow(), deleteRow(), moveToInsertRow()
 */
public class TestConnectedRowSets {

    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";

        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {
            rowSet.setCommand(query);
            rowSet.setUrl("jdbc:derby://localhost:1527/sample");
            rowSet.setUsername(user);
            rowSet.setPassword(pwd);
            rowSet.execute();
            printRows(rowSet);
//            System.out.println("Inserting a row.....");
//            insertRow(rowSet);
//            rowSet.execute();
//            printRows(rowSet);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    private static void insertRow(RowSet rowSet) throws SQLException {
        rowSet.moveToInsertRow();
        rowSet.updateInt("PRODUCT_ID", 1);
        rowSet.updateInt("MANUFACTURER_ID", 19986982);
        rowSet.updateInt("QUANTITY_ON_HAND", 10);
        rowSet.updateString("PRODUCT_CODE", "SW");
        rowSet.updateString("DESCRIPTION", "Java Certification Course Software");
        rowSet.updateDouble("PURCHASE_COST", 110.5);
        rowSet.updateDouble("MARKUP", 10.5);
        rowSet.updateBoolean("AVAILABLE", true);
        rowSet.insertRow();
        rowSet.moveToCurrentRow();
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
 * - What happens if query is one of UPDATE, CREATE or DELETE?
 * - What must be done after updating the RowSet to actually see changes?
 */
