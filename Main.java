import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Would you like to open your file or create a new one? (o - open, n - create a new one): ");
            String fileChoice = sc.nextLine();

            String inpFileName;
            if (fileChoice.equalsIgnoreCase("n")) {
                // Создание нового файла
                System.out.print("Enter the name of the new input file: ");
                inpFileName = sc.nextLine();

                File inputFile = new File(inpFileName);

                if (!inputFile.exists()) {
                    if (inputFile.createNewFile()) {
                        System.out.println("A new input file has been created: " + inpFileName);

                        // Запрашиваем ввод текста для записи в новый файл
                        System.out.println("Enter the text to write to the new input file. To complete, enter an empty string.");
                        try (FileWriter writer = new FileWriter(inputFile)) {
                            String line;
                            while (!(line = sc.nextLine()).isEmpty()) {
                                writer.write(line + System.lineSeparator());
                            }
                        }
                        System.out.println("The input file is fulling up.");
                    } else {
                        throw new IOException("The input file could not be created.");
                    }
                } else {
                    System.out.println("A file with that name already exists. Use it for analysis.");
                }
            }
            else {
                System.out.print("Enter the name of the existing input file: ");
                inpFileName = sc.nextLine();

                File inpFile = new File(inpFileName);
                if (!inpFile.exists()) {
                    throw new IOException("File does not exist");
                }
            }
            System.out.print("Enter the name of the output file: ");
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

            System.out.print("Do you want to open a file or display its contents in the console? (o - open, c - output to the console, n - nothing): ");
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
        } catch (Exception a) {
            System.out.println("Unexpected error: " + a.getMessage());
        }
    }
}
