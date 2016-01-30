package topic_5_3;

/**
 * - Methods printf and format are used to print formatted strings.
 * - Conversion characters are: %b, %c, %d, %f, %s
 * -
 */
public class TestFormatting {
    public static void main(String[] args) {
        System.out.format("Name %b, age %b", true, null);
        
        System.out.format("Name %c", 64);
    }
}

/**
 * To check:
 * - What happens if parameters exceeds the number of formatted strings?
 * - What happens if parameters are less than the number of formatted strings?
 * - What can be passed as argument to the %c conversion character?
 * - What can be passed as argument to the %s conversion character?
 * - What happens when null is send to the %s conversion character?
 * - What values the conversion character %f accepts?
 */