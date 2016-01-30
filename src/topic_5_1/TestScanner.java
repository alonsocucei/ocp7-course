package topic_5_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * - Scanner class works to scan text using regular expressions. - A delimiter
 * is used to read the text in parts. - Default delimiter is space. - Contains
 * method to look for specific data types.
 */
public class TestScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("the sum of 3 plus 2.4 and 5.2 is 8.6");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        
        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input);
        s.findInLine("(\\d+)fish(\\d+)fish(\\w+)fish(\\w+)");
        
        while (s.hasNext()) System.out.println(s.next());
    }
}

/**
 * To check:
 * - What will be printed?
 * - What needs to be modified in order to print the real sum?
 * - What happens if next method is call when scanner doesn't have any elements?
 * - Bound a Scanner to the System.in and ask for a double number to exit.
 */
