package topic_4_1;

/**
 * - Generics is just a syntax, which is removed on runtime.
 * They add type safety on compile time.
 * - Generics allows you to restrict the data types.
 * - Generics are known as templates in C++.
 */
public class TestGenericClass {
    public static void main(String[] args) {
        TrashCan<String, String> tc = new TrashCan<String, String>();
        TrashCan<Number, String> tcn = new TrashCan<Number, String>();
        TrashCan tcno = new TrashCan();
        
        tc.trash("");
        tcn.trash(5); //Integer
        tcno.trash("");
        String s = tc.getTrash();
        Number n = tcn.getTrash();
    }
}

/**
 * To check:
 * - How can we create a single class instead of the two below and functionality
 * continues the same?
 */
class TrashCanString {
    public void trash(String s){
        s = null;
    }
}

class TrashCanNumber {
    public void trash(Number n){
        n = null;
    }
}

class TrashCan <T, U> {
    private T trash;
    
    public void trash(T o) {
        o = null;
    }
    
    public T getTrash() {
        return trash;
    }
}