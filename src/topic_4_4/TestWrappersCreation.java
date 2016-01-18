package topic_4_4;

/**
 * - There are 3 ways of creating Wrapper classes: assignment (autoboxing), constructors and static methods.
 */
public class TestWrappersCreation {
    public static void main(String[] args) {
        //Assginment
        Boolean ba = false;
        Integer ia = 3;
        Character ca = 'd';
        
        //Constructors
        Character cc = new Character('c');
//        Character cc2 = new Character("c");
        Boolean bc = new Boolean(true);
        Boolean bc2 = new Boolean("TrUe");
        Boolean bc3 = new Boolean(null);
        Integer ic = new Integer(5);
        Integer ic2 = new Integer("5");
        Integer ic3 = new Integer(null);
        
        //Static methods
        Character cs = Character.valueOf('c');
//        Character cs2 = Character.valueOf("d");
        Boolean bs = Boolean.valueOf("TruE");
        Boolean bs2 = Boolean.valueOf(null);
        Boolean bs3 = Boolean.valueOf(true);
        Integer is = Integer.valueOf("a");
        Integer is2 = Integer.valueOf("a", 16);
        Integer is3 = Integer.valueOf(16);
        Integer is4 = Integer.valueOf(null);
    }
}

/**
 * To check:
 * - What is the value of every wrapper variable?
 */