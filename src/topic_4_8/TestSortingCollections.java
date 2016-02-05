package topic_4_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * - Collections is a static class with utility methods. - Arrays is a static
 * class with utility methods. - Both classes contains methods to sort and
 * search elements.
 */
public class TestSortingCollections {

    public static void main(String[] args) {
        Integer a[] = {3, 1, 0, 4, 15, 9, 6};
        List<Integer> numbers = new ArrayList<>();

        for (int n : a) {
            numbers.add(n);
        }

        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        DescendingOrder descendingComparator = new DescendingOrder();
        Arrays.sort(a, descendingComparator);
        System.out.println(Arrays.toString(a));

        MyUser[] users = {new MyUser("Uno", 1), new MyUser("Dos", 2), new MyUser("Tres", 3), new MyUser("Cuatro", 4)};
        List<MyUser> listUsers = Arrays.asList(users);
        System.out.println(Arrays.toString(users));
        System.out.println(listUsers);
//        Arrays.sort(users);
        Collections.sort(listUsers);
        System.out.println(Arrays.toString(users));
        System.out.println(listUsers);
        Arrays.sort(users, new Comparator<MyUser>() {
            public int compare(MyUser u1, MyUser u2) {
                return u2.getId() - u1.getId();
            }
        });
        
        System.out.println(Arrays.toString(users));
        System.out.println(listUsers);
        
        MyUser[] usersArray = listUsers.toArray(new MyUser[0]);
        System.out.println(Arrays.toString(usersArray));
    }
}

class DescendingOrder implements Comparator<Integer> {

    public int compare(Integer n1, Integer n2) {
        return n2 - n1;
    }
}

class MyUser implements Comparable<MyUser> {

    private String name;
    private int id;

    public MyUser(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "id: " + id + ", name: " + name;
    }

    public int compareTo(MyUser user) {
        return getName().compareTo(user.getName());
    }
}

/**
 * To check:
 * - Sort the array using method sort in Arrays class.
 * - Sort in descending order the list using method sort in Collections class.
 * - What happens when trying to sort a Collection or Array of Objects which
 * class doesn't implement Comparable interface.
 */
