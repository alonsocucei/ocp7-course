package topic_1_1.newpackage;

/**
 * This class inherits from a super class and tests the scenarios for default
 * access level and protected access modifier.
 * 
 * @author alonsocucei
 */
import topic_1_1.*;

public class Subclass extends Padre {
    public void methodX() {
        Subclass s = new Subclass();
        Padre p = new Padre();
//        System.out.println("b: " + b);//compile error: access from diferent package
        System.out.println("c: " + c);
        System.out.println("s.c: " + s.c);
//        System.out.println("p.c: " + p.c);//exceptional case, accessing protected variable indirectly from instance of parent class.
        System.out.println("d: " + d);
    }
}

class Otra {
    public void methodX() {
        Subclass s = new Subclass();
//        System.out.println("s.b: " + s.b);//compile error: access from diferent package
//        System.out.println("s.c: " + s.c);//compile error: access from diferent package and not subclass
        System.out.println("s.d: " + s.d);
    }
}
