package topic_5_1;

import java.util.Arrays;

/**
 * - split method returns an array of String objects.
 * - The original String is divided according the regex passed as parameter.
 */
public class TestSplit {
    public static void main(String[] args) {
        String names = "Marco,Julio";
        
//        String [] namesArray = names.split("");
        String [] namesArray = names.split(",");
        System.out.println(Arrays.toString(namesArray));
    }
}

/**
 * To check:
 * - What's the default regex if none is passed as parameter?
 */