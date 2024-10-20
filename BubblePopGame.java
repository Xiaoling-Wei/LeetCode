public class BubblePopGame {

    private static final int[][] DIAGONAL_DIRECTIONS = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static int[][] playBubbleGame(int[][] bubbles, int[][] operations) {
        int rows = bubbles.length;
        int cols = bubbles[0].length;
        for (int[] op : operations) {
            int row = op[0];
            int col = op[1];
            int color = bubbles[row][col];
            if (color == 0) continue;
            popBubbles(bubbles, row, col, color);
            dropBubbles(bubbles);
        }
        return bubbles;
    }
    private static void popBubbles(int[][] bubbles, int row, int col, int color) {
        bubbles[row][col] = 0; // Pop the clicked bubble
        for (int[] dir : DIAGONAL_DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < bubbles.length && newCol >= 0 && newCol < bubbles[0].length) {
                if (bubbles[newRow][newCol] == color) {
                    bubbles[newRow][newCol] = 0; // Pop the diagonal neighbor
                }
            }
        }
    }
    private static void dropBubbles(int[][] bubbles) {
        int rows = bubbles.length;
        int cols = bubbles[0].length;
        for (int col = 0; col < cols; col++) {
            int emptyRow = rows - 1; // Start from the bottom row
            for (int row = rows - 1; row >= 0; row--) {
                if (bubbles[row][col] != 0) {
                    bubbles[emptyRow][col] = bubbles[row][col];
                    if (emptyRow != row) {
                        bubbles[row][col] = 0; // Set to 0 after moving the bubble down
                    }
                    emptyRow--; // Move emptyRow pointer up
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] bubbles = {
                {1, 1, 1, 4, 3},
                {4, 1, 2, 3, 3},
                {1, 5, 1, 1, 2},
                {4, 3, 2, 2, 4}
        };

        int[][] operations = {
                {1, 2}, {2, 1}
        };

        int[][] result = playBubbleGame(bubbles, operations);

        // Print the resulting board
        for (int[] row : result) {
            for (int bubble : row) {
                System.out.print(bubble + " ");
            }
            System.out.println();
        }
    }
}
