import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MapExercises {
    /** Returns a map from everhy lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        Map<Character, Integer>letterMap=new HashMap<>();
        for (char ch ='a';ch<='z';ch++){
            letterMap.put(ch,ch-'a'+1);
        }
        return letterMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer, Integer> squares=new HashMap<>();
        for (int i=0;i<nums.size();i++){
            int num=nums.get(i);
            squares.put(num,num*num);
        }
        return squares;
    }
    }
    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
        Map<String, Integer> countWordsMap=new HashMap<>();
        for(String word:words){
            int currentCount=countWordsMap.getOrDefault(word,0);
            countWordsMap.put(word, currentCount+1);
        }
        return countWordsMap;
    }
}
