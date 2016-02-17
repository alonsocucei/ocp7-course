package topic_7_2;

import java.io.File;
import java.io.IOException;

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
        File file = new File("build/../fileName.txt");
        File dir = new File("dir1");
        File dirs = new File("dir1/dir2/dir3");
        
        System.out.printf("is %s: %b\n", "file", file.isFile());
        System.out.printf("is %s: %b\n", "directory", file.isDirectory());
        
        try {
            System.out.printf("create %s: %b\n", "file", file.createNewFile()); //may throw an IOException
//            System.out.printf("create %s: %b\n", "dir", dir.mkdir());  //may throw a SecurityException
//            System.out.printf("create %s: %b\n", "dir", dirs.mkdirs());  //may throw a SecurityException
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.printf("is %s: %b\n", "file", file.isFile());
        System.out.printf("is %s: %b\n", "directory", file.isDirectory());
        
        System.out.printf("rename %s %s: %b\n", "file", file.getName(), file.renameTo(new File("fileRenamed.txt")));
        System.out.printf("delete %s %s: %b\n", "file", file.getName(), file.delete());
        
        try {
            System.out.printf("absolute path: %s\ncanonical path:%s\n", file.getAbsolutePath(), file.getCanonicalPath());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        File nbprojectDir = new File("nbproject");
        String [] dirContents = nbprojectDir.list();
        
        for (String dirContent : dirContents) {
            File dirEntry = new File(nbprojectDir, dirContent);
            System.out.printf("name: %s - type:%s\n", dirEntry.getPath(), dirEntry.isDirectory() ? "dir" : dirEntry.isFile() ? "file" : "none");
        }
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