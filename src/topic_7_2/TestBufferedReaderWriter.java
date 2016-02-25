package topic_7_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * - BufferedReader and BufferedWriter classes are used to read/write text files
 * line by line.
 * - To read use: readLine().
 * - To write use: write(String), write(int), write(char[]), write(char[], int, int) and newLine().
 * - Constructors may specify the buffer size.
 * - Constructors parameters are Reader/Writer objects.
 */
public class TestBufferedReaderWriter {
    public static void main(String[] args) {
        String userHome = System.getProperties().getProperty("user.home");
        
        try(FileReader reader = new FileReader(userHome + "\\Desktop\\test.txt");
                BufferedReader bReader = new BufferedReader(reader);
                FileWriter writer = new FileWriter(userHome + "\\Desktop\\copy-test.txt");
                BufferedWriter bWriter = new BufferedWriter(writer)) {
            
            String line = null;
            while((line = bReader.readLine()) != null) {
                bWriter.write(line);
                bWriter.newLine();
            }
            
            System.out.println("File copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - Copy a text file, this time using Buffered classes.
 */