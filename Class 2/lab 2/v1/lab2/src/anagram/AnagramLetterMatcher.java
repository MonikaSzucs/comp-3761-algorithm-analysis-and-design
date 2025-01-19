package anagram;

public class AnagramLetterMatcher implements AnagramInterface{
    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        //System.out.println(word1 + " " + word2);
        //Everything combined below is O(2n^2) = O(n^2) we ignre the constant
        for (int i = 0; i < word1.length(); i++) { // O(n)
            // Next two lines combined are O(n) + O(n) + O(1) = O(2n) (ignoring constant 1)
            if (word2.isEmpty()) return false; // O(1)
            if (word2.contains(word1.charAt(i) + "")) { // O(n)
                word2 = word2.replaceFirst(String.valueOf(word1.charAt(i)), "");//O(n)
            }
        }

        //if (word2.isEmpty()) System.out.println("-- Our anagrams");
        return word2.isEmpty();
    }
}
