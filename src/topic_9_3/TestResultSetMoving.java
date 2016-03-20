package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - To iterate over a ResultSet this uses a cursor which may have a type and
 * a concurrency attribute.
 * - Default cursor is TYPE_FORWARD_ONLY and CONCUR_READ_ONLY
 * - Cursor types are: TYPE_FORWARD_ONLY, TYPE_SCROLL_INSENSITIVE and TYPE_SCROLL_SENSITIVE
 * - Concurrency types are: CONCUR_READ_ONLY and CONCUR_UPDATABLE
 * - To verify what your driver support use the methods in DatabaseMetaData class: 
 * supportsResultSetType() and supportsResultSetConcurrency()
 * - To change a ResultSet type and concur attributes call the overloaded method
 * createStatement in Connection interface.
 */
public class TestResultSetMoving {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT * FROM PRODUCT";
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
//                Statement statement = connection.createStatement();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery(query)) {
            
            ResultSetMetaData resultMeta = resultSet.getMetaData();
            for (int i = 1; i <= resultMeta.getColumnCount(); i ++) {
                System.out.printf("%s\t", resultMeta.getColumnName(i));
            }
            
            System.out.println();
//            resultSet.last();
//            resultSet.deleteRow();
            
            System.out.println(resultSet.getRow());
            System.out.println(resultSet.isBeforeFirst());
            
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
 * - What happens if next() method is called after while statement?
 * - How the results can be access from last to first?
 * - What happens when asking for a type and concur types that are not supported?
 * - How the absolute() method works?
 * - How the relative() method works?
 */