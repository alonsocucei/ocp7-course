package topic_2_3;

import java.lang.reflect.Field;

/**
 *
 * @author jjsanche
 */
//Final modifier doesn't allow to create classes that extends from this one
//String class is final
public final class FinalClass {
    public static void main(String[] args) {
    }
    
}

class FinalMethodClass{
    private final void privateMethod() {
        System.out.println("private final method");
    }
    
    public final void method1() {
        System.out.println("final method");
    }
    
    public static final void methodStaticFinal() {
        System.out.println("method static final");
    }
} 

class FinalMethodSubclass extends FinalMethodClass {
    //compile error: cannot override a final method in super class
//    public void method1() {
//        System.out.println("overriding final method");
//    }
    
    //Watch out!! This is overloading, and it's Ok.
    public void method1(int a) {}
    
    //This is not overriding as method in parent class cannot be accessed.
    private void privateMethod() {
        System.out.println("private method overriding?");
    }
    
    //compile error: cannot override static final methods in super class.
//    public static void methodStaticFinal() {
//        System.out.println("method static final");
//    }
}

//illegal combination of modifiers
//abstract classes are meant to be extended
//final class are meant to NOT be extended
//abstract final class NotValidClass{}
        
//compile error: cannot inherit from a final class
//class SubFinal extends FinalClass {}
