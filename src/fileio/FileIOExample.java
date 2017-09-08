package fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


/** Demonstrates file input / output in Java */
public class FileIOExample {
    public static void main(String[] args) {

       // readUsingBufferedReader("dir/lyrics.txt");
        // readUsingNewBufferedReader("dir/lyrics.txt");

        //readUsingStreams("dir/lyrics.txt");
        readWrite("dir/lyrics.txt", "dir/output.txt");
    }

    /** Use Files.newBufferedReader to read every line from the given file
     *  and print it to the console.
     */
    public static void readUsingNewBufferedReader(String filename) {
        Path path = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void readUsingBufferedReader(String filename) {
        try (BufferedReader  reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch(IOException e) {
             System.out.println(e);
        }
    }

    /** Use Java 8 streams to read from the file */
   public static void readUsingStreams(String fileName) {
       Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path)) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Read from one file and write to another */
    public static void readWrite(String inputFile, String outputFile) {
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        try (PrintWriter pw = new PrintWriter(outputPath.toString()); BufferedReader reader = Files.newBufferedReader(inputPath, Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                pw.println(line);
            }
            pw.flush();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
