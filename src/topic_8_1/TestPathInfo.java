package topic_8_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - Path interface contains useful methods to retrieve information:
 * getFileName(), getName(), getNameCount(), getParent(), getRoot(), subpath(),
 * toString().
 * 
 */
public class TestPathInfo {
    public static void main(String[] args) {
        Path infoPath = Paths.get("C:/Program Files/Java/jdk1.8.0_72/otro");
        Path infoPath2 = Paths.get("nbproject");
        int index = 1;
        
        System.out.printf("toString(): %s\n", infoPath.toString());
        System.out.printf("getFileName(): %s\n", infoPath.getFileName());
        System.out.printf("getName(%d): %s\n", index, infoPath.getName(index));
        System.out.printf("getNameCount(): %s\n", infoPath.getNameCount());
        System.out.printf("getParent(): %s\n", infoPath.getParent());
        System.out.printf("getRoot(): %s\n", infoPath.getRoot());
        System.out.printf("subpath(%d, %d): %s\n", index, 4, infoPath.subpath(index, 4));
        
        System.out.println(infoPath2.toAbsolutePath());
        
        try {
            System.out.println(infoPath2.toRealPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (Path name: infoPath) {
            System.out.println(name);
        }
        
        Path infoPath3 = Paths.get("C:\\");
        System.out.println(infoPath3.getParent());
        System.out.println(infoPath3.getNameCount());
        System.out.println(infoPath3.getFileName());
        System.out.println(infoPath3.getRoot());
//        System.out.println(infoPath3.subpath(0, 1)); //IllegalArgumentException
    }
}

/**
 * To check:
 * - What indexes are valid for getName() method?
 * - What indexes as valid for subpath() method?
 * - How a Path can be iterated to print all its names?
 * - What returns getParent() method if Path is equals to root?
 * - What's the difference between toRealPath() and toAbsolutePath() methods?
 */