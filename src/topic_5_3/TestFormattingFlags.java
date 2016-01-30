package topic_5_3;

/**
 * - Flag chars are used for specific format like aligning, they are used after
 * the index number and before width.
 * - Flag chars are:
 *  - left justify
 *  + Sign symbol
 *  0 Padding with zeros
 *  , Locale-specific
 *  ( Enclose negative numbers
 */
public class TestFormattingFlags {
    public static void main(String[] args) {
        System.out.format("The variable is: %b", true);
        System.out.format("The variable is: %b", true);
        System.out.format("The variable is: %b", true);
    }
}

/**
 * To check:
 * - Change the width of the first sentence to print.
 * - Change the precision of the first sentence to print.
 * - Change the width and make it left justify for the first sentence to print.
 * - How precision modifier affects decimal numbers?
 * - What changes using the locale-specific modifier?
 * - What modifiers can be used with int arguments?
 * - Build a table (formatter string vs modifier) that points where they are compatible.
 */