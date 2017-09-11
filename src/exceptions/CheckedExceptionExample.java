package exceptions;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


/** Demonstrates file input / output in Java */
public class CheckedExceptionExample {
    public static void main(String[] args) {
        readUsingNewBufferedReader("dir/lyrics.txt");

    }

    /** Use Files.newBufferedReader to read every line from the given file
     *  and print it to the console.
     *  You need to know the encoding of the file you are reading (UTF-8 in this case).
     */
    public static void readUsingNewBufferedReader(String filename)  {
        Path path = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        /*BufferedReader reader = null;
        try {
             reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
             String line = null;
             while ((line = reader.readLine()) != null) {
                    System.out.println(line);
             }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        finally {
            // Need to close the reader..
        }
        */
    }


}
