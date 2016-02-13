package topic_7_1;

import java.io.Console;
import java.util.Arrays;

/**
 * - Console class allows to interact directly with console.
 * - readPassword method doesn't echo the chars written.
 * - For the exam, methods to know are: readPassword, readLine with overloading.
 */
public class TestConsole {

    public static void main(String[] args) {
        Console cons = System.console();
        char[] passwd;

        if (cons != null) {
            passwd = cons.readPassword("%s", "Password:");
            cons.format("Password is: %s", Arrays.toString(passwd));
            java.util.Arrays.fill(passwd, ' ');
        }
    }
}

/**
 * To check:
 * - What's the return type for readPassword method?
 * - What's the return type for readLine method?
 */