package topic_5_1;

/**
 * - The exam will ask you about methods like: startsWith, endsWith, compareTo,
 * compareToIgnoreCase, equals, equalsIgnoreCase.
 */
public class TestComparisions {
    public static void main(String[] args) {
        String test = "This is a test string";
        System.out.println("test.startsWith(\"T\") " + test.startsWith("T"));
//        System.out.println("test.startsWith(null)" + test.startsWith(null));
        System.out.println("test.endsWith(\"T\") " + test.endsWith("T"));
//        System.out.println("test.endsWith(null)" + test.endsWith(null));
        System.out.println("test.equals(\"T\") " + test.equals("T"));
        System.out.println("test.equals(null)" + test.equals(null));
        System.out.println("test.equalsIgnoreCase(\"T\") " + test.equalsIgnoreCase("T"));
        System.out.println("test.equalsIgnoreCase(null)" + test.equalsIgnoreCase(null));
        System.out.println("test.compareTo(\"T\") " + test.compareTo("T"));
//        System.out.println("test.compareTo(null) " + test.compareTo(null));
        System.out.println("test.compareToIgnoreCase(\"T\") " + test.compareToIgnoreCase("T"));
//        System.out.println("test.compareToIgnoreCase(null) " + test.compareToIgnoreCase(null));
    }
}

/**
 * To check:
 * - Test every one of the methods mentioned.
 * - Check for parameters and return types.
 * - Check when they may throw an exception.
 */