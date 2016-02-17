package topic_6_3;

import java.io.Closeable;

/**
 * - A program may have suppressed exceptions when a exception is thrown inside a
 * try-with-resources statement and calling the close throws another exception.
 * - Suppressed exceptions can be recover using the getSuppressed() method in Throwable class.
 */
public class TestSuppressedExceptions {
    public static void main(String[] args) {
        try(One o = new One();
                Two t = new Two()
                ) {
        }
        
        try(
                Three th = new Three("1");
                Three th2 = new Three("2");){
//                Two t = new Two()) {
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(e);
            
            for (Throwable t: e.getSuppressed()) {
                System.out.println(t);
            }
        }
    }
}

class One implements AutoCloseable {
    public void close() {
        System.out.println("Closing One");
    }
}

class Two implements AutoCloseable {
    public void close() {
        System.out.println("Closing Two");
    }
}

class Three implements Closeable {
    private String id;
    public Three(String id) {this.id = id;}
    
    public void close() {
        System.out.println("Closing Three, id:" + id);
        throw new IllegalArgumentException("test: " + id);
    }
}
/**
 * To check:
 * - What will be printed after running the first part of the program?
 * - What happens if close methods declare to throw a Exception?
 * - What will be printed after running the second part of the program?
 * - How can we access the IllegalArgumentException thrown by close method in class Three?
 * - What happens if the variable 'two' of the second part of the program is
 * changed to be of type Three too?
 */