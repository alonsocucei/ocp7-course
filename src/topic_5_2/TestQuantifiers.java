package topic_5_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - Quantifiers helps to repeat a regex from 0 to n times and to consume the
 * target string in a different way.
 * - There are 3 quantifiers:
 *   X+ (matches X one or more times)
 *   X* (matches X zero or more times)
 *   X? (matches X zero or 1 time)
 * - These group of quantifiers are known as greedy. The way they is reading the
 * complete target string and then check if there is a match, if it's not then
 * it goes back one char and tries again.
 */
public class TestQuantifiers {
    public static void main(String[] args) {
        String target = "uno once veintiuno un";
//        String regex = "(uno)*";
        String regex = "un.+";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        
        while (matcher.find()) {
            System.out.print(matcher.group());
            System.out.print(" start: " + matcher.start());
            System.out.println(" end: " + matcher.end());
        }
    }
}

/**
 * To check:
 * - How can we change the code in main to match the words un, uno using the same
 * regular expression?
 * - What is the result of using as regular expression the string: v?
 * - What happens when * and + quantifiers are used?
 */