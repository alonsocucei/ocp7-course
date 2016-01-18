package topic_4_1;

/**
 * - Generics can be used in parameters whether they are in a generic class or not.
 * - Generic types must be places before return type in case the return type is
 * of a generic type.
 */
public class TestGenericParameters {
    public static void main(String[] args) {
        GenericParametersGenericClass<String> gpgc = new GenericParametersGenericClass<>();
        gpgc.setT("hola");
        gpgc.m1(5);
//        String a = gpgc.m1(5);
        gpgc.m1(5);
    }
}

/**
 * To check:
 * - What happens when class and methods share generic types like the code below?
 * @author jjsanche
 */
class GenericParametersNormalClass {
    public static <T,Q> void m1(T t) {
        Q q;
        System.out.println(t.toString());
    }
}

class GenericParametersGenericClass<T> {
    private T t;
    public void setT(T t) {
        this.t = t;
    }
    
    public <T,Q> T m1(T t) {
        Q q;
        System.out.println(t.toString());
        return t;
    }
}