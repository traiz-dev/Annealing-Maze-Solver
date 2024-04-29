import java.util.ArrayList;
import java.util.Arrays;

public class SimulatedAnnealing {
    // Global variables
    public static double Temperature = 10000;
    static final double minTemperature = 0.0001;
    static final double alpha = 0.8;
    static final int numIterations = 100;
    public static int currentIteration = 0;

    public static void main(String[] args) {
        int[][] matrix = Generator.generateRandomGameBoard(100);
        // System.out.println("BOARD: " + Arrays.deepToString(matrix));
        ArrayList<Integer> solution = simulatedAnnealing(matrix);
        System.out.println("MOST OPTIMAL SOLUTION SIZE: " + solution.size());
    }

    public static ArrayList<Integer> simulatedAnnealing(int[][] gameBoard) {
        ArrayList<Integer> currentSolution = Generator.generateRandomGameSolution(gameBoard);
        double currentFitness = Fitness.fitnessFunction(currentSolution, gameBoard);

        while (Temperature > minTemperature) {
            for (int i = 0; i < numIterations; i++) {
                currentIteration++;
                ArrayList<Integer> newSolution = Operator.smallChangeOperator(currentSolution, gameBoard);
                double newFitness = Fitness.fitnessFunction(newSolution, gameBoard);

                double deltaFitness = newFitness - currentFitness;
                if (deltaFitness > 0 || Math.exp(deltaFitness / Temperature) > Math.random()) {
                    currentSolution = newSolution;
                    currentFitness = newFitness;
                    System.out.println("ITERATION: " + currentIteration);
                    System.out.println("CURRENT TEMPERATURE: " + Temperature);
                    System.out.println("NEW SOLUTION SIZE: " + currentSolution.size()); // Print new solution size (For smaller boards can print board: System.out.println("NEW SOLUTION: " + currentSolution);
                    System.out.println("---------------------------------------------------------");
                    try {
                        Thread.sleep(100); // 100-ms delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Temperature *= alpha; // Update temperature
        }

        return currentSolution;
    }
}
