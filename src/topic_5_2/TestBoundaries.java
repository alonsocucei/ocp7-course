package topic_5_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - \b and \B are used to restrict the search to be done for complete or to be
 * part or a word.
 */
public class TestBoundaries {
    public static void main(String[] args) {
//        String target = "uno once veintiuno";
//        String regex = "\\Buno";
        
        String target = "anita lava la tina";
        String regex = "(\\B|\\b)[an]{2}(\\B|\\b)";
        
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
 * - What is the result of compile and running the main method?
 * - Use the \b and \B at the beginning and end of the regular expression.
 * What is the result?
 */