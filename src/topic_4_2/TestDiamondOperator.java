package topic_4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * - Diamond operator makes the compiler does inference to determine the correct type.
 */
public class TestDiamondOperator {
    public static void main(String[] args) {
        List rl = new ArrayList();
        rl.add("hola");
        List<Exception> le = new ArrayList<>(rl); //Exception is infered
//        List<> ld = new ArrayList<Exception>();//compile error: invalid syntax
        List<Exception> led = new ArrayList(rl);//compile warning: use of raw type
        
        le.add(null);
        led.add(null);
        Exception e = le.get(0);
    }
}

/**
 * To check:
 * - What's the difference between putting the diamond operator or just use a raw type?
 */