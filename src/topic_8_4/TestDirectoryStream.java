package topic_8_4;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - DirectoryStream interface allows to list all files and directories for a Path object.
 * - To get a DirectoryStream use newDirectoryStream() method from Files class.
 */
public class TestDirectoryStream {
    public static void main(String[] args) {
        Path root = Paths.get("C:\\");
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root);){
            for (Path path: stream) {
                System.out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //filtering - option #1
//        System.out.println("Filtering, option #1:");
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root, "");){
//            for (Path path: stream) {
//                System.out.println(path);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        //filtering - option #2
//        System.out.println("Filtering, option #2:");
//        DirectoryStream.Filter<Path> filter = ...
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root,filter)){
//            for (Path path: stream) {
//                System.out.println(path);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        
    }
}

/**
 * To check:
 * - What happens if path is a valid/invalid file?
 * - How can we filter entries to just those starting with R|S?
 * - How can the same filter be applied using the DirectoryStream.Filter interface?
 */