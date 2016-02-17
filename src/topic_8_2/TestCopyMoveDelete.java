package topic_8_2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - Files class is used in NIO to copy, delete or move files.
 * - Methods in this class receive as arguments Path objects.
 * - StandardCopyOption enum defines options to apply when copying files.
 */
public class TestCopyMoveDelete {
    public static void main(String[] args) {
        Path source = Paths.get("existing.txt");
        Path target = Paths.get("not_existing_file.txt");
        Path movedTarget = Paths.get("moved_file.txt");
        
        System.out.printf("File: %s exists: %b\n", source, Files.exists(source));
        System.out.printf("File: %s not exists: %b\n", source, Files.notExists(source));

        try {
//            Files.copy(source, target);
//            Files.move(target, movedTarget);
//            Files.copy(source, target); //at this point the file must exist
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
//            Files.delete(target);
//            Files.deleteIfExists(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What happens when trying to copy a file and target already exists?
 * - What the move method does?
 * - What's the difference between delete() and deleteIfExists methods?
 */