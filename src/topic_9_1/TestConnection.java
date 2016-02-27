package topic_9_1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * - Interface java.sql.Connection must be implemented by the driver in order
 * to allow programmers handle connections to the database.
 * - Other useful interface is java.sql.DatabaseMetaData which contains methods
 * to get info from the connection.
 */
public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        DatabaseMetaData metadata = connection.getMetaData();
        
        System.out.println("DB major version: " + metadata.getDatabaseMajorVersion());
        System.out.println("DB minor version: " + metadata.getDatabaseMinorVersion());
        System.out.println("Driver version: " + metadata.getDriverVersion());
        System.out.println("JDBC major version: " + metadata.getJDBCMajorVersion());
        System.out.println("JDBC minor version: " + metadata.getJDBCMinorVersion());
        
        ResultSet schemasSet = metadata.getSchemas();
        ResultSetMetaData schemasMetadata = schemasSet.getMetaData();
        
        System.out.println();
        System.out.printf("%s\t%s\n", schemasMetadata.getColumnName(1), schemasMetadata.getColumnName(2));
        while (schemasSet.next()) {
            for (int i = 1; i <= schemasMetadata.getColumnCount(); i++) {
                System.out.printf("%11s\t", schemasSet.getString(i));
            }
            
            System.out.println();
        }
        
        System.out.println("\nNOT SQL:2003 keywords:"+ metadata.getSQLKeywords());
        System.out.println("STRING functions:"+ metadata.getStringFunctions());
        System.out.println("SYSTEM functions:"+ metadata.getSystemFunctions());
        System.out.println("TIME/DATE functions:"+ metadata.getTimeDateFunctions());
        
        schemasSet.close();
        connection.close();
    }
}

/**
 * To check:
 * - What method returns a Properties object?
 */