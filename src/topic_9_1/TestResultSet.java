package topic_9_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * - java.sql.ResultSet is like a matrix where results after executing a query
 * are stored.
 * - To get a ResultSet object call one of the methods in java.sql.Statement like
 * executeQuery().
 */
public class TestResultSet {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT NAME FROM CUSTOMER");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }
}

/**
 * To check:
 * - What values a result set type and concurrency can have?
 * - Where these values are set?
 */