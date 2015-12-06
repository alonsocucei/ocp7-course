package topic_1_2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This file helps explaining overriding.
 * To override a method there must be an inheritance relationship between classes.
 * 
 * Overrides means to write again a method in a subclass, the signature must be
 * the same, if it isn't then it's considered overloading.
 * 
 * @author alonsocucei
 */
public class TestOverriding {
    public static void main(String[] args) {
        Super s = new Super();
        Number n_ = s.methodB();

        s = new SubClass();
        Number n = s.methodB();
        
        
        try {
            s.methodA();
            ((SubClass) s).methodA();
        } catch (Exception e) {
        }
    }
}

class Super {
    //private methods can't be overriden, as they are not accessible to subclasses
    private void methodP() {
        System.out.println("Super");
    }
    
    //subclasses can't throw more general checked exceptions than IOException 
    //or different checked exceptions that are not subclasses of IOException
    public void methodA() throws IOException {
    }
    
    //when subclasses override this method, the return type may be the same or
    //a covariant type, which means it can be a subtype of Number class.
    public Number methodB() {
        return null;
    }
}

class SubClass extends Super {
    public void methodP() {
//        super.methodP();//compile error: not accesible from Super
        System.out.println("SubClass");
    }
    
    //it's valid to throw 2 different checked excptions as its parent class
    //throws one supertype of both.
    @Override
    public void methodA() throws FileNotFoundException, EOFException {
    }
    
    @Override
    public Integer methodB() {
        super.methodB(); //calling method in parent class
        return null;
    }
}