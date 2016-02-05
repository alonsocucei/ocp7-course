package topic_5_1;

/**
 * - Methods contains, subSequence and substring are used to test or get part
 * of a text for String objects.
 */
public class TestStringContent {
    public static void main(String[] args) {
        String content = "Exames takes 2 hours and a half";
        
        System.out.println(content.contains("2 Hours"));
        System.out.println(content.substring(0));
        System.out.println(content.substring(content.length()));
        System.out.println(content.substring(0, 6));
        System.out.println(content.substring(7, 12));
//        System.out.println(content.charAt(content.length()));
    }
}

/**
 * To check:
 * - What's the difference between subSequence and substring methods?
 * - What happens when an invalid index is passed as parameter?
 */