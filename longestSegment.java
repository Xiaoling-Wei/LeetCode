import java.util.*;

public class longestSegment {
    public static void main(String[] args) {
        int[] nums= {2,1,3};
        System.out.println(longestConsecutive(nums));
    }

    public static List<Integer> longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       List<Integer> res = new ArrayList<>();
       int longest = 0;
       for (int num : nums) {
           set.add(num);
           int left = num;
           int right = num;
           while(set.contains(left-1)){
               left--;
           }
           while(set.contains(right+1)){
               right++;
           }
           int cur = right - left + 1;
           longest = Math.max(longest, cur);
           res.add(longest);
       }
       return res;
    }
}
