package topic_9_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - java.sql.Statement interface allow to create query statements for select,
 * update, remove or update records in the database.
 * - To create a java.sql.Statement object call the createStatement() method from the Connection
 * interface.
 */
public class TestStatement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement statement = connection.createStatement();
        
        System.out.println(statement);
        
        statement.close();
        connection.close();
    }
}

/**
 * To check:
 * - What are most used methods in java.sql.Statement interface?
 */