package topic_9_1;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * - java.sql is the main package containing interfaces that allows to interact
 * with data bases.
 * - DriverManager class allows to get all Drivers available and create a 
 * connection to a database.
 *
 */
public class TestDriver {

    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.printf("Class name: %s\n", driver.getClass().getName());
            System.out.printf("Major version: %s\n", driver.getMajorVersion());
            System.out.printf("Minor version: %s\n", driver.getMinorVersion());
        }
    }
}

/**
 * To check:
 * - What does it means the driver is jdbc compliant?
 */
