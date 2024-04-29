/*
 * This class defines an operator for making small changes to a solution.
 * It contains a method to generate a new solution different from the original one.
 */
import java.util.ArrayList;

public class Operator {
    public static ArrayList<Integer> smallChangeOperator(ArrayList<Integer> solution, int[][] matrix) {
        // Regenerate a new solution
        ArrayList<Integer> newSolution = Generator.generateRandomGameSolution(matrix);
        
        // Ensure the new solution is different from the original solution
        while (newSolution.equals(solution)) {
            newSolution = Generator.generateRandomGameSolution(matrix);
        }

        // Return the new solution
        return newSolution;
    }
}
