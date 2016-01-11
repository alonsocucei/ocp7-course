package topic_2_4;

/**
 *
 * @author jjsanche
 */
public class TestAllInnerClassesTypes {
    public static void main(String[] args) {
        B b = new B();
        b.method();
    }
}

class A {
    public String toString() {
        return "Top level class";
    }
}

class B {
    
    class A {
        public String toString() {
            return "Inner class";
        }
    }
    
    public void method() {
        A a = new A();
        System.out.println(a);
        
        class A {
            public String toString() {
                return "Method local inner class";
            }
        }
        
        A a2 = new A();
        System.out.println(a2);
    }
}
/**
 * Write an inner class, method-local inner class and top class with same name
 * and create an instance of it in different parts of the code.
 */