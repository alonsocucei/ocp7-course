package topic_4_4;

/**
 * - Autoboxing refers to convert a primitive to a Wrapper.
 * - Autounboxing refers to convert a Wrapper to a primitive.
 * - Performance is better with primitives than with Wrappers.
 */
public class TestAuto_Boxing_Unboxing {
    public static void main(String[] args) {
        Integer i = 3;
        System.out.println(i.compareTo(4));
        
        Integer i2 = null;
        System.out.println(++i2);
        
        Integer total = 0;
        for (Integer j = 0; j < 4; j ++) {
            total += j;
        }
        
        System.out.println(total);
    }
}

/**
 * To check:
 * - What will be printed in method main? 
 */