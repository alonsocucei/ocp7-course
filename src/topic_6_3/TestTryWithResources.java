package topic_6_3;

import java.io.FileReader;
import java.io.PrintStream;

/**
 * - try-with-resources statement save typing catch blocks.
 * - this feature was added in Java SE 7.
 * - try-with-resources statements can be applied to those blocks of code where
 * the class of the calling method implements one of Closable or AutoClosable interfaces.
 */
public class TestTryWithResources {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream(System.out);
                FileReader fr = new FileReader("");
                MyResource mr = new MyResource();
                MyResource mr2 = new MyResource()) {
            
            System.out.println("fin");
        } catch(Exception e) {
//            System.err.println("exception");
            System.err.println(e.getMessage());
        }
    }
}

class MyResource implements AutoCloseable {
    public void close() throws Exception {
        System.out.println("closing");
        throw new Exception("My Resource");
    }
}

/**
 * To check:
 * - What happens if declaring a String inside the parenthesis of the resources block?
 * - What happens if resources are reassigned inside the try block?
 * - What's the difference between Closeable and AutoClosable interfaces?
 * - What happens if a catch and/or finally blocks are added to a try-with-resources statement?
 */