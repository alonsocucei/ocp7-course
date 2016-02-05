package topic_6_5;

/**
 * - assert was introduced as keyword on Java SE 1.4.
 * - Previous versions to 1.4 are able to use assert as identifier.
 * - javac -source <version> may behave different depending on how assert is used.
 */
public class TestAssertAsIdentifier {
    public static void main(String[] args) {
//        int assert = 3; //compiles for 1.3, doesn't compile for 1.4 or greater versions.
//        assert true; //compiles for 1.4 or greater versions, doesn't compile for 1.3 or previous versions.
    }
}
