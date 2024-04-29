/*
 * The Fitness class provides methods for evaluating the fitness of a solution
 * to a maze-solving problem. It includes a fitness function that calculates
 * the fitness score of a solution based on various criteria such as path length
 * and reward collection.
*/
import java.util.ArrayList;

public class Fitness {
    public static double fitnessFunction(ArrayList<Integer> solution, int[][] gameBoard) {
        int pathLength = solution.size();
        int rewardCount = 0;
        boolean[][] rewardsCollected = new boolean[gameBoard.length][gameBoard.length]; // Track collected rewards
        double fitness = 0.0;

        // Traverse the solution to calculate fitness
        int currentX = 0;
        int currentY = 0;
        for (Integer move : solution) {
            switch (move) {
                case 0: // up
                    currentY--;
                    break;
                case 1: // right
                    currentX++;
                    break;
                case 2: // down
                    currentY++;
                    break;
                case 3: // left
                    currentX--;
                    break;
                default:
                    break;
            }

            // Check if the move collects a reward
            if (gameBoard[currentX][currentY] == 2 && !rewardsCollected[currentX][currentY]) {
                rewardCount++;
                rewardsCollected[currentX][currentY] = true; // Mark the reward as collected
            }
        }

        // Calculate fitness based on path length and reward count
        fitness = (double) (gameBoard.length * gameBoard.length) / (pathLength + 1); // Normalise path length
        fitness *= (2 * rewardCount); // Encourage collecting rewards

        return fitness;
    }

    public static int countCollectedRewards(ArrayList<Integer> solution, int[][] gameBoard) {
        int rewardCount = 0;
        boolean[][] rewardsCollected = new boolean[gameBoard.length][gameBoard.length]; // Track collected rewards

        // Traverse the solution to count collected rewards
        int currentX = 0;
        int currentY = 0;
        for (Integer move : solution) {
            switch (move) {
                case 0: // up
                    currentY--;
                    break;
                case 1: // right
                    currentX++;
                    break;
                case 2: // down
                    currentY++;
                    break;
                case 3: // left
                    currentX--;
                    break;
                default:
                    break;
            }

            // Check if the move collects a reward
            if (gameBoard[currentX][currentY] == 2 && !rewardsCollected[currentX][currentY]) {
                rewardCount++;
                rewardsCollected[currentX][currentY] = true; // Mark the reward as collected
            }
        }
        return rewardCount;
    }
}
