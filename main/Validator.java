// This class is responsible for validating generated matrix (2D Array).

package main;

public class Validator {
    public static boolean isMatrixValid(int[][] matrix) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            if (matrix[i].length != N) {
                return false; // Must be a square
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1 && matrix[i][j] != 2 && matrix[i][j] != 3) {
                    return false; // Must contain numbers from 1 - 3.
                }
            }
        }

        return true;
    }
}