package topic_4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * - Bounded wildcards allows you have options (subclasses) when declaring a Collection that 
 * stores generic types.
 * - For upper bounded wild cards (? extends T), you still cannot add elements.
 * - For lower bounded wild cards (? supper T), you can add elements of subclasses.
 */
public class TestGenericBoundedWildcards {
    public static void main(String[] args) {
        //upper bounded wild cards
        List<? extends Number> li = new ArrayList<Integer>();
        List<? extends Number> lf = new ArrayList<Float>();
        List<? extends Number> ld = new ArrayList<Double>();
//        li.add(3);//compile error: can't guarantee it's an Integer
        li.get(0).byteValue(); //read as Number object
        
        //lower bounded wild cards
        List<? super RuntimeException> lre = new ArrayList<Exception>();
//        lre.add(new Exception());//compile error: just subtypes are allowed to add
        lre.add(new NullPointerException());
        lre.add(new ArithmeticException());
        
//      RuntimeException re = lre.get(0); //compile error: it's read as an Object, casting must be used
        RuntimeException re = (RuntimeException) lre.get(0);
    }
}