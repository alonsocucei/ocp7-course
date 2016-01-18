package topic_4_1;

/**
 * - Generics can use any valid identifier as type.
 * Even class names, which may be confusing.
 * - It's recommended to use a Single uppercase letter for types when using generics.
 * 
 */
public class TestGenericTypeNames {
    public static void main(String[] args) {
//        Trash<String> t = new Trash<>();
//        t.set("hola");
//        System.out.println(t.get().length());
    }
}

/**
 * To check:
 * - Will the code in mail compile?
 */
class MyClass {}
class Trash <MyClass> {
    private MyClass t;
    
    public void set(MyClass t) {
        this.t = t;
    }    
    
    public MyClass get() {
        return t;
    }    
}