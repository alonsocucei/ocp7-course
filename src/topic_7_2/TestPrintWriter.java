package topic_7_2;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * - Writes formatted characters to a Writer or File.
 * - if flushing is enabled then this will be done when calling any of println, printf or format methods.
 * - print() method is overloaded for every data type, you can use it as the same
 * when calling System.out.print(ln).
 * - The difference between PrintStream and PrintWriter is the first will write
 * what passed in the arguments as bytes, while the second will write chars.
 */
public class TestPrintWriter {
    public static void main(String[] args) {
        PrintWriter printerE = new PrintWriter(System.err, true);
        
        try (PrintWriter printer = new PrintWriter(System.out, true);) {            
            printer.println("texto");
            printer.print("texto2\n");
            printer.format("%s\n", "texto3");
            printer.write("texto4\n");
            printer.printf("%s\n", "texto5");
        }
        
        printerE.print("texto2\n");
        printerE.format("%s\n", "texto3");
        printerE.write("texto4\n");
        printerE.println("texto");
        printerE.printf("%s\n", "texto5");
    }
}

/**
 * To check:
 * - Connect a PrintWriter to System.out and other one to System.err.
 * - Print some data using print, format, and write methods.
 * - Does the program behaves as expected?
 */