import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the name of the input file: ");
            String inpFileName = sc.nextLine();

            File inpFile = new File(inpFileName);
            if (!inpFile.exists()) {
                throw new IOException("File does not exist");
            }

            System.out.println("Enter the name of the output file: ");
            String outFileName = sc.nextLine();

            File outFile = new File(outFileName);
            if (!outFile.exists()) {
                if (outFile.createNewFile()) {
                    System.out.println("File was created");
                } else {
                    throw new IOException("File was not created");
                }
            }

            FrequencyDictionary dict = new FrequencyDictionary();
            dict.dictionary(inpFileName, outFileName);

            System.out.println("Processing is completed. The results are saved to a file: " + outFileName);

            System.out.println("Do you want to open a file or display its contents in the console? (o - open, c - output to the console, n - nothing): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("o")) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.OPEN)) {
                        desktop.open(outFile);
                    } else throw new UnsupportedOperationException("Sorry, that file is not supported");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (input.equalsIgnoreCase("c")) {
                try (Scanner fileScanner = new Scanner(outFile)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else System.out.println("Program completed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
