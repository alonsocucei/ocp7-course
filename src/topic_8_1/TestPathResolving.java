package topic_8_1;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - resolve() method tells you how to mix one path within another.
 */
public class TestPathResolving {
    public static void main(String[] args) {
        Path absolute = Paths.get("C:\\Program Files");
        Path absolute2 = Paths.get("C:\\Users");
        Path relative = Paths.get("Java");
        Path file = Paths.get("javac.exe");
//        Path file = Paths.get("javac.exe:"); //InvalidPathException char ':'
        
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", absolute, relative, absolute.resolve(relative));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", absolute, file, absolute.resolve(file));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", relative, file, relative.resolve(file));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", absolute, absolute2, absolute.resolve(absolute2));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", relative, absolute, relative.resolve(absolute));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", file, absolute, file.resolve(absolute));
        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", file, relative, file.resolve(relative));
        System.out.printf("\"%s\".resolveSibling(\"%s\"): %s\n", absolute, relative, absolute.resolveSibling(relative));
        System.out.printf("\"%s\".resolveSibling(\"%s\"): %s\n", absolute.getParent(), relative, absolute.getParent().resolve(relative));

        //If not casting is added is a compile error.
        //Sending null with casting gives as result a NullPointerException
//        System.out.printf("\"%s\".resolve(\"%s\"): %s\n", file, null, file.resolve(null));
    }
}

/**
 * To check:
 * - What the program will print?
 * - What happens when resolving an absolute path against another absolute path?
 * - What happens when sending null to resolve method?
 * - How resolveSibling() method works?
 */