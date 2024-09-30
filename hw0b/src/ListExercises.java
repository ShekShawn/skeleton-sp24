import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum=0;
        for(int i=0;i<L.size();i++){
            sum+=L.get(i);
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> evenNumbers=new ArrayList<>();
        for(int num:L){
            if (num%2==0){
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        //sort two list first(if needed
        //iterate through two list using a two-demention loop
        //if the first-loop number equals the second-loop number then add it to the list
        List<Integer>commonItems=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>(L1);
        for(int num:L2){
            if (set.contains(num)&& !commonItems.contains(num)){
                commonItems.add(num);
            }
        }
        return commonItems;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int count=0;
        for(String word:words){
            for(char ch: word.toCharArray()){
            if (ch==c){
                count+=1;
            }
            }
        }
        return count;
    }
}
