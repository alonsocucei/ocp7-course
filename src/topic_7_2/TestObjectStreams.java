package topic_7_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * - ObjectOutputStream and ObjectInputStream classes are used to write/read objects
 * to files.
 * - The prerequisite to write an Object is to implement Serializable interface.
 * - Serializable is a marker interface.
 * - static and transient variables are ignored when writing an Object.
 * - NoSerializable and ClassNotFoundException can be thrown.
 */
public class TestObjectStreams {
    public static void main(String[] args) {
        try(
            FileOutputStream fos = new FileOutputStream("test");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream("test");
            ObjectInputStream ois = new ObjectInputStream(fis)) { 
            
            Object o = new Object(15);
            System.out.println(o);
            oos.writeObject(o);
            Object o2 = (Object) ois.readObject();
            System.out.println(o2);
            System.out.println(o2.counter);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Object implements Serializable {
    private transient int data;
    private java.lang.Object o;
    static int counter = 0;
    
    public Object(int data) {
        this.data = data;
        ++counter;
    }
    
    public int getData(){
        return data;
    }
    
    public String toString() {
        return "data: " + data + " o: " + o;
    }
}

/**
 * To check:
 * - What's the result after compiling and running the program?
 * - What happens if transient or static modifier is added to fields?
 * - How can be restored the original type of a variable after reading it?
 * - What happens if the Object variable is initialized?
 * - What happens if a field is initialized using an anonymous class?
 * - How must anonymous classes be used in order to make the code works?
 * - Why static variable prints its value?
 */