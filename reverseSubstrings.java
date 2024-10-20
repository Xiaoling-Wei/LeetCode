import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class reverseSubstrings {
    public static void main(String[] args) {

        String word = "dbaca";
        System.out.println(getNewString(word));
    }

    private static String reverse(String str, int start,int end){
        char[] charArr = str.toCharArray();
        while(start < end){
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }

    public static String getNewString(String word){
        String smallest = word;

        for (int i = 0; i < word.length(); i++) {
            String newString = reverse(word,0,i);
            if (newString.compareTo(smallest) < 0){
                smallest = newString;
            }
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            String newString = reverse(word,i,word.length()-1);
            if (newString.compareTo(smallest) < 0){
                smallest = newString;
            }

        }
        return smallest;
    }
}
