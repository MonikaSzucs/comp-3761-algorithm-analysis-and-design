package anagram;

import java.util.Arrays;

public class AnagramHashCounter implements AnagramInterface {
    private static final int ASCII_SIZE = 128;

    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        //System.out.println(word1 + " " + word2);

        int[] buckets = new int[ASCII_SIZE];
        // overall the runtime is O(2n) = O(n) we dont care about the constant
        // O(n)
        for (int i = 0; i < word1.length(); i++) {
            buckets[word1.charAt(i)]++;
        }
        // O(n)
        // .length can change 
        for (int i = 0; i < word2.length(); i++) {
            buckets[word2.charAt(i)]--;
        }

        // ASCII_SIZE does not change
        // O(128) == O(1) we dont care about constants
        for (int i = 0; i < ASCII_SIZE; i++) {
            if (buckets[i] != 0) {
                return false;
            }
        }
        //System.out.println("-- Are anagrams");

        return true;
    }
}
