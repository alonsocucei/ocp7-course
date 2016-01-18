package topic_4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * - Bounded types allows you to invoke methods from a base class type.
 * 
 */
public class TestBoundedTypeParameters {
    public static void main(String[] args) {
//        GenericBoundedTypeParameters<Integer> gbtpi = new GenericBoundedTypeParameters<>();
//        GenericBoundedTypeParameters<Float> gbtpf = new GenericBoundedTypeParameters<>();
//        gbtpi.m1(Integer.SIZE);
//        gbtpf.m1(Float.MIN_NORMAL);
    }
}

/**
 * To check:
 * - Will the code in main compile?
 */
class GenericBoundedTypeParameters<T extends Number> {
    private T t;
    public void setT(T t) {
        this.t = t;
    }
    
    public void m1(T t) {
        System.out.println(t.doubleValue());
    }
}