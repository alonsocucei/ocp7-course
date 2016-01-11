package topic_2_2;

/**
 *
 * @author alonsocucei
 */
public class TestAbstractClasses {

}

interface Interfaz {
    //public and abstract modifiers are added implicitly if not specified.
    void interfaceMethod1();
    //public, static and final modifiers are added implicitly if not specified.
    int constante = 5;
}

abstract class AbstractClass implements Interfaz {
    public abstract void abstractMethod1();
    public void concretMethod1(){}
}

abstract class AbstractSubclass extends AbstractClass {
//As this is abstract, it's not forced to implement abstract methods.
    public abstract void abstractMethod2();
    public void interfaceMethod1() {}
}

//The first concrete class must implement all abstract methods in the hierarchy.
//The abstract methods may come from an abstract class or an interface.
class ConcreteClass extends AbstractSubclass {
    public void abstractMethod1() {}
    public void abstractMethod2() {}
    //it's optional to implement this method, as it's already implemented in the super class
    public void interfaceMethod1() {} //this is overriding the method in the super class
}

//An abstract class can have only concrete methods?
//Answer: Yes

//An abstract method can be declared in a concrete class?
//Answer: No

//Who must implement all abstract methods?
//Answer: The first concrete class that extends other abstract classes.

abstract class AbstractSubclass2 extends AbstractClass implements Interfaz {
   //compile error: it must return the same type as declared in the interface as the name is the same in both
//    public abstract int interfaceMethod1();
    
    //when an interface and an abstract class share a method with same name, 
    //if the number, type and order of parameters is the same, return type must be the same to avoid conflicting.
    public abstract void interfaceMethod1();
}