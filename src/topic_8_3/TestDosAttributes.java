package topic_8_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/**
 * - DosFileAttributes interface is used to read DOS specific attributes.
 * - DosFileAttributeView interface allows to write DOS specific attributes.
 * - Files class provides methods to write DOS attributes, which is preferred than
 * the interface.
 */
public class TestDosAttributes {
    public static void main(String[] args) {
        Path userHome = Paths.get(System.getProperty("user.home"));
        Path desktopRel = Paths.get("Desktop");
        Path desktop = userHome.resolve(desktopRel);
        Path filePath = desktop.resolve(Paths.get("test.txt"));
        
        try {
            Files.createFile(filePath);
            Files.setAttribute(filePath, "dos:hidden", true);
            Files.setAttribute(filePath, "dos:readonly", true);
            
            DosFileAttributes dosAttributes = Files.readAttributes(filePath, DosFileAttributes.class);
            
            System.out.printf("is hidden: %b\n", dosAttributes.isHidden());
            System.out.printf("is read only: %b\n", dosAttributes.isReadOnly());
            
            DosFileAttributeView dosView = Files.getFileAttributeView(filePath, DosFileAttributeView.class);
            dosView.setHidden(false);
            dosView.setReadOnly(false);
            
            dosAttributes = Files.readAttributes(filePath, DosFileAttributes.class);
            System.out.printf("is hidden: %b\n", dosAttributes.isHidden());
            System.out.printf("is read only: %b\n", dosAttributes.isReadOnly());
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What other methods the DosFileAttributes interface have?
 * - What other methods the DosFileAttributeView interface have?
 * - What happens if changing the case of a dos attribute when using the setAttribute() method?
 */