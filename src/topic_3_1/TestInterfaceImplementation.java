package topic_3_1;

/**
 * - A class can implement 0...n interfaces
 * - The first concrete class must implement all methods in the hierarchy of 
 * interfaces implemented.
 * - Classes implementing an interface must declare methods with public access modifier.
 */

/**
 * To check:
 * - A class implements two interfaces. Both interfaces declare a method with
 * same name, but different: 1) parameters, 2)return type. What happens for
 * each case?
 */
public class TestInterfaceImplementation implements TheInterface, MyInterface {
    public void test() {
        System.out.println("Test");
    }
    
    public void test(String s) {
        System.out.println("Test String");
    }
    
    public void test2() {}
    public void firstMethod() {}
}

interface FirstInterface {
    void firstMethod();
}

interface TheInterface extends FirstInterface {
    void test();
    void test2();
}

interface MyInterface {
    void test(String s);
//    String test2(); // a class cannot implement 2 methods with same name and parameters and different return type
}