package anagram;
import java.util.Arrays;

public class AnagramWordSorter implements AnagramInterface{
    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        //System.out.println(word1 + " " + word2);
        // O(nlogn) > O(n) therefore O(nlogn) is the runtime of the most significant operation of this function
        // O(nlogn)+O(nlogn)=O(2nlogn)=O(nlogn)(ignoring the constant)
        word1 = sortString(word1);
        word2 = sortString(word2);
        // O(n)
//        if (word1.equals(word2)) {
//            System.out.println("-- Are anagrams");
//        }
        return word1.equals(word2);
    }

    public String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
