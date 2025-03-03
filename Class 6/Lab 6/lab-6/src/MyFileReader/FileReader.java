package MyFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader {

    private static void sortedInsert(ArrayList<String> words, String newWord){
        
        // Perform binary search to find the insertion point
        int index = Collections.binarySearch(words, newWord);

        // If the word is not found, calculate the insertion point
        if (index < 0) {
            index = -index - 1;
        }

        // Insert the new word at the correct position
        words.add(index, newWord);

    }
    public static ArrayList<String> getAllWords(String filePath){
        ArrayList<String> words = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // System.out.println(line);
                String[] lineWords = line.split(" ");
                for(int i =0;i<lineWords.length;i++){
                    if (lineWords[i].trim().length() > 0) {
                        sortedInsert(words,lineWords[i].toLowerCase());
                        // words.add(lineWords[i].toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    } 
    public static ArrayList<String>[] readKeywordsAndExcuses(String filePath){
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> excuses = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int lineNumber = 1;
            int K = 0, E = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber==1 ){
                    String[] kAndE = line.split(" ");
                    K = Integer.parseInt(kAndE[0]); // First integer
                    E = Integer.parseInt(kAndE[1]);
                }
                else if(lineNumber >= 2 && lineNumber <= K+1) {
                    sortedInsert(words,line.toLowerCase());
                }
                else if(lineNumber >= K+2 && lineNumber <= K+1+E){
                    sortedInsert(excuses,line.toLowerCase());
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(words);
        return new ArrayList[]{words, excuses};
    } 
}
