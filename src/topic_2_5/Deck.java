package topic_2_5;

/**
 *
 * @author jjsanche
 */
//An enum can implement n number of interfaces
public enum Deck implements Runnable {
    DIAMANTES, CORAZONES("Corazon ROJO"), TREBOLES, ESPADAS;
    
    private String imagen;
    
    //when no access modifier is specified, private is added by the compiler
    Deck(String imagen) {
        this.imagen = imagen;
    }
    
    private Deck() {
    
    }
    
    public String toString() {
        return name() + " imagen: " + imagen;
    }
    
    //compile error: name is final in class Enum
//    public String name() {
//        return name().toLowerCase();
//    }
    
    //compile error: this method is defined by the compiler, its declaration is not necessary.
//    public Deck[] values() {
//    }
    
    
    
    public void run() {
    }
    
    public static void main(String... a) {
        for (Deck d: Deck.values()) {
            System.out.println(d);
            System.out.println(d.imagen);
        }
        
        Deck d = Deck.valueOf("DIAMANTES");
        System.out.println(d);
        System.out.println(d == Deck.DIAMANTES);
        System.out.println(d.equals(Deck.DIAMANTES));
        Deck d2 = Deck.valueOf(Deck.class, "CORAZONES");
        System.out.println(d2);
    }
}

//enum cannot extends anothe enum or class
//enum SubDec extends Deck {}
//enum SubDec extends Object {}