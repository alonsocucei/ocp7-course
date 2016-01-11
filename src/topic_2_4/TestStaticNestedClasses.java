package topic_2_4;

/**
 * - Static Nested Classes are declared inside a class using the static keyword.
 * - These classes cannot access non static members of the outer class.
 * - To create an instance of the static class it's not needed an instance of
 * the outer class.
 * - Valid modifiers are: private, protected, public, abstract, final and strictfp.
 * - Static Nested Classes are known as top level classes.
 */
public class TestStaticNestedClasses {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass snc = new OuterClass.StaticNestedClass();
        snc.m1();
        OuterClass oc = new OuterClass();
        oc.outerStaticField = 3;
//        oc.StaticNestedClass osnc = new oc.StaticNestedClass(); //compile error
//        StaticNestedClass s = new StaticNestedClass(); //compile error
    }
}

/**
 * To check:
 * - How to create instances of the static class both inside and outside the outer class.
 * - Field access
 * - Change access modifiers for the static nested class.
 */
class OuterClass {
    private int outerField;
    public static  int outerStaticField;
    private StaticNestedClass snc = new StaticNestedClass();
    
    public static class StaticNestedClass {
        private int nestedField;
        private static int staticNestedField;
        
        public void m1() {
            System.out.println(outerStaticField);
//            System.out.println(outerField); //compiler error: cannot access a non-static member of outer class.
        }
    }
}