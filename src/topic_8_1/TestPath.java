package topic_8_1;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - Path is the new Interface in NIO.2 that substitutes File class.
 * - Paths is a static class which works as a factory to create Path objects.
 */
public class TestPath {
    public static void main(String[] args) {
        //Absolute paths
        Path path1 = Paths.get("D:\\temp\\file.txt");
        Path path2 = Paths.get("D:", "temp", "file.txt");
//        Path path3 = Paths.get("D://temp//file.txt");
        
        System.out.printf("%s - %s\n", path1, path2);
//        System.out.printf("%s\n", path3);
        
        //Relative path
        Path relativePath = Paths.get("temp", "file.txt");
        System.out.printf("%s\n", relativePath);
        
        //Using FileSystems and FileSystem classes
        Path longer = FileSystems.getDefault().getPath("C:", "temp", "file.txt");
        System.out.printf("%s\n", longer);
        
        //Convert to a File object
        File f1 = path1.toFile();
        Path cPath = f1.toPath();
        
        //file: protocol
//        Path protocolPath = Paths.get("file:///C:/temp/file");
//        Path protocolPathURI = Paths.get(URI.create("file:///C:\\temp\\file"));
//        Path protocolPathURI = Paths.get(URI.create("file:///C:/temp/file"));
    }
}

/**
 * To check:
 * - What happens if incorrect separators are used for the current OS?
 * - What about file: protocol?
 * - How compatibility works with File objects?
 */