public class NearlyRegularCrosses {

    public static boolean isNearlyRegularCross(int[][] matrix, int r, int c) {
        int rowValue = matrix[r][0] == matrix[r][c] ? matrix[r][1] : matrix[r][0]; // Reference value for the row
        int colValue = matrix[0][c] == matrix[r][c] ? matrix[1][c] : matrix[0][c]; // Reference value for the column
        boolean isRowRegular = true;
        boolean isColRegular = true;
        for (int j = 0; j < matrix[0].length; j++) {
            if (j != c && matrix[r][j] != rowValue) {
                isRowRegular = false;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i != r && matrix[i][c] != colValue) {
                isColRegular = false;
                break;
            }
        }
        return isRowRegular && isColRegular;
    }
    public static int countNearlyRegularCrosses(int[][] matrix) {
        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (isNearlyRegularCross(matrix, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,3}
        };

        // Call the function to count nearly regular crosses
        int result = countNearlyRegularCrosses(matrix);
        System.out.println("Number of nearly regular crosses: " + result);  // Expected output: 4
    }
}
