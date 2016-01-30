package topic_5_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - Regex describe data.
 * - Regex are used to search, replace or format text.
 * - Character classes allows to find one, one of many, or a range of chars
 * in text.
 * - java.util.regex is the package where classes for regex can be found.
 */
public class TestCharacterClasses {
    public static void main(String[] args) {
        String target = "Im fine to dine at nine";
        //simple
        String regex = "[fdn]ine";
        
        //range
        String regexRange = "[c-k]ine";
        
        //negation
        String regexNegation = "[^dn]ine";
        
        Pattern pattern = Pattern.compile(regexNegation);
        Matcher matcher = pattern.matcher(target);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

/**
 * To check:
 *  - What would be the regular expression for a valid date?
 *  - What must be changed if the date format allows 3 chars to describe month?
 */