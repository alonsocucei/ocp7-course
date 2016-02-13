package topic_5_3;

import java.util.ArrayList;

/**
 * - Methods printf and format are used to print formatted strings.
 * - Conversion characters are: %b, %c, %d, %f, %s
 * -
 */
public class TestFormatting {
    public static void main(String[] args) {
        System.out.printf("null:%b double:%b float:%b long:%b int:%b short:%b byte:%b char:%b String:%b\n",
                           null, 3.5, 2.3f, 4L, 0, (short)-3, (byte)2, 'b', "false");
        
        System.out.printf("null:%c int:%c short:%c byte:%c char:%c unicode:%c\n",
                           null, 97, (short)99, (byte)99, 'b', '\u0040');
        
        System.out.printf("null:%d long:%d int:%d short:%d byte:%d\n",
                           null, 4L, 0, (short)-3, (byte)2);
        
        System.out.printf("null:%f double:%f float:%f\n",
                           null, 3.5, 2.3f);
        
        System.out.printf("null:%s double:%s float:%s long:%s int:%s short:%s byte:%s char:%s String:%s\n",
                           null, 3.5, 2.3f, 4L, 0, (short)-3, (byte)2, 'b', "str");
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