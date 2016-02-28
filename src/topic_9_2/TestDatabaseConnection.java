package topic_9_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * - When working with databases, first there must be a Driver to use, then
 * get a Connection using DriverManager.
 * - To get a Connection the URL to the database is essential. Every database
 * provider defines its own URL format.
 */
public class TestDatabaseConnection {
    public static void main(String[] args) {
        //old way to load driver
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        
        //URL syntax:
        //jdbc:<subprotocol>:<subname>:/<host>:<port>/<db>?<propertie>=<value>
        
        String user = "app";
        String pwd = "app";
        try(Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", user, pwd)) {
//            Connection connection = DriverManager.getConnection("jdbc:derby:/localhost:1527/sample?user=" + user + "&password=" + pwd);
            
//            Properties properties = new Properties();
//            properties.put("user", user);
//            properties.put("password", pwd);
//            Connection connection = DriverManager.getConnection("jdbc:derby:/localhost:1527/sample", properties);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What Exceptions are thrown when:
 *  + Driver is not in classpath
 *  + User or password is incorrect
 *  + Database name doesn't exists
 * - What's the file name that contains the name of class that implements Driver interface?
 */