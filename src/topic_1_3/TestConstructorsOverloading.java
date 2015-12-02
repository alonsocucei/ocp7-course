package topic_1_3;

/**
 * This file demonstrates the Constructor Overloading and the flow it follows when
 * an object is created or even before, when class is loaded:
 * 
 * load class -> run static initializers (in the order they were declared) -> 
 * run instance initializers -> run super classes constructors ->
 * run class constructor.
 * 
 * A constructor call will always end calling its super class constructor, it can
 * be directly or indirectly calling different constructors in the same class.
 * This chain of calls ends when Object class is reached.
 * 
 * If super() statement is not explicitly written, then the compiler will add it for us.
 * 
 * super() and this() statements have the same rule, they must be the first 
 * sentence in the constructor, therefore just one of them will be allowed.
 * 
 * @author alonsocucei
 */
public class TestConstructorsOverloading {
    public static void main(String[] args) {
        C2 c2 = new C2();
        C2 c2_main = new C2("C2-main");
        C2 c3_main = new C2("C3-main", "2 parameters constructor");
    }
}

class C1 {
    {
        System.out.println("C1 initializer");
    }
    
    {
        System.out.println("C1-2 initializer");
    }
    
    static {
        System.out.println("C1 static initializer");
    }
    
    C1 () {
        System.out.println("C1 constructor no args");
    }
    
    C1(String s) {
        System.out.print("C1 constructor 1 arg\t");
        System.out.println(s);
    }
}

class C2 extends C1 {
    C2() {
        System.out.println("C2 constructor no args");
    }
    
    static {
        System.out.println("C2 static initializer");
    }
    
    {
        System.out.println("C2 initializer");
    }
    
    C2(String s) {
        this();
        System.out.print("C2 constructor 1 arg\t");
        System.out.println(s);
    }
    
    C2(String s, String s2) {
        super(s);
        System.out.print("C2 constructor 2 args\t");
        System.out.println(s2);
    }
}