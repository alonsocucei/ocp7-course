package topic_6_1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * - throws keyword is used to declare Exceptions.
 * - Exceptions declared can be of any type (checked or unchecked). 
 * - Declaring unchecked Exceptions is optional.
 * - Declaring checked Exceptions is NOT optional.
 * - When a method declares checked Exceptions, these must be handle by the caller
 * method, or re-thrown.
 */
public class TestThrows {
    public static void main(String[] args) throws Throwable {
        handleException();
        rethrowException();
    }
    
    public static void handleException() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            //At least print the exception message
            System.err.println(e.getMessage());
        }
    }
    
    public static void rethrowException() throws Exception {
        handleException();
    }
    
    public void testSuper() throws IOException {}
}

class T2 extends TestThrows {
    public void testSuper() throws FileNotFoundException, EOFException, 
            NullPointerException, ClassCastException, IndexOutOfBoundsException {}
}

/**
 * To check:
 * - How throws declaration affects overloading?
 * - How throws declaration affects overriding?
 * - What happens if method declares a checked Exception that is not actually thrown?
 * - What happens if declaring Throwable class in main method?
 */