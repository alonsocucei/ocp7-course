package topic_2_3;

/**
 *
 * @author alonsocucei
 */
public abstract class TestFinalKeyword {
    private final int instanceConstant = getStaticValue();
    private final int instanceConstant2 = getInstanceValue();
    private final int instanceConstant3;
    
    //it doesn't matter this class is abstract, final variables must be initialized
    //in the class where are declared.
//    protected final int instanceConstant4;
    
    public TestFinalKeyword() {
        if (Math.random() > 0.8) {
            instanceConstant3 = 10;
        } else if (Math.random() > 0.5) {
            instanceConstant3 = 5;
        } else {
            instanceConstant3 = 0;
        }
    }
    
    public TestFinalKeyword(String a) {
        this(5);
    }
    
    public TestFinalKeyword(int a) {
        instanceConstant3 = 3;
    }
    
    public static int getStaticValue() {
        return 1;
    }
    
    public int getInstanceValue() {
        return 2;
    }
}

class FinalKeywordSubclass extends TestFinalKeyword {
    
    public FinalKeywordSubclass() {
        //this final variable must be intialized in the class where it was declared.
//        super.instanceConstant4 = 4;
    }
}

//abstract and final comparsion

//final instance variables, where they must be initialized?

//try to override a private final method in a super class