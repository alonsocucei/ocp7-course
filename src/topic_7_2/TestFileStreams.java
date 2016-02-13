package topic_7_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * - Important OutputStream methods: close(), flush(), write(byte[]), write(byte[], int, int), write(int).
 * - Important InputStream methods: close(), read(), read(byte[]), read(byte[], int, int).
 * - Copy a file indicated to a path, source and destiny are taken from command line args.
 * - Constructors throw FileNotFoundException.
 * - Methods throw IOException.
 */
public class TestFileStreams {
    public static void main(String[] args) {
        if (args.length >= 2) {
            String source = args[0];
            String destiny = args[1];
            
            try(FileInputStream input = new FileInputStream(source);
                FileOutputStream output = new FileOutputStream(destiny)) {
                
                int bytesCounter;
                byte [] bytesRead = new byte[200];
                while ((bytesCounter = input.read(bytesRead, 0, bytesRead.length)) != -1) {
                    output.write(bytesRead, 0, bytesCounter);
                }
                System.out.printf("File %s was copied successfully to: %s", source, destiny);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}