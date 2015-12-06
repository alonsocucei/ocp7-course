package topic_1_1;

import topic_1_1.newpackage.Subclass;

/**
 * This class tests different scenarios when using the different access modifiers.
 * if a member of a class has as access modifier...
 * 
 * public: member can be accessed from anywhere
 * 
 * protected: member can be accessed from classes in the same package and classes 
 * in different packages that extends the class.
 * The only exception is trying when in the subclass an instance of the parent
 * is created and using a reference to access the protected member, this WON'T compile.
 * 
 * (default): member can be accesses only from classes in the same package
 * 
 * private: member can be accessed only in the class it's declared
 * 
 * @author alonsocucei
 */

public class Padre {
    private int a;
    int b;
    protected int c;
    public int d;
    
    public static void main(String[] args) {
        Padre p = new Padre();
        Hijo h = new Hijo();
        Subclass s = new Subclass();
        
        System.out.println("p.a: " + p.a);
        System.out.println("p.b: " + p.b);
        System.out.println("p.c: " + p.c);
        System.out.println("p.d: " + p.d);
        System.out.println("h.d: " + h.d);
        System.out.println("h.c: " + h.c);
        System.out.println("s.d: " + s.d);
        System.out.println("s.c: " + s.c);
        h.methodX();
        s.methodX();
    }
}

class Hijo extends Padre {
    public void methodX() {
        Padre p = new Padre();
        Hijo h = new Hijo();
//        System.out.println("a: " + a);//compile error: private access
        System.out.println("b: " + b);
        System.out.println("h.b: " + h.b);
        System.out.println("c: " + c);
        System.out.println("h.c: " + h.c);
        System.out.println("p.c: " + p.c);
        System.out.println("d: " + d);
    }
}

//Test direct access to members in the class.

//Test indirect access to members using a reference to an object of the same class.