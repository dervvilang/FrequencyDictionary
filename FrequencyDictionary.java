import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FrequencyDictionary {
    public void dictionary(String inpFileName, String outFileName) throws IOException {

        HashMap<Character, Integer> charCount = new HashMap<>();

        try (FileReader reader = new FileReader(inpFileName)){
            int c = 0;
            while ((c  = reader.read()) != -1) {
                char character = (char) c;
                if ((character >= 'a' &&  character <= 'z') || (character >= 'A' &&  character <= 'Z')) {
                    if (charCount.containsKey(character)) {
                        charCount.put(character, charCount.get(character) + 1);
                    }
                    else {
                        charCount.put(character, 1);
                    }
                }
            }
            writeToFile(charCount, outFileName);

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void writeToFile(HashMap<Character, Integer> charCount, String outFileName) throws IOException {

        try (FileWriter writer = new FileWriter(outFileName)) {

            for (Character character : charCount.keySet()) {
                writer.write(character + " - " + charCount.get(character) + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}