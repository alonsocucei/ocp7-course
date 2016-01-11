package topic_3_1;

/**
 * - Interfaces purpose is to create a contract.
 * - Valid access modifiers for top level interfaces are: public or default.
 * - Valid non-access modifiers for top level interfaces are: abstract and strictfp.
 * - Interfaces can extend 0..n interfaces.
 * - All variables are implicitly or explicitly public static and final.
 * - All methods are implicitly or explicitly public and abstract.
 * - Methods must don't have a body.
 * - Methods must not be static.
 */

/**
 * To check:
 * - Where an interface can be declared?
 * - What is the default value for variables declared in an interface?
 */
public class TestInterfaceDeclaration {
    interface ClassLocalInterface {}
    
    public void m1() {
//        interface MethodLocalInterface {} //compile error: invalid declaration
    }
}

strictfp interface Interface extends Runnable {
    int a = 5;
    void m1();
    public static final int b = 6;
    public abstract void m2();
    
    interface Interface2 {}
}