package topic_2_1;

/**
 *
 * @author alonsocucei
 */
public class TestClassDesign {

}

abstract class Animal {}
abstract class Mamifero extends Animal {}
abstract class NoMamifero extends Animal {}
class Leon extends Mamifero {}
class Elefante extends Mamifero {}
class Abeja extends NoMamifero {}
class Serpiente extends NoMamifero {}

//If just behavior is the common characteristic between classes, then it's not the best approach, instead use interfaces.
abstract class Ave {
    public abstract void volar() throws Exception;
}

class Aguila extends Ave {
    public void volar() {System.out.println("Volando como aguila");}
}

class Avestruz extends Ave {
    //In case there's a design where not only behavior is common between classes
    //and there's a method which doesn't apply to the class, a good way to
    //implemented is throwing an Exception
    public void volar() throws Exception {
        throw new Exception("Las avestruces no vuelan");
    }
}

interface Volador {
    public void volar();
}

class PezVolador implements Volador {
    public void volar() {
        System.out.println("Volando como pez");
    }
}

class Superman implements Volador {
    public void volar() {
        System.out.println("Volando como superman");
    }
}