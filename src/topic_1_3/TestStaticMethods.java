package topic_1_3;

/**
 * For static methods involved with inheritance the way it works is actually the
 * opposite than concrete methods.
 * This means the method that will be called when program runs will be the one
 * declared in reference type.
 * 
 * @author alonsocucei
 */
public class TestStaticMethods {
    public static void main(String[] args) {
        A ab = new B();
        ab.hello(); //it will use method in class A
        B b = new B();
        b.hello();  //it will use method in class B
    }
}

class A {
    public static void hello() {
        System.out.println("hello from A");
    }
}

class B extends A {
    public static void hello() {
        System.out.println("hello from B");
    }
}

class C {
    public static void hi() {
        System.out.println("hi from C");
    }
}

class D {
    public static void hi() {
        System.out.println("hi from D");
    }
}