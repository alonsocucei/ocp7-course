package topic_7_2;

import java.io.File;

/**
 * - File class can represent a file or directory.
 * - To check if it's one or the other isDirectory() and isFile() methods are used.
 * - To actually create a file or directory createNewFile(), mkdir(), mkdirs() methods are used.
 * - delete() and renameTo() methods may be used for files or directories.
 * - list() method returns all files and directories for the current valid File
 * object which must be a directory.
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("fileName");
    }
}

/**
 * To check:
 * - Write the code to read and print all directories and files for a certain path.
 * - What happens when creating a File object for a nonexistent file or directory.
 * - What exceptions are thrown by the methods listed on top?
 * - What happens when trying to create a file or directory that already exists?
 * - What happens when trying to create a file or directory and the name is not valid?
 */