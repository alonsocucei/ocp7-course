package topic_8_1;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - relativize() method shows how to go from one path to another.
 */
public class TestPathRelativizing {
    public static void main(String[] args) {
        Path javaHome = Paths.get("C:\\Program Files\\Java");
        Path compilerAbsolute = Paths.get("C:\\Program Files\\Java\\bin\\javac.exe");
        Path user = Paths.get("C:\\users\\jjsanche");
        Path compilerRelative = Paths.get("Java\\bin\\javac.exe");
        Path compilerBinRelative = Paths.get("bin\\javac.exe");
        Path binDirectory = Paths.get("bin");
        
        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", javaHome, compilerAbsolute, javaHome.relativize(compilerAbsolute));
        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", compilerAbsolute, javaHome, compilerAbsolute.relativize(javaHome));
        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", javaHome, user, javaHome.relativize(user));

//        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", javaHome, compilerRelative, javaHome.relativize(compilerRelative));

        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", binDirectory, compilerBinRelative, binDirectory.relativize(compilerBinRelative));
        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", compilerBinRelative, binDirectory, compilerBinRelative.relativize(binDirectory));
//        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", compilerRelative, compilerBinRelative, compilerRelative.relativize(compilerBinRelative));
//        System.out.printf("\"%s\".relativize(\"%s\"): %s\n", compilerBinRelative, compilerRelative, compilerBinRelative.relativize(compilerRelative));
    }
}

/**
 * To check:
 * - What happens if compilerAbsolute is changed for compilerRelative?
 * - What will be the output when relativizing compilerRelative against compilerBinRelative and vice versa?
 * - What happens if both paths are absolute and both are the same?
 */