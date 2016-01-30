package topic_5_1;

import java.util.StringTokenizer;

/**
 * - It's use is not recommended.
 * - Use split instead StringTokenizer class.
 */
public class TestStringTokenizer {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("uno dos tres");
        
//        while (tokenizer.hasMoreTokens())
        while (tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}

/**
 * To check:
 * - What happens if null is passed as delimiter in constructor?
 * - What does the overloaded method nextToken that receives a String parameter?
 * - What's the difference between hasMoreTokens and hasMoreElements methods?
 * - What's the difference between nextToken and nextElement methods?
 */