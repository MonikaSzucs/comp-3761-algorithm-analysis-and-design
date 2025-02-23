import SetsAndMaps.*;
import MyFileReader.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Question 1
        ArrayList<String> loveWords = FileReader.getAllWords("love.txt");
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWords(loveWords);
        wordCounter.printWordsAndCount();

        // Question 2
        ArrayList<String> q2Words = FileReader.getAllWords("q2input.txt");
        wordCounter = new WordCounter();
        wordCounter.addWords(q2Words);
        wordCounter.printDistinct();

        // Question 3
        ArrayList<String>[] q3Words = FileReader.readKeywordsAndExcuses("q3test.txt");
        ArrayList<String> keywords = q3Words[0];
        ArrayList<String> excuses = q3Words[1];
        wordCounter = new WordCounter();
        wordCounter.addExcuses(excuses,keywords);
        wordCounter.printTopExcuses();
    }
}