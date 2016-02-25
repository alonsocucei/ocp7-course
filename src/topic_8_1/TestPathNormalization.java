package topic_8_1;

import java.nio.file.Paths;

/**
 * - normalize() method is used to remove redundancies.
 */
public class TestPathNormalization {
    public static void main(String[] args) {
        System.out.println(Paths.get("a/./b/./c").normalize());
        System.out.println(Paths.get(".path").normalize());
        System.out.println(Paths.get("./path").normalize());
        System.out.println(Paths.get("/a/b/c/..").normalize());
        System.out.println(Paths.get("../a/b/c").normalize());
        System.out.println(Paths.get("d/e/../a/b/c").normalize());
        System.out.println(Paths.get("C:\\../a/b/c").normalize());
        System.out.println(Paths.get("C:\\a/b/c/../../../../../..").normalize());
    }
}

/**
 * To check:
 * - What the program will print?
 */