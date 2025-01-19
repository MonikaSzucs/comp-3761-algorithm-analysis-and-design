import java.util.Arrays;

import anagram.*;

public class Main {
    public static void main(String[] args) {
        String[] words = ReadingFileData.readingFile("Dict.txt");
        AnagramCount theAnagram = new AnagramCount(0,"");

        long startTime = System.nanoTime();
        double conversionToSeconds = 1_000_000_000.0;
        AnagramLetterMatcher anagramLetterMatcher = new AnagramLetterMatcher();
        theAnagram = AnagramCounter.getWordWithMaxAnagrams(words, anagramLetterMatcher);
        double totalTime1 = (System.nanoTime() - startTime) / conversionToSeconds;
        System.out.println("Technique #1: ["+theAnagram.word+"] has "+theAnagram.count+" anagrams "+totalTime1+" secs");

        AnagramWordSorter anagramWordSorter = new AnagramWordSorter();
        startTime = System.nanoTime();
        theAnagram=AnagramCounter.getWordWithMaxAnagrams(words, anagramWordSorter);
        double totalTime2 = (System.nanoTime() - startTime) / conversionToSeconds;
        System.out.println("Technique #2: ["+theAnagram.word+"] has "+theAnagram.count+" anagrams "+totalTime2+" secs");

        AnagramHashCounter anagramHashCounter = new AnagramHashCounter();
        startTime = System.nanoTime();
        theAnagram=AnagramCounter.getWordWithMaxAnagrams(words, anagramHashCounter);
        double totalTime3 = (System.nanoTime() - startTime) / conversionToSeconds;
        System.out.println("Technique #3: ["+theAnagram.word+"] has "+theAnagram.count+" anagrams "+totalTime3+" secs");

    }
}