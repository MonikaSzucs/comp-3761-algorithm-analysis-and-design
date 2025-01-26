import java.util.*;


public class SpellChecker {
    public static void main(String[] args) {
        WordListReader wordListReader = new WordListReader("lab3_wordlist.txt");

        // Get the word list from the WordListReader
        List<String> wordList = wordListReader.readWordList();

        // Print the first 10 words from the word list
//        System.out.println("First 10 words from the word list:");
//        for (int i = 0; i < Math.min(10, wordList.size()); i++) {
//            System.out.println(wordList.get(i));
//        }


        // Print the word list to verify
        System.out.println("Word List from file:");
        for (String word : wordList) {
            System.out.println(word);
        }
        int unfoundCount = seqSearch(wordListReader);
        System.out.println(unfoundCount);
    }

    public static int seqSearch(WordListReader wordListReader) {
        List<String> wordList = new ArrayList<String>();

        return wordList.size();
    }

    public static int binSearch() {
        List<String> wordList = new ArrayList<String>();
        return wordList.size();
    }
}