package topic_6_2;

import java.io.IOException;
import java.sql.SQLException;

/**
 * - Before Java SE 7, multi catching was done by writing as many catch blocks
 * as needed.
 * - For Java SE 7 multi catching can be done using just one catch block.
 */
public class TestMultiCatch {
    public static void main(String[] args) {
        //old approach
        try {
            throwerMethod();
        } catch (IOException e) {
        } catch (SQLException e) {
        }catch (Exception e) {
        }
        
        //new approach
        try {
            throwerMethod();
        } catch (SQLException | IOException  e) {
        }
    }
    
    public static void throwerMethod() throws IOException, SQLException {}
}

/**
 * To check:
 * - What's the difference between the two?
 * - When is preferred the old approach?
 * - What happens when trying to catch an Exception that may not be thrown?
 */