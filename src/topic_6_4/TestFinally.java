package topic_6_4;

/**
 * - finally block always executes except when: System.exit() is called or VM is shutdown.
 * - finally blocks must be after a catch block or next to try block if there's no
 * catch block at all.
 */
public class TestFinally {
    public static void main(String[] args) {
        try {
            System.out.println(5 / 0);
        } catch (Exception e) {
            //empty catch block
//            return;
//            System.exit(0);
        } finally {
            System.out.println("first finally block");
        }
        
        try {
            System.out.println(3 / 0);
        } finally {
            System.out.println("second finally block");
        }
    }
}

/**
 * To check:
 * - What's the output of the program?
 * - What happens if a return statement is added uncommented?
 */