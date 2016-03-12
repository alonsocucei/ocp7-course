package topic_9_6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * - Use Callable interface to execute functions or stored procedures of functions.
 */
public class TestCallableStatement {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String storedProcedure = "{CALL SHOW_PRODUCTS(?)}";
//        String preparedQuery = "SELECT * FROM PRODUCT WHERE PURCHASE_COST >= ?";
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                CallableStatement statement = connection.prepareCall(storedProcedure);) {
            
//            statement.setInt(1, 900);
            statement.setString(1, "%Speakers%");
            
            ResultSet resultSet = statement.executeQuery();
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
 * - How a Stored Procedure is created?
 * - What happens if the Stored Procedure doesn't exists?
 * - What happens if parameter data type is different than the expected?
 * - What happens if calling executeQuery sending a String as argument?
 * - How OUT parameters are handled?
 * - How INOUT parameters are handled?
 */