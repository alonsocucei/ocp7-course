package topic_5_3;

import java.util.Formatter;

/**
 * - Flag chars are used for specific format like aligning, they are used after
 * the index number and before width.
 * - Flag chars are:
 *  - left justify
 *  + Sign symbol
 *  0 Padding with zeros
 *  , Locale-specific
 *  ( Enclose negative numbers
 *   (space) inserts a leading space for positive numbers
 */
public class TestFormattingFlags {
    public static void main(String[] args) {
        System.out.format("The variable is: %-9.3b\n", true);
        System.out.format("The variable is: %04d\n", 48);
        System.out.format("The variable is: %+04d\n", 48);
        System.out.format("The variable is: % ,08d\n", 48000);
        System.out.format("The variable is: %+,08d\n", 48000);
        System.out.format("The variable is: %+(,08d\n", -48000);
        System.out.format("The variable is: %+(08d\n", -48000);
        System.out.format("The variable is: %+(,09f\n", -48000.12345658);
        System.out.format("The variable is: %+(,09.2f\n", -48000.125456);
        System.out.printf("%.2s\n", "hola");
        System.out.printf("%2$6.2s %2$b\n", "false", false);
    }
}

/**
 *     argument_index    flags    width    precision
 * %b        x             -        x         x
 * %c        x             -        x 
 * %d        x            all       x
 * %f        x            all       x         x  
 * %s        x             -        x         x
 */

/**
 * To check:
 * - Change the width of the first sentence to print.
 * - Change the precision of the first sentence to print.
 * - Change the width and make it left justify for the first sentence to print.
 * - How precision specifier affects decimal numbers?
 * - What changes using the locale specifier?
 * - What specifiers can be used with int (d) arguments?
 * - Build a table (formatter string vs specifier) that points where they are compatible.
 */