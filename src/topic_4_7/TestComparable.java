package topic_4_7;

import java.util.Set;
import java.util.TreeSet;

/**
 * - Comparable interface is used to compare objects of the same class -
 * compareTo method must be implemented - return values are negative, 0 or
 * positive
 */
public class TestComparable {

    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();

        names.add("Alonso");
        names.add("Julio");
        names.add("Marco");

        for (String name : names) {
            System.out.println(name);
        }

        Set<User> users = new TreeSet<>();

        users.add(new User("Alonso", 31));
        users.add(new User("Alonso", 29));
        users.add(new User("Alonso", 32));
        users.add(new User("Julio", 30));
        users.add(new User("Marco", 26));

        for (User user : users) {
            System.out.println(user);
        }
    }
}

class User implements Comparable<User> {

    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(User user) {
//        return name.compareTo(user.name);
//        return user.name.compareTo(name); //descending sort
//        return age - user.age;
//        return user.age - age;//descending sort

        if (name.compareTo(user.name) == 0) {
            return age - user.age;
        } else {
            return name.compareTo(user.name);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age;
    }
}

/**
 * To check:
 * - Does the code compiles?
 * - Does the code runs?
 * - Implement the Comparable interface for a User class.
 * - What the compareTo method declares as parameter?
 * - What the equals method declares as parameter?
 */
