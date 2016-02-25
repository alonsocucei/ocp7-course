package topic_7_2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * - Reader important methods: read(), read(char[]), read(char[], int, int).
 * - Writer important methods: write(char), write(int), write(String), write(String, int, int),
 *   write(char[]), write(char[], int, int).
 * - Writer classes add constructors with boolean parameters to indicate append to
 *   the file.
 * - flush() method is used to send data in cache to file (this method is in OutputStream
 * and Writer classes)
 */
public class TestFileReaderWriter {
    public static void main(String[] args) {
        String userHome = System.getProperties().getProperty("user.home");
        
        try(FileReader reader = new FileReader(userHome + "\\Desktop\\test.txt");
                FileWriter writer = new FileWriter(userHome + "\\Desktop\\copy-test.txt")) {
            char[] buffer = new char[10];
            int charsRead = 0;
            
            while( (charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }
            
            System.out.println("File copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - Write the code to copy a file using FileReader and FileWriter classes.
 */