package topic_6_4;

/**
 * - Custom exceptions extends an exception class.
 * - Normally checked exceptions are the most used.
 * - Before creating a custom exception check the API twice, you may find an 
 * exception that fits your needs.
 */
public class TestCustomException {
    public static void main(String[] args) {
//        throw new CustomException();
//        throw new CustomException("message");
    }
}

class CustomException extends Exception {
}

/**
 * To check:
 * - Complete the code to create a custom checked/unchecked exception.
 * - Declare 2 constructors: a no arg(), and a String one (String message).
 */