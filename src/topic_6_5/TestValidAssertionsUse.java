package topic_6_5;

/**
 * - DON'T use assertions to validate arguments of a public method. - DO user
 * assertions to validate arguments of a private method. - DO use assertions to
 * validate invariant conditions (internal, control-flow or class). 
 * - DON'T use assertions that may cause side effects.
 */
public class TestValidAssertionsUse {

    //DO
    private void privateMethod(int month) {
        assert month > 0 && month <= 12;
    }

    //DON'T
    public void publicMethod(int month) {
        assert month > 0 && month <= 12;
    }

    //internal invariants
    enum State {
        ON, OFF
    }

    public void internalInvariants(State state) {
        switch (state) {
            case ON:
                break;
            case OFF:
                break;
            default:
                assert false: "It should never get here";
        }
    }
    
    //control-flow invariants
    public void controlFlowInvariants(int limit) {
        for (int i = 0; i < limit; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is a factor of 2");
                return;
            }
        }
        
        assert false : "Shouldn't get here";
    }
}

//class invariants
class Tree {
    public boolean sort() {
        return true;
    }
    
    public Object[] getLeafs() {
        assert sort();
        //code to get the leafs.
        return null;
    }
}

/**
 * To check:
 * - What would be an example of using asserts that cause a side effect?
 */