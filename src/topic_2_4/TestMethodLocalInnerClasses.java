package topic_2_4;

/**
 * - Method-Local Inner Classes can just be instantiated inside the method where
 * they are declared.
 * - They can access member variables but not local method variables unless
 * they are final.
 * - Valid modifiers are just abstract and final.
 */
public class TestMethodLocalInnerClasses {
    public static void main(String[] args) {
        RegularClass rc = new RegularClass();
        rc.method();
        rc.lifeGuard();
    }
}

/**
 * To check:
 * - Create instances of the method-local inner class.
 * - What a method-local inner class can access and why.
 * - What happens if the method where method-local inner class is declared is static?
 */

interface LifeGuard {
    void saveMe();
}

class RegularClass {
    private int outerField;
    private Object ref;
    private LifeGuard lifeGuard;
//    private MethodLocalInnerClass ml; //compile error: out of scope
    
    public void lifeGuard() {
//        ref.toString();
        lifeGuard.saveMe();
    }
    
    public void method() {
        int localVariable;
        final int constant = 10;
        
        class MethodLocalInnerClass implements LifeGuard {
            private int methodInnerClassField;
            
            public void saveMe() {
                lifeGuard = this;
                System.out.println("saving myself from garbage collector");
            }
            
            public String toString() {
                ref = this;
                System.out.println(outerField);
                System.out.println(constant);
//                System.out.println(localVariable); //
                return null;
            }
        }
        
        MethodLocalInnerClass mc = new MethodLocalInnerClass();
//        mc.toString();
        mc.saveMe();
    }
}