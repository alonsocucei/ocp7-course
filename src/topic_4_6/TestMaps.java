package topic_4_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * - Map doesn't extends from Collection
 * - Elements in a Map need to implement hashCode and equals methods correctly.
 */
public class TestMaps {
    public static void main(String[] args) {
         Map<Integer, String> names = new HashMap<>();
        
        //add 3 names
        names.put(1, "Alonso");
        names.put(1, "Marco");
        names.put(2, "Alonso");
        names.put(3, null); //NullPointerException for Hashtable
        names.put(null, null);//NullPointerException for Hashtable and TreeMap
        
        //check if map is empty
        System.out.println("is empty: "  + names.isEmpty());
        
        //print the number of elements contained in the map
        System.out.println("size is:" + names.size());
        
        //print the complete map
        System.out.println(names);
        
        //print the keys
        System.out.println(names.keySet());
        
        //print the values
        System.out.println(names.values());
        
        //check if "Alonso" is in the map
        System.out.println("is Alonso in the map: " + names.values().contains("Alonso"));
        
        //print key-values using the Map.Entry interface
        
        for (Integer key : names.keySet()) {
            System.out.println(key + "=" + names.get(key));
        }
        
        Set<Map.Entry<Integer, String>> entries = names.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}

/**
 * To check:
 * - Does a map allows null values?
 * - Does a map allows null keys?
 * - Does a map allows duplicate values?
 * - Does a map allows duplicate keys?
 * - Is a map is ordered or unordered?
 * - Is a map sorted?
 * - What classes implement Map?
 * - What's the difference between Hashtable and HashMap?
 * - What's the difference between LinkedHashMap and the previous 2?
 * - What's the difference between TreeMap and the previous 2?
 */