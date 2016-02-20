package topic_8_5;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * - PathMatcher interface allows to test a pattern against a Path.
 * - PathMatcher may use glob or regex syntax to match Paths.
 * - To get a PathMatcher use the getPathMatcher() method from FileSystem class.
 * - To get a FileSystem use the getDefault() method from FileSystems class.
 */
public class TestPathMatcher {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\jjsanche\\Desktop\\test.sxt");
        String pattern = "**.[ts]xt";
        String regexPattern = ".*\\.txt";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        PathMatcher regexMatcher = FileSystems.getDefault().getPathMatcher("regex:" + regexPattern);

        System.out.printf("%s matches %s: %b\n", path, pattern, matcher.matches(path));
        System.out.printf("%s matches %s: %b\n", path, regexPattern, regexMatcher.matches(path));
        
        System.out.println("\nTesting patterns:");
        Path testPath = Paths.get("/home/alonsocucei/java/Class.java");
//        Path testPath = Paths.get("\\home\\alonsocucei\\java\\Class.java");
        String pattern1 = "*.java";
        String pattern2 = "**.java";
        String pattern3 = "*/.java";
        String pattern4 = "*/*.java";
        
        System.out.printf("%s matches %s: %b\n", testPath, pattern1, match(testPath, pattern1));
        System.out.printf("%s matches %s: %b\n", testPath, pattern2, match(testPath, pattern2));
        System.out.printf("%s matches %s: %b\n", testPath, pattern3, match(testPath, pattern3));
        System.out.printf("%s matches %s: %b\n", testPath, pattern4, match(testPath, pattern4));
    }
    
    private static boolean match(Path path, String pattern) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        return matcher.matches(path);
    }
    
}

/**
 * To check:
 * - What lines will print true?
 * - What's the difference between using a single * or double ** when using glob syntax?
 * - Using glob syntax what would be the equivalent to . in regex?
 * - Using glob syntax what would be the equivalent to chose between two expressions (|) in regex?
 * - What would be the pattern to list all documents with extension .doc in a Path using a PathMatcher?
 * - What's the syntax to match special chars like: ?, *, [, ], { and }?
 */