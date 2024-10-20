import java.util.*;

public class ObjectCollisionCounter {
    public static void main(String[] args) {
        // Example input: array of integer pairs representing object centers
        int[][] centers = {
                {1, 1},
                {2, 2},
                {0, 4}
        };
        int collisionCount = countCollisions(centers);
        System.out.println("Number of colliding object pairs: " + collisionCount);
    }
    public static int countCollisions(int[][] centers) {
        int count = 0;
        int n = centers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areColliding(centers[i], centers[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean areColliding(int[] center1, int[] center2) {
        int x1 = center1[0];
        int y1 = center1[1];
        int x2 = center2[0];
        int y2 = center2[1];
        return !(x1 + 1 < x2 - 1 || x1 - 1 > x2 + 1 || y1 + 1 < y2 - 1 || y1 - 1 > y2 + 1);
    }
}
