/* This class is responsible for generating random board with all the requirements:
*   - '0' represents a starting point.
*   - '1' represents a path.
*   - '2' represents a reward that multiplies points by 2.
*   - '3' represents the finish line.
*/
package main;

import java.util.Arrays;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 1, 2, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1, 2, 1, 1, 2, 1},
                {2, 1, 1, 2, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 1, 1, 1, 1, 1, 3}
        };
        
        System.out.println(Arrays.deepToString(generateRandomGameSolution(matrix)));
    }

    public static int[][] generateRandomGameBoard(int sizeOfBoard) {
        // Initialize board
        int[][] gameBoard = new int[sizeOfBoard][sizeOfBoard];

        // Initialize the game board with obstacles and rewards
        Random random = new Random();
        double rewardProbability = 0.1;

        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                // Randomly assign obstacles or rewards based on probability
                if (random.nextDouble() < rewardProbability) {
                    gameBoard[i][j] = 2; // Reward placing
                } else {
                    gameBoard[i][j] = random.nextInt(1, 2); // Obstacle '1' or free path '0'
                }
            }
        }

        // Set starting and ending point
        gameBoard[0][0] = 0;
        gameBoard[sizeOfBoard - 1][sizeOfBoard - 1] = 3;

        return gameBoard;
    }

    public static int[][] generateRandomGameSolution(int[][] matrix) {
        int N = matrix.length;

        // Starting point
        int currentX = 0;
        int currentY = 0;
        
        // Distance (used in fitness function later)
        int distance = 0;

        while (matrix[currentX][currentY] != 3) {
            // Random move (0: up, 1: right, 2: down, 3: left)
            Random random = new Random();
            int directionToMove = random.nextInt(4);
            
            //TODO: Probably using switch statement with variable 'directionToMove' (DK yet)
        }
        
        int[][] dummyToRemoveError = new int[0][0];
        return dummyToRemoveError;
    }
}
