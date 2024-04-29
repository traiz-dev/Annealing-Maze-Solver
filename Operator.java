import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Random;

public class Operator {
    // public static void main(String[] args) {
    //     int[][] matrix = Generator.generateRandomGameBoard(2);
    //     System.out.println(Arrays.deepToString(matrix));
    //     ArrayList<Integer> solution = Generator.generateRandomGameSolution(matrix);
    //     System.out.println("INITIAL SOLUTION: " + solution);
    //     System.out.println("SMALL CHANGE: " + smallChangeOperator(solution, matrix));
    // }

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
