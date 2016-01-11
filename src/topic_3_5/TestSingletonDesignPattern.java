package topic_3_5;

/**
 * - A singleton class has the following characteristics:
 *  - A private static variable to store a single instance.
 *  - A public static method returning the reference to the instance.
 *  - A private constructor.
 */
public class TestSingletonDesignPattern {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
//        Singleton s2 = new Singleton(); //compile error: private constructor
        Singleton s3 = Singleton.getInstance();
        System.out.println(s == s3);
    }
}

/**
 * To check:
 * - How lazy initialization is applied?
 * - What happens when Threads are used?
 */
class Singleton {
    private static Singleton instance = new Singleton();
    
    public static Singleton getInstance() {
        return instance;
    }
    
    private Singleton(){}
}