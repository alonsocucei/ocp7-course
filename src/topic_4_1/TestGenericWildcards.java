package topic_4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * - Wildcards allows you to save any type.
 * - Generics don't work as normal objects where you can save anything in an
 * Object reference variable. In generics this will generate a compile error.
 */
public class TestGenericWildcards {
    public static void main(String[] args) {
        Object o = new Integer(3);
        
//        List<Object> l1 = new ArrayList<Integer>();//compile error: incompatible types
        List<?> l2 = new ArrayList<Integer>(); //ok, ? wildcard allows you to store any type
//        l2.add(3);//compile error: can't guarantee type is Number
    }
}

