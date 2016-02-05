package topic_6_1;

/**
 * - throws keyword is used to declare Exceptions.
 * - Exceptions declared can be of any type (checked or unchecked). 
 * - Declaring unchecked Exceptions is optional.
 * - Declaring checked Exceptions is NOT optional.
 * - When a method declares checked Exceptions, these must be handle by the caller
 * method, or re-thrown.
 */
public class TestThrows {
    public static void main(String[] args) {
//        handleException();
//        rethrowException();
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
}

/**
 * To check:
 * - How throws declaration affects overloading?
 * - How throws declaration affects overriding?
 * - What happens if method declares a checked Exception that is not actually thrown?
 * - What happens if declaring Throwable class in main method?
 */