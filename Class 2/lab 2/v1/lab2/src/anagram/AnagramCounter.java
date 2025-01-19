package anagram;

public class AnagramCounter {

    public static void letterMatcher(String word1, String word2){
        System.out.println(word1+ " "+word2);
    }
    public static AnagramCount getWordWithMaxAnagrams(String[] words, AnagramInterface anagramMatcher) {
        String currentWord = "";
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String tempWord = words[i];
            //System.out.println(tempWord);
            int tempCount = 0;
            for (int j = 0; j < words.length; j++) {
                if(j!=i&&anagramMatcher.isAnagram(words[i].toLowerCase(), words[j].toLowerCase())){
                    tempCount+= 1;
                }
            }
            if(tempCount>count){
                currentWord=tempWord;
                count = tempCount;
            }
        }
        return new AnagramCount(count,currentWord);
    }
}

