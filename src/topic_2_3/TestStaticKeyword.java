package topic_2_3;

/**
 *
 * @author alonsocucei
 */

//A static context CAN'T access a instance member.
//An instance context CAN access a static variable or method.

public class TestStaticKeyword {
    private static final int classConstant = 1; //initilize constant in the same declaration line.
    //if the method declares that throws an Exception, this will be a compile error.
    private static final int classConstant2 = getConstantValue(); //intialize constant calling a static method.
    private static final int classConstant3; //initialized from a static initializer.
    private static int instanceCounter;
    private int instanceVariable;
    
    //static declarations and initializers are grouped in only one static block
    //following the order they appear, so, the trickyVariable will end with value 1.
    static {
        trickyVariable = 10;
    }

    private static int trickyVariable = 0;
    
    static {
        trickyVariable ++;
    }
    
    public TestStaticKeyword() {
        instanceCounter++;
    }
    
    //if comments are deleted, code won't compile
    public static int getConstantValue() /*throws Exception*/ {
        return 2;
    }
    
    static {
        classConstant3 = 3;
        System.out.println("algo");
//        System.out.println(instanceVariable); //compile error: can't access instance variable from static context
    }
    
    public static void main(String[] args) {
        int numeroAleatorio = (int) (Math.random() * 1000);
        System.out.println(trickyVariable);
        
        for (int i = 1; i <= numeroAleatorio; i ++) {
            new TestStaticKeyword();
        }
        
        System.out.println("En total los objetos creados fueron: " + instanceCounter);
    }
}