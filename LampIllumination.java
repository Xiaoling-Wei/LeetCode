import java.util.Arrays;

public class LampIllumination {
    public static int[] countIlluminatedPoints(int[][] lamps, int[] points) {
        int[] result = new int[points.length];
        for (int j = 0; j < points.length; j++) {
            int count = 0;
            int point = points[j];
            for (int i = 0; i < lamps.length; i++) {
                int start = lamps[i][0];
                int end = lamps[i][1];
                if (point >= start && point <= end) {
                    count++;
                }
            }
            result[j] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] lamps = { {1,7}, {5, 11}, {7, 9} };
        int[] points = {7,1,5,10,9,15};

        // Call the function and get the result.
        int[] result = countIlluminatedPoints(lamps, points);

        System.out.println(Arrays.toString(result)); // Output: [3, 2, 1]
    }
}
