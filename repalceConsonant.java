public class repalceConsonant {

    public static boolean isConsonant(char ch) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return consonants.indexOf(ch) != -1;
    }
    public static char nextConsonant(char ch) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        if (Character.isUpperCase(ch)) {
            consonants = consonants.toUpperCase();
        }
        int index = consonants.indexOf(ch);
        return consonants.charAt((index + 1) % consonants.length());
    }

    public static String replaceNthConsonant(String message, int n) {
        int consonantCount = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (isConsonant(ch)) {
                consonantCount++;
                if (consonantCount % n == 0) {
                    result.append(nextConsonant(ch));
                } else {
                    result.append(ch);
                }
            } else {
                result.append(ch); // Non-consonants stay the same
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case
        String message = "CodeSignal";
        int n = 3;
        System.out.println(replaceNthConsonant(message, n)); // Expected output: "Hellp, Wprld!"
    }
}
