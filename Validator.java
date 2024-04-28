// This class is responsible for validating generated matrix (2D Array).

public class Validator {
    public static boolean isMatrixValid(int[][] matrix) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            if (matrix[i].length != N) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1 && matrix[i][j] != 2 && matrix[i][j] != 4) {
                    return false;
                }
            }
        }

        return true;
    }
}