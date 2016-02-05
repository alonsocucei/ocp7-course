package topic_5_1;

/**
 * - String class contains 4 replacing methods:
 *   replace(char, char)
 *   replace(CharSequence, CharSequence)
 *   replaceFirst(String, String)
 *   replaceAll(String, String)
 */
public class TestReplacing {
    public static void main(String[] args) {
        String javaVersions = "1.2 1.3 1.4 5 6 7 8";
        
        System.out.println(javaVersions.replace('.', ','));
        System.out.println(javaVersions.replace(".", ","));
        System.out.println(javaVersions.replaceFirst("\\.", ","));
        System.out.println(javaVersions.replaceAll("\\.", ","));
    }
}

/**
 * To check:
 * - What happens when the searched string is not found?
 * - What types these methods accept as parameters?
 */