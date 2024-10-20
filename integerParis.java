import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class integerParis {
    public static void main(String[] args) {
        int[] numbers1 = {1, 23, 156, 1650, 651, 165, 32};
        System.out.println(paris(numbers1));
    }

    public static int paris(int[] nums) {
        Map<String,Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums){
            char[] c = String.valueOf(num).toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (map.containsKey(s)){
                count += map.get(s);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int n : map.values()){
            if (n==2){
                count--;
            }
        }

        return count;
    }
}
