package topic_2_4;

/**
 * - Anonymous classes don't have a name.
 * - Anonymous classes can extend a class OR implement a interface.
 * - Anonymous classes don't have constructors.
 */

/**
 * To check:
 * - How to create Anonymous classes.
 * - Compare syntax when creating anonymous classes in method parameters and
 * as part of an assignment expression.
 * - Declare extra methods not originally declared in the extended class or
 * implemented interface and try to use it.
 * - What anonymous classes can access?
 */
public class TestAnonymousInnerClasses {
    public static void main(String[] args) {
        Object o = new Object() {
            private int attribute;
            
            public String toString() {
                m1();
                return "Anonymous class";
            }
            
            public void m1() {
                System.out.println("m1 method");
            }
        };
        
        System.out.println(o);
//        o.m1();//compile error: m1 doesn't exist in Object class
        int localVariable = 5;
        final int finalLocalVariable = 5;
        
        Electronic e = new Electronic() {
            public void sayHi() {
                System.out.println("Hi");
//                System.out.println(localVariable); //compile error: cannot access local variables unless they are final.
                System.out.println(finalLocalVariable);
            }
        };
        
        sm(e);
        sm(new Electronic(){
            public void sayHi() {
                System.out.println("Hi parameter");
            }
        });
    }
    
    public static void sm(Electronic e) {
        e.sayHi();
    }
}

interface Electronic {
    void sayHi();
}