package topic_8_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * - BasicFileAttributes interface provide methods to get information about a file
 * or directory.
 * - To gain access to this attributes Files.readAttributes() method must be used.
 * - To write values to attributes use the BasicFileAttributeView interface
 * - To gain access to the view use Files.getFileAttributeView() method.
 */
public class TestBasicAttributes {
    public static void main(String[] args) {
        Path basePath = Paths.get("C:\\Users\\jjsanche\\Desktop");
        Path filePath = basePath.resolve(Paths.get("Curso Java.pptx"));
        
        BasicFileAttributes basicAttributes;
        //reading attributes
        try {
            basicAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.printf("is regular file: %s\n", basicAttributes.isRegularFile());
            System.out.printf("creation time: %s\n", basicAttributes.creationTime());
            System.out.printf("last accessed time: %s\n", basicAttributes.lastAccessTime());
            System.out.printf("last modified time: %s\n", basicAttributes.lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("After writing:");
        //writing attributes
        BasicFileAttributeView basicView = Files.getFileAttributeView(filePath, BasicFileAttributeView.class);
        try {
            Date now = new Date();
            basicView.setTimes(null, FileTime.fromMillis(now.getTime()), null);
            System.out.printf("creation time: %s\n", basicView.readAttributes().creationTime());
            System.out.printf("last accessed time: %s\n", basicView.readAttributes().lastAccessTime());
            System.out.printf("last modified time: %s\n", basicView.readAttributes().lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What other methods from BasicFileAttributes interface return a boolean?
 * - What happens if setTimes() method receives 3 null arguments?
 */