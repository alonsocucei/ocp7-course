package topic_1_7;

//Valid syntax for static import statements:
//import static package.<class_name>.*
//import static package.<class_name>.field
//import static package.<class_name>.method

import static java.lang.Math.PI;
import static java.lang.Math.E;
import static java.lang.Math.cos;


/**
 * This file show the use of static imports.
 * 
 * @author alonsocucei
 */
public class TestStaticImports {
    public static void main(String[] args) {
        System.out.println("PI: " + PI);
        System.out.println("E: " + E);
        System.out.println("cos(0):" + cos(0));
    }
}
