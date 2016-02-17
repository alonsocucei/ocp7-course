package topic_7_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * - DataInputStream and DataOutputStream classes are used to read/write for
 * primitive types and Strings.
 * - DataInputStream methods to read a are of type: read<type>(). e.g. readInt(), readLong(), etc.
 * - DataOutputStream methods to write are of type: write<type>(). e.g. writeInt(), writeLong(), etc.
 * - Data must be read in the same order it was written, otherwise the results will be unexpected.
 * - They use chained constructors, receiving InputStream and OutputStream objects respectively.
 * - EOFException is thrown when trying to read after end of file.
 */
public class TestDataStreams {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("test.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            FileInputStream fis = new FileInputStream("test.txt");
            DataInputStream dis = new DataInputStream(fis)) {
            
            dos.write(1);
            dos.writeByte(1);
//            dos.close();
            dos.writeBoolean(false);
            dos.writeDouble(3.2);
            
            System.out.println(dis.readShort());
            System.out.println(dis.read());
            System.out.println(dis.readDouble());
            System.out.println(dis.read());
//            System.out.println(dis.readInt());
//            System.out.println(dis.readInt());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What's the output of the program?
 * - What happens when writing a boolean and it's read as byte?
 * - What happens if the stream is closed and then a read/write operation is done?
 * - Write a double and read it back using 2 integers, and print its bits representation.
 */