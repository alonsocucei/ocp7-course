package topic_3_6;

import java.util.List;

/**
 * - DAO Pattern stands for (Data Access Object)
 * - Encapsulates all access to data base.
 * - It makes easier code organization.
 * - It makes easier code maintenance.
 * - Class implementing DAO can be changed with no impact to object model.
 */
public class TestDAOPattern {
    public static void main(String[] args) {
        UserDAO um = new UsersManager();
        um.createUser(new User());
    }
}

/**
 * To check:
 * - What responsibilities the User class must have?
 * - How do you think would be a better design for the problem?
 * - What if the new design changes?
 */
class User {
    private String name;
    private String email;
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}

interface UserDAO {
    public void createUser(User user);
    public User readUser(User user);
    public List<User> readUsers(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
}

class UsersManager implements UserDAO {
    public void createUser(User user){}
    public User readUser(User user){ return null;}
    public List<User> readUsers(User user){return null;}
    public boolean updateUser(User user){ return false;}
    public boolean deleteUser(User user){ return false;}
}