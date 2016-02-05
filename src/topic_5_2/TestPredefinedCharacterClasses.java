package topic_5_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - Predefined character classes are common regex abbreviated in a single char
 * preceded by a slash \.
 * - Character classes are: \d, \D, \w, \W, \s, \S and .
 * - Slash must be escaped using another slash; for instance:(\\d);
 */
public class TestPredefinedCharacterClasses {
    public static void main(String[] args) {
        String target = "15 38 next $43_22 ";
        String regex_d = "\\W";
        
        Pattern pattern = Pattern.compile(regex_d);
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
 * - What is the result of compile and running the code in main?
 * - Use every one of the predefined character classes, what's the result?
 */