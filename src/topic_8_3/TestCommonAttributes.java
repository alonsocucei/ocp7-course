package topic_8_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - Files class contains methods to read and try to set file attributes.
 * - Some of them may throw an IOException and some not.
 */
public class TestCommonAttributes {
    public static void main(String[] args) {
        Path javaHome = Paths.get("C:\\Program Files\\Java\\jdk1.8.0_72");
        Path compiler = javaHome.resolve(Paths.get("bin\\javac.exe"));
        
        System.out.printf("can read: %b\n", Files.isReadable(compiler));
        System.out.printf("can write: %b\n", Files.isWritable(compiler));
        System.out.printf("can execute: %b\n", Files.isExecutable(compiler));
        
        try {
            System.out.printf("is hiden: %b\n", Files.isHidden(compiler));
            System.out.printf("owner: %s\n", Files.getOwner(compiler));
            System.out.printf("last modified: %s\n", Files.getLastModifiedTime(compiler));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

/**
 * To check:
 * - What other methods of Files class return a boolean?
 * - What attributes have a setter method?
 */