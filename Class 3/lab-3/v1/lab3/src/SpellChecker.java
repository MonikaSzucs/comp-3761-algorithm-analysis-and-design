import java.util.*;


public class SpellChecker {
    public static void main(String[] args) {
        WordListReader wordListReader = new WordListReader("lab3_wordlist.txt", true);
        WordListReader testData = new WordListReader("lab3_testData.txt", false);

        // Get the word list from the WordListReader
        List<String> wordList = wordListReader.getWordList();

        // Print the word list to verify
        System.out.println("Word List from file:");
        for (String word : wordList) {
            System.out.println(word);
        }

        wordSearch(wordListReader.getWordList(), testData.getWordList(), true);
        wordSearch(wordListReader.getWordList(), testData.getWordList(), false);
    }
    
    public static void wordSearch(List<String> wordList, List<String> testData, boolean sequential){
        int count = 0;
        long startTime = System.nanoTime();
        if(sequential){
            for (int i = 0; i < testData.size(); i++) { // not part of the algorithm
                if(seqSearch(wordList,testData.get(i))){
                    count++;
                }
            }
            System.out.println("Sequential search: " + count + "\t words " + (System.nanoTime()-startTime)/1000 + " Microsecond");
        }
        else{
            for (int i = 0; i < testData.size(); i++) { // not part of the algorithm
                if(binSearch(wordList,testData.get(i))){
                    count++;
                }
            }
            System.out.println("Binary search: " + count + "\t words " + (System.nanoTime()-startTime)/1000 + " Microsecond");
        }
    }

    public static boolean seqSearch(List<String> wordList, String testString) {
            for (int j = 0; j < wordList.size(); j++) {
                if(testString.equals(wordList.get(j))){
                    return true;
                }
            }
        return false;
    }

    public static boolean binSearch(List<String> wordList, String testString) {
        return binarySearchRecursive(0, wordList.size()-1, testString, wordList);
    }

    private static boolean binarySearchRecursive(int startIndex, int lastIndex, String word, List<String> wordList){
        int middleIndex = (startIndex+lastIndex) / 2;

        if (lastIndex < startIndex){
            return false;
        }
        if (wordList.get(middleIndex).equals(word)) {
            return true;
        }
        // if string at middleIndex is less than the word (comes before in dictionary/sorted order), we know that the half after the middleIndex should have the word.
        else if (wordList.get(middleIndex).compareTo(word) < 0) { // smaller middle index
            return binarySearchRecursive( middleIndex+1,  lastIndex,  word, wordList);
        }
        else {
            return binarySearchRecursive( startIndex,  middleIndex-1,  word, wordList);
        }
    }
}