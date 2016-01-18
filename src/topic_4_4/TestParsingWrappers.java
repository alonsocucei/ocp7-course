package topic_4_4;

/**
 * - All wrapper classes (except Character) have methods to parse from String to the corresponding data type.
 */
public class TestParsingWrappers {
    public static void main(String[] args) {
        Integer.parseInt("34");
        Integer.parseInt("34abc");
        Integer.parseInt("34abc", 16);
        Boolean.parseBoolean("lalala");
    }
}
