package topic_1_6;

/**
 * This class shows the correct way on how to override the methods in Object class.
 * For more info check the API. Go to java.lang package, then click on Object class
 * and read about the three methods: equals, toString and hashCode.
 * 
 * @author alonsocucei
 */
public class TestOverrideObjectMethods {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(5, 3);
        MyClass myClass2 = new MyClass(5, 3);
        
        System.out.println(myClass); //calls toString method in MyClass class
        System.out.println("hash code: " + myClass.hashCode());
        
        System.out.println("myClass.equals(myClass2): " + myClass.equals(myClass2));
        
        //Watch out! Not all classes implement equals, example: StringBuilder and StringBuffer
        StringBuilder a = new StringBuilder("hola");
        StringBuilder b = new StringBuilder("hola");
        System.out.println("a.equals(b): " + a.equals(b));
        
        //This is how it works by default the toString method in Object class:
        System.out.print(myClass.getClass().getName());
        System.out.print('@');
        System.out.println(Integer.toHexString(myClass.hashCode()));
        
        
    }
}

class MyClass {
    private int x = 100;
    private int y = 50;
    private String s;
    
    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
        this.s = String.valueOf(x + y);
    }
    
    /**
     * A good toString method will returns a String representing the state of
     * the object at the moment of the call.
     */
    public String toString() {
        return "x: " + x + ", y: " + y + ", s: " + s;
    }
    
    /**
     * A good hashCode method will return an int value which difficulty will be
     * repeated by other instances of the same class.
     */
    public int hashCode() {
        return x << y + s.hashCode();
    }
    
    /**
     * A good equals method implementation always checks first the type of the 
     * object to compare, it must be the same than the current class.
     * Moreover it will compare the variables used to determine the state of the object,
     * if one of those variables is a reference type it will use the equals method.
     */
    public boolean equals(Object o) {
        if (o instanceof MyClass) {
            MyClass temp = (MyClass) o;
            return x == temp.x && y == temp.y && s.equals(temp.s);
        }
        
        return false;
    }
}
