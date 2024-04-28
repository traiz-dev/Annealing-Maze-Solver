/* This class is responsible for generating random board with all the requirements:
*   - '0' represents a starting point.
*   - '1' represents a path.
*   - '2' represents a reward that multiplies points by 2.
*   - '3' represents the finish line.
*/

import java.util.Random;

public class Generator {
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
                    gameBoard[i][j] = 1; // Free path '1'
                }
            }
        }

        // Set starting and ending point
        gameBoard[0][0] = 1;
        gameBoard[sizeOfBoard - 1][sizeOfBoard - 1] = 3;

        return gameBoard;
    }

   public static int[] generateRandomGameSolution(int[][] matrix) {
        int N = matrix.length;

        // Starting point
        int currentX = 0;
        int currentY = 0;
        
        // Distance and Attempts (used in fitness function later)
        int distance = 0;
        int attempts = 0;
        int pointsGained = 0;

        Random random = new Random();

        while (matrix[currentX][currentY] != 3) {
            attempts++;
            
            // Random move (0: up, 1: right, 2: down, 3: left)
            int directionToMove = random.nextInt(4);
            
            switch (directionToMove) {
                case 0: // up
                    if (currentY > 0 && (matrix[currentX][currentY - 1] == 1 || matrix[currentX][currentY - 1] == 2 || matrix[currentX][currentY - 1] == 3)) {
                        currentY--;
                        distance++;
                        if (matrix[currentX][currentY] == 2) {
                            pointsGained++;
                        }                        
                    }
                    break;
                case 1: // right
                    if (currentX < N - 1 && (matrix[currentX + 1][currentY] == 1 || matrix[currentX + 1][currentY] == 2 || matrix[currentX + 1][currentY] == 3)) {
                        currentX++;
                        distance++;
                        if (matrix[currentX][currentY] == 2) {
                            pointsGained++;
                        }                        
                    }
                    break;
                case 2: // down
                    if (currentY < N - 1 && (matrix[currentX][currentY + 1] == 1 || matrix[currentX][currentY + 1] == 2 || matrix[currentX][currentY + 1] == 3)) {
                        currentY++;
                        distance++;
                        if (matrix[currentX][currentY] == 2) {
                            pointsGained++;
                        }                        
                    }
                    break;
                case 3: // left
                    if (currentX > 0 && (matrix[currentX - 1][currentY] == 1 || matrix[currentX - 1][currentY] == 2 || matrix[currentX - 1][currentY] == 3)) {
                        currentX--;
                        distance++;
                        if (matrix[currentX][currentY] == 2) {
                            pointsGained++;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        int[] result = { distance, attempts, pointsGained };
        return result;
    }
}