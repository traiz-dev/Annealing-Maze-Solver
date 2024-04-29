/*
 * The Fitness class provides methods for evaluating the fitness of a solution
 * to a maze-solving problem. It includes a fitness function that calculates
 * the fitness score of a solution based on various criteria such as path length
 * and reward collection.
*/

import java.util.ArrayList;
// import java.util.Arrays;

public class Fitness {
    // public static void main(String[] args) {
    //     System.out.println("GENERATED BOARD: ");
    //     int[][] matrix = Generator.generateRandomGameBoard(10);
    //     System.out.println(Arrays.deepToString(matrix));
    //     System.out.println("BOARD SIZE: " + matrix.length*matrix.length);

    //     System.out.println("-------------------------------------------");

    //     System.out.println("SOLUTION: ");
    //     ArrayList<Integer> solution = Generator.generateRandomGameSolution(matrix);
    //     System.out.println(solution);
    //     System.out.println("SOLUTION LENGTH: " + solution.size());

    //     System.out.println("-------------------------------------------");

    //     System.err.println("FITNESS: " + fitnessFunction(solution, matrix));
    // }

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
        fitness = (double) (gameBoard.length * gameBoard.length) / (pathLength + 1); // Normalize path length
        fitness *= (2 + rewardCount); // Encourage collecting rewards

        return fitness;
    }
}
