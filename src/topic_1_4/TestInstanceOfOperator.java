package topic_1_4;

/**
 * This class tests the different scenarios when working with instanceof operator.
 * 
 * @author alonsocucei
 */

class Panel {}

class Window extends Panel {}

class InternalWindow extends Window implements Closeable {}

interface Closeable {}

class Door implements Closeable {}

public class TestInstanceOfOperator {
    public static void main(String[] args) {
        Panel panel = new Panel();
        Panel panel2 = new Window();
        Window window = new InternalWindow();
        Door door = new Door();

        //assigning a subtype to a parent type it's ok no casting is needed
        //the rule is classes must be in line in class hierarchy
        panel = window;
        
        //assigning a supertype to a subtype WON'T compile
//        window = panel; //compile error: incompatible types
        
        //assigning a supertype to a subtype needs casting
        //the rule for casting is classes must be in line in class hierarchy
        window = (Window) panel2; //panel2 is actually a Window, this is Ok!
        
        //panel is actually a Panel object not a Window
//        window = (Window) panel; //runtime error: ClassCastException
        
        //casting is allowed only for classes in the same hierarchy line.
//        panel = (Panel) door; //compile error: incompatible types
        
        Closeable closeable;
        closeable = new InternalWindow();
        closeable = new Door();
        
//        closeable = (Closeable) new Window(); //runtime error: ClassCastException
        //instanceof cases:
        //1.- it's in the same hierarchy line (interface)
        boolean case1 = closeable instanceof InternalWindow;
        System.out.println("closeable instanceof InternalWindow: " + case1);
        boolean case1_2 = closeable instanceof Door;
        System.out.println("closeable instanceof Door: " + case1_2);
        
        //2.- it's in the same hierarchy line (class)
        boolean case2 = window instanceof InternalWindow;
        System.out.println("window instanceof InternalWindow: " + case2);
        boolean case2_2 = window instanceof Closeable;
        System.out.println("window instanceof Closeable: " + case2_2);
        
        //3.- null instanceof <valid_class_or_interface> always is false
        boolean case3 = null instanceof InternalWindow;
        System.out.println("null instanceof InternalWindow: " + case3);
        boolean case3_2 = null instanceof Closeable;
        System.out.println("null instanceof Closeable: " + case3_2);
        
        //4.- compile error: not a valid type
//        boolean case4 = window instanceof null;
        
        //5.- compile error: incompatible types
//        boolean case5 = window instanceof Door;
        
        //it doesn't make sense to do this, but it compiles.
        Panel p = (Window) new InternalWindow();
    }
}