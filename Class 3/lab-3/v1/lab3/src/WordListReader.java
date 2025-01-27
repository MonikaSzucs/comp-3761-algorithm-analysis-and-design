import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class WordListReader {
    private String fileName;
    private List<String> wordList;

    public WordListReader(String fileName, boolean lineSeparated) {
        this.fileName = fileName;
        readWordList(lineSeparated);
    }

    private void readWordList(boolean lineSeparated) {
        this.wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if(lineSeparated){
                while ((line = reader.readLine()) != null) {
                    wordList.add(line.trim().toLowerCase());
                }
            }
            else{
                this.wordList = Arrays.asList(reader.readLine().toLowerCase().split(" "));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordList() {
        return wordList;
    }
}
