package topic_6_1;

/**
 * - throw keyword is used to actually throw Exceptions.
 * - Line reported will be where the Exception instance is created.
 * - When used to throw a checked Exception then the method must handle it, re-throw it
 * or declare it.
 */
public class TestThrow {

    public static int division(int dividend, int divider) {
        
        if (divider == 0) {
            throw new ArithmeticException();
        }
        
        return dividend / divider;
    }

    public static void main(String args[]) {
        System.out.println(division(3, 2));
//        System.out.println(3/0);
//        System.out.println(division(3, 0));
    }
}

/**
 * To check:
 * - What's the difference between creating the Exception at the same line where
 * it's being thrown and creating it in a different line?
 * - What would be the difference in the output between lines 24 and 25?
 */