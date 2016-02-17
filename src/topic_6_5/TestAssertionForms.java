package topic_6_5;

/**
 * - Assertions help to test code.
 * - They do assumptions about conditions in your code.
 * - You must not to try recover from an Assertion.
 */
public class TestAssertionForms {
    public static void main(String[] args) {
        int dividend = -10;
        int divider = 3;
        //simple form: assert <boolean_expression>
        assert dividend % divider == -1;
        
        //textual form: assert <boolean_expression> : <textual_expression>
        assert dividend % divider == 1 : dividend + " module " + divider + " is not 1";
    }
}

/**
 * To check:
 * - What expressions are valid for the textual form?
 */