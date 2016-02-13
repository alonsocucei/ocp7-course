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
        sb.insert(6, "ghilalallaviu");
        sb.insert(6, "ghil0945rt489340dsf");
        System.out.println(sb);
//        sb.insert(-1, "a"); // StringIndexOutofBoundsException
        sb.insert(sb.length(), "a"); // index can be equals to length
        System.out.println(sb);
//        sb.insert(sb.length() + 3, "a"); // StringIndexOutOfBoundsException
        System.out.println(sb);
        
//        sb.delete(-1, 1); // StringIndexOutOfBoundsException
        sb.delete(sb.length() - 3, sb.length()); // valid from 0 to length
        System.out.println(sb);
        sb.delete(sb.length(), sb.length() + 10); // valid from 0 to length + n
//        sb.delete(sb.length() + 1, sb.length() + 10); // StringIndexOutOfBoundsException
        System.out.println(sb);
        
//        sb.replace(-1, 2, "hola"); // StringIndexOutOfBoundsException
        sb.replace(sb.length() - 2, sb.length(), "hola"); // valid from 0 to length
        System.out.println(sb);
        sb.replace(sb.length() - 2, sb.length() + 2, "hola"); // valid from 0 to length + n
//        sb.replace(sb.length() + 1 2, sb.length() + 2, "hola"); // StringIndexOutOfBoundsException
        
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(sb.length());
    }
}

/**
 * To check:
 * - What indexes values are valid when calling insert method?
 * - What indexes values are valid when calling delete method?
 * - What indexes values are valid when calling replace method?
 * - What's the default capacity?
 * - What's the difference between capacity and length?
 * - How is capacity modified?
 */