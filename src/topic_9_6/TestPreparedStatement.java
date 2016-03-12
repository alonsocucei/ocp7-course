package topic_9_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * - Use PreparedStatement interface to execute precompiled SQL statements.
 * - PreparedStatement is safe against SQL injection attacks.
 * - Uses ? char to indicate a parameter is expected.
 */
public class TestPreparedStatement {
    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String preparedQuery = "SELECT * FROM PRODUCT WHERE DESCRIPTION LIKE ?";
//        String preparedQuery = "SELECT * FROM PRODUCT WHERE PURCHASE_COST >= ?";
        
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                PreparedStatement statement = connection.prepareStatement(preparedQuery);) {
            
//            statement.setInt(1, 900);
            statement.setString(1, "%Computer%");
            
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
 * - What are the differences between using a Statement and a PreparedStatement?
 * - What methods PreparedStatement declares to execute queries?
 * - What happens if setInt is changed for setString method?
 * - What happens if trying the opposite case?
 */