package topic_8_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * - PosixFileAttributes interface is used to read Unix/Linux specific attributes.
 * - PosixFileAttributeView interface allows to write Unix/Linux specific attributes.
 * - Files class provides methods to write Unix/Linux attributes, which is preferred than
 * the interface.
 */
public class TestPosixAttributes {
    public static void main(String[] args) {
        Path basePath = Paths.get("C:\\Users\\jjsanche\\Desktop");
        Path filePath = basePath.resolve(Paths.get("test.txt"));
        
        try {
            Files.createFile(filePath);
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-r--r--");
            Files.setPosixFilePermissions(filePath, permissions);
            
            PosixFileAttributes posixAttributes = Files.readAttributes(filePath, PosixFileAttributes.class);
            
            System.out.printf("owner: %b\n", posixAttributes.owner());
            System.out.printf("group: %s\n", posixAttributes.group());
            System.out.printf("permissions: %s\n", posixAttributes.permissions());
            
            PosixFileAttributeView posixView = Files.getFileAttributeView(filePath, PosixFileAttributeView.class);
            posixView.setPermissions(PosixFilePermissions.fromString("rwxrw-rw"));
            
            posixAttributes = Files.readAttributes(filePath, PosixFileAttributes.class);
            System.out.printf("owner: %b\n", posixAttributes.owner());
            System.out.printf("group: %s\n", posixAttributes.group());
            System.out.printf("permissions: %s\n", posixAttributes.permissions());
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - When delete() method will throw an IOException?
 */