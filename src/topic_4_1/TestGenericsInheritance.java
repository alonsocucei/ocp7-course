package topic_4_1;

/**
 * - A generic class can extend another generic class.
 * - A non generic class can extend a generic class.
 * - A generic class can extend a normal class.
 */
public class TestGenericsInheritance {
    public static void main(String[] args) {
//        GenericClass gc = new GenericClass();
//        GenericClass<String> gcs = new GenericClass();
//        GenericClass gcrd = new GenericClass<String>();
//        GenericClass<String> gcd = new GenericClass<>();

//        NormalClass nc = new NormalClass();
//        NormalClass<String> ncs = new NormalClass();
//        NormalClass ncrd = new NormalClass<String>();
//        NormalClass<String> ncd = new NormalClass<>();
    }
}

/**
 * To check:
 * - What of the statements below will compile correctly?
 * - What of the statements in main will compile correctly?
 */
class GenericClass<T> {}

class NormalClass{}
//class NoGenericClass extends GenericClass{}
//class NoGenericClass extends GenericClass<T>{} //compile error: cannot find symbol T
//class NewGenericClass<T> extends NormalClass{}
//class NewGenericClass<T> extends NormalClass<T>{} //compile error: NormalClass doesn't define Generic types
//class MyGenericClass<F> extends GenericClass<T>{} //compile error: cannot find symbol T
//class MyTwoGenericClass<F, T> extends GenericClass<T>{}