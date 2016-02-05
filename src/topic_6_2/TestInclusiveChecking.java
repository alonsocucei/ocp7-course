package topic_6_2;

import java.io.IOException;
import java.sql.SQLException;

/**
 * - Inclusive type checking was added in Java SE 7.
 * - It allows you to know the original type of the exception even when it was
 * thrown as a super type.
 */
public class TestInclusiveChecking {

    public static void main(String[] args) {
        try {
            inclusiveExceptionThrown();
        } catch (IOException | SQLException e) {
            System.err.println(e.getClass());
        }
    }

    public static void inclusiveExceptionThrown() throws IOException, SQLException {
        boolean condition = Math.random() > 0.5;

        try {
            if (condition) {
                throw new IOException();
            } else {
                throw new SQLException();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

/**
 * To check:
 * - Change source version to be 6, what happens?
 * - What happens if the e variable is replaced for a new Exception?
 * - What happens if you try to assign a different value for the variable catch
 * block using the new multi catch approach?
 */