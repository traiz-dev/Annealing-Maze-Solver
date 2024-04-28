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
        // Initialising board
        int[][] gameBoard = new int[sizeOfBoard][sizeOfBoard];

        // Random number to calculate probability of placing 0 in any way from starting point to make it as much random as possible.
        Random random = new Random();
        double probability = 0.5;
        double rand = random.nextDouble();

        // Initialize the game board with obstacles
        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                gameBoard[i][j] = random.nextInt(2); // Randomly assign 0 or 1 for obstacles
            }
        }
        
        // Set starting and ending point
        gameBoard[0][0] = -1;
        gameBoard[sizeOfBoard - 1][sizeOfBoard - 1] = 3;

        // Creating a path
        if (rand < probability) {
            gameBoard[0][1] = 0; // Assign element to [0][1]
        } else {
            gameBoard[1][0] = 0; // Assign element to [1][0]
        }
        
        return gameBoard;
    }
}
