//compile error: class, interface or enum expected
//import java.util.*;

//package sentence must be the first one in a .java file
package topic_1_7;

//Rules to name a package
//It may starts with $, letter or underscore(_)
//After first character next ones can be any of the previously mentioned, further
//numbers and dot (.)

//compile error: Incorrect package
//package topic_1_6;

//package sentence is allowed only once per file.
//so, this will generate a compile error.
//package topic_1_7;

/**
 * This file show the use of package statement.
 * 
 * @author alonsocucei
 */
public class TestPackages {
    public static void main(String[] args) {
        System.out.println("Hola mundo!3");
    }
}
//Next are some examples to compile and execute a file with packages.

//Compile: 
//javac <path to files .java> file1, file2, ...
//javac <path to files .java> *.java
//Example
//Inside the directory where is the file
//javac TestPackages.java

//Outside the directory where is the file
//javac src/TestPackages.java
//javac src/*.java

//Execute
//java <complete class name>
//java [-cp <path to root of class name>] <complete class name>
//Example:
//For this class topic_1_7.TestPackages
//Location must be in the directory that contains the topic_1_7 directory
//java topic_1_7.TestPackages

//For same class from a different location
//First indicate with classpath option the root directory of the class packages
//java -cp src topic_1_7.TestPackages
//java -classpath src topic_1_7.TestPackages

//To change the output directory for class files use -d option
//Example
//javac -d <path to output directory> <path to .java files> file1....
//javac -d test src\topic_1_7\*.java