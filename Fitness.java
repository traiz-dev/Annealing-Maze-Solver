/*
 * 
 */

public class Fitness {
    public static void main(String[] args) {
        int[][] matrix = Generator.generateRandomGameBoard(5);
        int[] solution = Generator.generateRandomGameSolution(matrix);

        System.out.println(fitnessFunction(solution));
    }

    public static double fitnessFunction(int[] solution) {
        int distance = solution[0];
        int attempts = solution[1];
        int pointsGained = solution[2];

        // Defining weights for each component
        double distanceWeight = 1.0;
        double attemptsWeight = -0.5; // Penalising more attempts
        double pointsWeight = 0.3; // Encouraging gaining points

        // Calculate fitness
        double fitness = distanceWeight * distance + attemptsWeight * attempts + pointsWeight * pointsGained;
        
        return fitness;
    }
}
