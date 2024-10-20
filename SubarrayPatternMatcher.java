public class SubarrayPatternMatcher {

    public static int countMatchingSubarrays(int[] numbers, int[] pattern) {
        int n = numbers.length;
        int pLen = pattern.length;
        int count = 0;
        for (int i = 0; i <= n - pLen; i++) {
            if (matchesPattern(numbers, pattern, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean matchesPattern(int[] numbers, int[] pattern, int start) {
        for (int i = 0; i < pattern.length; i++) {
            int num1 = numbers[start + i];
            int num2 = numbers[start + i + 1];
            if (pattern[i] == 1 && !(num2 > num1)) {
                return false;
            } else if (pattern[i] == 0 && !(num2 == num1)) {
                return false;
            } else if (pattern[i] == -1 && !(num2 < num1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example input
        int[] numbers = {4, 1, 3, 4, 4, 5, 5, 1};
        int[] pattern = {1, 0, -1};

        // Find and print the number of matching subarrays
        int result = countMatchingSubarrays(numbers, pattern);
        System.out.println("Number of matching subarrays: " + result); // Expected output: 1
    }
}
