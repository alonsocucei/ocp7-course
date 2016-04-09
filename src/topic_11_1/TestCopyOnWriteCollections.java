package topic_11_1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * - Using copy-on-write collections eliminates the need of implementing
 * synchronization or locking.
 * - CopyOnWriteArrayList will never modify its internal array, any mutating
 * operation will cause to create a new copy of the array.
 * - CopyOnWriteArraySet works the same way.
 */
public class TestCopyOnWriteCollections {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> cal = new CopyOnWriteArrayList<>(new String[]{"1", "2", "3"});
        Iterator it = cal.iterator();
        cal.add("4");
        cal.add("5");
        cal.add("6");
        
//        for(String s: cal) {
//            System.out.printf("%s \n", s);
//            cal.add("n");
//        }
        
        while (it.hasNext()) {
            System.out.printf("%s \n", it.next());
//            cal.add("n");
//            it.remove();
        }
        
        System.out.println(cal);
    }
}

/**
 * To check:
 * - What happens when removing an element using the iterator?
 * - What's the difference between using enhanced for and iterator?
 * - What happens if elements are added in either of the loops?
 */