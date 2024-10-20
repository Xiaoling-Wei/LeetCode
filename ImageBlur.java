import java.util.*;

public class ImageBlur {

    public static int[][] applyBlur(int[][] image, int radius) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] blurredImage = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blurredImage[i][j] = getBlurredValue(image, i, j, radius);
            }
        }
        return blurredImage;
    }

    private static int getBlurredValue(int[][] image, int i, int j, int radius) {
        int sum = 0;
        int count = 0;
        int rows = image.length;
        int cols = image[0].length;

        for (int k = Math.max(0, i - radius); k <= Math.min(rows - 1, i + radius); k++) {
            for (int l = Math.max(0, j - radius); l <= Math.min(cols - 1, j + radius); l++) {
                sum += image[k][l];
                count++;
            }
        }

        return sum / count;
    }

    public static void main(String[] args) {
        // Example image (3x3 matrix)
        int[][] image = {
                {100, 200, 150},
                {50,  255, 80},
                {200, 100, 70}
        };
        int radius = 1;  // Example radius

        int[][] blurredImage = applyBlur(image, radius);

        // Print the blurred image
        for (int[] row : blurredImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
