package topic_4_5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * - Set extends Collection interface
 * - Elements in a Set need to implement hashCode and equals methods correctly.
 */
public class TestSets {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        
        //add 3 names
        names.add("Alonso");
        names.add("Marco");
        names.add("Julio");
        names.add(null);//NullPointerException when implementation is a TreeSet
        
        //check if set is empty
        System.out.println("is empty: " + names.isEmpty());
        
        //check if "Alonso" is in the set
        System.out.println("is Alonso in the set: " + names.contains("Alonso"));
        
        //print the number of elements contained in the set
        System.out.println("size is:" + names.size());
        
        //print the complete set
        System.out.println(names);
        
        for (String name: names) {
            System.out.println(name);
        }
        
        //get a subset that contains the last 2 elements
        //not possible to know
        Set<EqualClass> duplicatedSet = new TreeSet<>();
        duplicatedSet.add(new EqualClass(1));
        duplicatedSet.add(new EqualClass(2));
        duplicatedSet.add(new EqualClass(1));
        System.out.println(duplicatedSet);
    }
}

class EqualClass {
    private int id;
    
    public EqualClass(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "id: " + id;
    }
    
    @Override
    public boolean equals(Object o) {
        return ((EqualClass) o).id == id;
    }
    
    @Override
    public int hashCode() {
        return id;
    }
}

/**
 * To check:
 * - Does a set allows null values?
 * - Does a set allows duplicate values?
 * - Is a set is ordered or unordered?
 * - Is a set sorted?
 * - What classes implement Set?
 * - What's the difference between HashSet and LinkedHashSet?
 * - What's the difference between TreeSet and the previous 2?
 */