package topic_3_7;

import java.util.List;

/**
 * - Factory Pattern is a creational design Pattern.
 * - Eliminates direct constructor calls in favor of invoking method.
 * - Prevents tight coupling.
 * - Promotes creation of cohesive classes.
 * - Some Java API classes applying this design pattern are: Calendar, Arrays,
 * ResourceBundle, DriverManager, Connection, Statement, NumberFormat, Executors, etc.
 */
public class TestFactoryPattern {
    public static void main(String[] args) {
        //Factory Method Pattern
        UserDAO ud = FactoryUserDAO.getInstance();
        
        //Abstract Factory Pattern
        FactoryDAO fd = AbstractFactory.createFactory();
        UserDAO ufd = fd.getUserInstance();
    }
}

/**
 * To check:
 * - New DAO implementations for different types of data store using the User 
 * class are created, how can clients choose what version to instance?
 * - What if the DAO classes are a lot?
 */

abstract class AbstractFactory {
    public static FactoryDAO createFactory() {
        if (/*a system property is equals to excel*/ true) {
            return new FactoryExcelDAO();
        } 
//        else {
//            return new FactoryMemoryDAO();
//        }
        
//        return DefaultFactoryImpl(); //this would be the correct code to use
        return null; 
    }
}

abstract class FactoryDAO {
    abstract UserDAO getUserInstance();
//    abstract ProductDAO getProductInstance();
}

class FactoryExcelDAO extends FactoryDAO{
    public UserDAO getUserInstance() {
        return new UserDatabaseDAOExcelImpl();
    }
    
//    public ProductDAO getUserInstance() {
//        return new ProductDatabaseDAOExcelImpl();
//    }
}

class FactoryUserDAO {
    public static UserDAO getInstance() {
        if (/*some property in the system is true*/true) {
            return new UserDatabaseDAOMemoryImpl();
        } else {
            return new UserDatabaseDAOExcelImpl();
        } 
    }
}

class User {}

interface UserDAO {
    public void createUser(User user);
    public User readUser(User user);
    public List<User> readUsers(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
}

class UserDatabaseDAOMemoryImpl implements UserDAO {
    public void createUser(User user){}
    public User readUser(User user){ return null;}
    public List<User> readUsers(User user){return null;}
    public boolean updateUser(User user){ return false;}
    public boolean deleteUser(User user){ return false;}
}

class UserDatabaseDAOExcelImpl implements UserDAO {
    public void createUser(User user){}
    public User readUser(User user){ return null;}
    public List<User> readUsers(User user){return null;}
    public boolean updateUser(User user){ return false;}
    public boolean deleteUser(User user){ return false;}
}