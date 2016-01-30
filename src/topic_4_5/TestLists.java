package topic_4_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * - JCF stands for Java Collections Framework.
 * - Collections belong to java.util package
 * - List extends Collection interface
 */
public class TestLists {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        
        //add 3 names
        names.add("Alonso");
        names.add("Marco");
        names.add("Julio");
        names.add("Julio");
        names.add(null);
        System.out.println(names.indexOf("Julio"));
        System.out.println(names.lastIndexOf("Julio"));
        
        //check if list is empty
        names.isEmpty();
        
        //replace a name for other
        names.set(0, "Agua");
        
        //remove the second one
        names.remove(1);
//        names.remove(names.get(1));
        
        //insert a name in the middle of the list
        names.add(3, "Nuevo");
        
        //print the last name in the list
        System.out.println(names.get(names.size() - 1));
        
        //check if "Alonso" is in the list
        names.contains("Julio");
        System.out.println(names.indexOf("Pedro"));
        
        //print the number of elements contained in the list
        System.out.println(names.size());
        
        //print the complete list
        System.out.println(names);
        
        Iterator iterator = names.iterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            names.add("hola"); //ConcurrentModificationException
        }
//        iterator.next(); NoSuchElementException
        
        //OutOfMemoryError
//        for (;;) {
//            names.add("hola");
//        }
        
        //get a sublist that contains the last 2 elements
        System.out.println(names.subList(names.size() - 2, names.size()));
    }
}

/**
 * To check:
 * - Does a list allows null values?
 * - Does a list allows duplicate values?
 * - Is a list is ordered or unordered?
 * - Is a list sorted?
 * - What classes implement List?
 * - What's the difference between ArrayList and Vector?
 * - What's the difference between ArrayList and LinkedList?
 */