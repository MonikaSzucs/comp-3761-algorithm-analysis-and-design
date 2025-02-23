package SetsAndMaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    private Map<String, Integer> wordCount;
    private int maxExcuse=0;

    public WordCounter() {
        wordCount = new LinkedHashMap<>();
    }
    
    // should this be case sensitive or no?
    public void addWords(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            // Convert the word to lowercase to ensure case insensitivity
            String word = words.get(i).toLowerCase();

            // Update the word count
            if (wordCount.containsKey(word)) {
                int oldCount = wordCount.get(word);
                wordCount.put(word, oldCount + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
    }
    public void addExcuses(ArrayList<String> excuses, ArrayList<String> words) {
        for (int i = 0; i < excuses.size(); i++) {
            // Convert the word to lowercase to ensure case insensitivity
            String excuse = excuses.get(i);
            int keyWordsFound=0;
            for(int j=0;j<words.size();j++){
                Pattern p = Pattern.compile(words.get(j));
                Matcher m = p.matcher( excuse );
                while (m.find()) {
                    keyWordsFound++;
                }
            }
            if(keyWordsFound>maxExcuse){
                maxExcuse=keyWordsFound;
            }
            wordCount.put(excuse, keyWordsFound);
        }
    }
    public void printWordsAndCount() {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    public void printDistinct() {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            // Check if the word is distinct
            if (count == 1) {
                System.out.println(word + " - distinct");
            } else {
                System.out.println(word + " - not distinct");
            }
        }
    }
    public void printTopExcuses() {
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            // Check if the word is distinct
            if (count == maxExcuse) {
                System.out.println(word + " - " + count);
            }
        }
    }
    // if dinstict per file
    // public void printDistinct() {
    //     for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
    //         String word = entry.getKey();
    //         int count = entry.getValue();

    //         // Check if the word is distinct
    //         if (count != 1) {
    //             System.out.println(word + " - not distinct");
    //             return;
    //         }
    //     }
    //     System.out.println(word + " - distinct");
    // }
}
