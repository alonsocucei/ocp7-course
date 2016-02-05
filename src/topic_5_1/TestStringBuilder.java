package topic_5_1;

/**
 * - StringBuilder is mutable.
 * - StringBuilder is not synchronized (not thread safe)
 * - StringBuilder methods return a reference to itself, so methods can be chained.
 * - Important methods for the exam are: append, insert, delete, replace and reverse.
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc").reverse().insert(3, "def");
//        sb.insert(6, "ghilalallaviu");
//        sb.insert(6, "ghil0945rt489340");
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(sb.length());
    }
}

/**
 * To check:
 * - What indexes values are valid when calling insert method?
 * - What indexes values are valid when calling delete method?
 * - What's the default capacity?
 * - What's the difference between capacity and length?
 * - How is capacity modified?
 */