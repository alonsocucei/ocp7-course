package topic_8_2;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * - Files class is used in NIO to copy, delete or move files.
 * - Methods in this class receive as arguments Path objects.
 * - StandardCopyOption enum defines options to apply when copying files.
 */
public class TestCopyMoveDelete {
    public static void main(String[] args) {
        Path userHome = Paths.get(System.getProperty("user.home"));
        Path desktopRel = Paths.get("Desktop");
        Path desktop = userHome.resolve(desktopRel);
        
        Path emptyFolder = desktop.resolve("empty folder");
        Path newFolder = desktop.resolve("new folder");
        
        Path source = desktop.resolve("existing.txt");
        Path dir = desktop.resolve("not_existing_dir");
        Path target = desktop.resolve(dir).resolve("not_existing_file.txt");
        
        System.out.printf("File: %s exists: %b\n", source, Files.exists(source));
        System.out.printf("File: %s not exists: %b\n", source, Files.notExists(source));

        //create files and directories
        try {
            Files.createFile(source);
            Files.createDirectory(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //copy and move files and directories
        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //delete created files and directories
        try {
//            Files.delete(source);
//            Files.deleteIfExists(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - Test following cases:
 *  copy file:
 *  + target doesn't exists
 *  + target exists
 *  + target exists using REPLACE_EXISTING
 * 
 *  move file:
 *  + target doesn't exists
 *  + target exist
 *  + target exist using REPLACE_EXISTING
 * 
 *  copy directory:
 *  + source is empty, target doesn't exists
 *  + source is empty, target exists
 *  + source is empty, target exists using REPLACE_EXISTING
 *  + source is not empty, target doesn't exists
 *  + source is not empty, target exists
 *  + source is not empty, target exists using REPLACE_EXISTING
 * 
 *  move directory:
 *  + source is empty, target doesn't exists
 *  + source is empty, target exists and is empty
 *  + source is empty, target exists and is empty using REPLACE_EXISTING
 *  + source is empty, target exists and is not empty
 *  + source is empty, target exists and is not empty using REPLACE_EXISTING
 *  + source is not empty, target doesn't exists
 *  + source is not empty, target exists and is empty
 *  + source is not empty, target exists and is empty using REPLACE_EXISTING
 *  + source is not empty, target exists and is not empty
 *  + source is not empty, target exists and is not empty using REPLACE EXISTING
 * 
 * - What the move method does?
 * - What's the difference between delete() and deleteIfExists methods?
 */