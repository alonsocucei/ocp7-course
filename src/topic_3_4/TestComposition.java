package topic_3_4;

/**
 * - Composition refers to having one object as instance variable.
 * - Composition makes reuse of classes easier.
 * - Composition is another solution to simulate multiple inheritance
 */

/**
 * To check:
 * - How would you modify the classes below to have BoatCar inheriting from Boat
 * and Car classes?
 * - How would you simulate a program menu?
 */
public class TestComposition {

}

class Car {
    public void drive() {
        System.out.println("Driving the car");
    }
}

class Boat {
    public void seal() {
        System.out.println("Sealing the boat");
    }
}

class BoatCar {
    private Car car = new Car();
    private Boat boat = new Boat();
    
    public void drive() {
        car.drive();
    }
    
    public void seal() {
        boat.seal();
    }
}

class Menu {
    private String name;
    private Menu[] subMenus;
    
    
}