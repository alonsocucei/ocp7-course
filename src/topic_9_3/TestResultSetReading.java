package topic_9_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * - JDBC provides methods to match SQL types:
 * SQL BOOLEAN -> getBoolean(), SQL DOUBLE, FLOAT -> getDouble(), 
 * SQL INTEGER -> getInt(),SQL REAL -> getFloat(), SQL BIGINT -> getLong(),
 * SQL DATE -> getDate(), SQL CHAR, VARCHAR, LONGVARCHAR -> getString(),
 * SQL TIME -> getTime(), SQL TIMESTAMP -> getTimestamp(), 
 * GENERAL PURPOSE -> getObject()
 */
public class TestResultSetReading {

    public static void main(String[] args) {
        String user = "app";
        String pwd = "app";
        String query = "SELECT QUANTITY_ON_HAND, PURCHASE_COST, DESCRIPTION FROM PRODUCT";
        
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData resultMeta = resultSet.getMetaData();
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.printf("%s\t", resultMeta.getColumnName(i));
            }

            System.out.println();
            double suma = 0;
            
            while (resultSet.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    if (resultMeta.getColumnName(i).equalsIgnoreCase("purchase_cost")) {
                        switch (resultMeta.getColumnType(i)) {
                            case Types.BIGINT:
                            case Types.DOUBLE: 
                            case Types.FLOAT: 
                            case Types.DECIMAL:
                            case Types.INTEGER:
                            case Types.REAL:
                                suma += resultSet.getDouble(i);
                        }
                    }
                    
                    System.out.printf("%" + resultMeta.getColumnName(i).length() + "s\t", resultSet.getString(i));
                }

                System.out.println();
            }
            System.out.println("Total: " + suma);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

/**
 * To check:
 * - How can data type be determined?
 * - What happens when reading a column using a method not compatible with data type?
 */