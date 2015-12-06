package topic_1_5;

/**
 * This class describes the virtual method invocation or polymorphism.
 * These concepts require a relationship of inheritance between at least 2 classes.
 * 
 * Exam will ask your knowledge about what is checked in compiling time and runtime.
 * Compiler will check against reference declarations (left side of the assignment).
 * Runtime will check agains the actual object of the reference (right side of the assignment).
 * 
 * @author alonsocucei
 */
public class TestVirtualMethodInvocation {
    public static void main(String[] args) {
        SuperClase sc = new SuperClase();
        sc.a(); //uses SuperClase method
        sc = new SubClase();
        sc.a(); //uses SubClase method
        ((SuperClase)sc).a(); //uses SubClase method
    }
}

class SuperClase {
    public void a() {
        System.out.println("SuperClase");
    }
}

class SubClase extends SuperClase {
    @Override
    public void a() {
        System.out.println("SubClase");
    }
}