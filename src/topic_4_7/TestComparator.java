package topic_4_7;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * - Used to define the sort order of a collection.
 * - A comparator doesn't need to be implemented in the same class that is
 * being sorted.
 */
public class TestComparator {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
//                return s2.length() - s1.length();//descending sort
            }
        });
        
        names.add("Alonso");
        names.add("Julio");
        names.add("Marco");
        
        for (String name: names) {
            System.out.println(name);
        }
        
        Set<User> users = new TreeSet<>(new Comparator<User>(){
            public int compare(User u1, User u2) {
                return u2.getName().compareTo(u1.getName());//descending sort
//                return u1.getName().compareTo(u2.getName());
            }
        });
        
        users.add(new User("Julio", 30));
        users.add(new User("Alonso", 31));
        users.add(new User("Marco", 26));
        
        for (User user: users) {
            System.out.println(user);
        }
    }
}

/**
 * To check:
 * - Add the needed code to sort names in descending order.
 * - Add the needed code to sort users by age.
 */