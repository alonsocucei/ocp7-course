package topic_3_1;

/**
 * - Interfaces can extend any number of interfaces
 */

/**
 * To check:
 * - A class implements an interface. The interface extends from other 2 interfaces. What happens?
 */
public class TestInterfaceInheritance implements Three {
    public void methodOne(){}
    public void methodTwo(){}
}

interface One {
    void methodOne();
}

interface Two extends One{
    void methodTwo();
}

interface Three extends Two{
    void methodTwo();
}