package topic_1_7;

//java.lang package is always available, if not added explicitly for us, the 
//compiler will do it.
//import java.lang.*;

//Valid syntax for import statements:
//import static package.<class_name>
//import static package.*

//Import setences correct place is after package sentence and before any class
//declaration.
//import java.util.*;
import java.util.regex.*;
//When repeated import sentences are found, compiler just sends a warning.
//import java.util.ArrayList;
import java.util.ArrayList;

//Compile error: 2 or more classes have the same single name
//import java.sql.Date;
import java.util.Date;
import java.sql.*;

/**
 * This file tests different situations regarding import statements.
 * 
 * @author alonsocucei
 */
public class TestImports {
    public static void main(String[] args) {
        System.out.println("Hola imports!");
        ArrayList array;
        Matcher matcher;
        Date d = new Date();
        System.out.println(d.getClass().getName());
        //When there are 2 classes with same single name, the solution is to
        //refer to one of them using its complete name.
        java.sql.Date d2 = new java.sql.Date(d.getTime());
        System.out.println(d2.getClass().getName());
    }
}
