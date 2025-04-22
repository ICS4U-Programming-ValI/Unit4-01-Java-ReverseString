import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 * This is the package for ReverseString.java
 *
 * The ReverseString program reads a string a file
 * and reverses the string.
 * using recursion
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val Ijaola
 * @version 1.0
 * @since 2025-04-11
 */






public final class ReverseString {


    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This method reverses a string using recursion.
     *
     * @param str the string to be reversed
     * @return the reversed string
     */
    public static String reverseString(final String str) {
        if (str.length() == 0 || str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }


    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        try {
            // Specify the file paths
            String filePath = "input.txt";
            File outputFile = new File("output.txt");


            // Create a FileWriter and PrintWriter for the output file
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            // Read the word from the input file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();


                // Reverse the string
                String reversedString = reverseString(word);


                // Write the reversed string to the output file
                printWriter.println("Reversed String: " + reversedString);
            }


            // Close the scanner and writer
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading the file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error writing to the file: " + ex.getMessage());
        }
    }
}
