package topic_5_1;

/**
 * - Methods indexOf and lastIndexOf are overloaded in String class.
 * - The exam may contains questions about these methods and how they differ in use.
 */
public class TestStringIndexes {
    public static void main(String[] args) {
        String sentence = "exam certification java se 7";
        
        System.out.println(sentence.indexOf('t'));
        System.out.println(sentence.indexOf('t', -10));
        System.out.println(sentence.lastIndexOf('7'));
        System.out.println(sentence.lastIndexOf('7', 100));
    }
}

/**
 * To check:
 * - What is the result of compile and run the code in main?
 * - What other parameters these methods receive?
 */