package topic_4_4;

/**
 * - The difference between valueOf method and constructor is the method uses cache
 * objects previously defined and will return them, otherwise will create a new one.
 */
public class TestValueOfMethod {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(3);
        Integer i2 = Integer.valueOf("3");
        
        System.out.println(i == i2);
        
        Integer i3 = Integer.valueOf(333);
        Integer i4 = Integer.valueOf("333");
        
        System.out.println(i3 == i4);
    }
}

/**
 * To check:
 * - What classes cache numbers from -128 to 127?
 * - What will be printed in main method?
 */