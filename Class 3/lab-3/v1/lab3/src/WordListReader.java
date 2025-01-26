import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class WordListReader {
    private String fileName;

    public WordListReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readWordList() {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
