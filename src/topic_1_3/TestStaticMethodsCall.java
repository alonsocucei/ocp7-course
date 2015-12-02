package topic_1_3;

/**
 * Dependencies:
 *      TestStaticMethods.java
 * 
 * Here we can see what happens when using static import for classes involved
 * in a inheritance relationship.
 * 
 * Trying to import static methods on a super class and its subclass will result
 * in just using the subclass methods (event when method is overloaded)
 * as can be seen in the call to hello() method.
 * 
 * Overloading static methods in classes with no relationship at all will produce
 * a compile error as the compiler doesn't know which method to call, whether the
 * one in class C or D.
 * 
 * @author alonsocucei
 */

import static topic_1_3.A.*; //looks like next static import sentence import superclass' members too!
import static topic_1_3.B.*;
import static topic_1_3.C.*;
import static topic_1_3.D.*;

public class TestStaticMethodsCall {
    public static void main(String[] args) {
        //it will use method in class B
        hello();
        //to use method in class A, reference must be type explicitly before method name.
        A.hello();
   
        //compile error: reference is ambiguous
        //this is because method is declared in both classes C and D
//        hi();
    }
}
