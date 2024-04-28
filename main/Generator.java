/* This class is responsible for generating random board with all the necessarry things:
*   - '0' represents a free path.
*   - '1' represents an obstacle.
*   - '2' represents a reward that multiplies points by 2.
*   - '3' represents the finish line.
*/
package main;

import java.util.Arrays;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateRandomGameBoard(4)));
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
}
