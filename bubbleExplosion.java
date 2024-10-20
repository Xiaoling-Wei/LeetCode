import java.util.Arrays;

public class bubbleExplosion {
    public static void main(String[] args) {
        int[][] board = {
                {3,1,2,1},
                {1,1,1,4},
                {3,1,2,2},
                {3,3,3,4}
        };

        int[][] result = bubbleExplosion(board);

        // 输出最终棋盘状态
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] bubbleExplosion(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] toExplode = new boolean[rows][cols]; // 标记哪些气泡将要爆炸
        boolean exploded = false;

        // Step 1: 找到符合条件的气泡
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != 0 && hasTwoSameColorNeighbors(board, i, j)) {
                    // 标记爆炸的气泡以及相邻的同色气泡
                    dfsMark(board, toExplode, i, j, board[i][j]);
                    exploded = true;
                }
            }
        }

        // 如果没有任何气泡符合爆炸条件，直接返回原始棋盘
        if (!exploded) {
            return board;
        }

        // Step 2: 清除被标记的气泡
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (toExplode[i][j]) {
                    board[i][j] = 0; // 设置为空
                }
            }
        }

        // Step 3: 让上方气泡下落
        dropBubbles(board);

        return board;
    }

    // 检查某个气泡是否有至少两个相邻气泡颜色相同
    private static boolean hasTwoSameColorNeighbors(int[][] board, int row, int col) {
        int sameColorCount = 0;
        int color = board[row][col];
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                    && board[newRow][newCol] == color) {
                sameColorCount++;
            }
        }
        return sameColorCount >= 2;
    }

    // 使用DFS标记相邻的同色气泡
    private static void dfsMark(int[][] board, boolean[][] toExplode, int row, int col, int color) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || toExplode[row][col]
                || board[row][col] != color) {
            return;
        }

        toExplode[row][col] = true; // 标记为爆炸

        for (int[] dir : DIRECTIONS) {
            dfsMark(board, toExplode, row + dir[0], col + dir[1], color);
        }
    }

    // 让上方的气泡下落
    private static void dropBubbles(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int j = 0; j < cols; j++) { // 对每一列进行处理
            int emptyRow = rows - 1; // 从最底部开始
            for (int i = rows - 1; i >= 0; i--) {
                if (board[i][j] != 0) { // 如果这个位置有气泡，移动到空位
                    board[emptyRow][j] = board[i][j];
                    if (emptyRow != i) {
                        board[i][j] = 0; // 将上方位置置为空
                    }
                    emptyRow--;
                }
            }
        }
    }
}
