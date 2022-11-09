/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	9/11/2022
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.lang.Math;

public class Knapsack {

	
	public static void main(String args[]) {
		
	int values [] = {7,5,10,15,9,8,4};		// values (how many units of that element)
        int weights [] = {1,1,2,5,3,4,2}; 		// weights (how much each element weights)
        int W = 15;					// knapsack capacity
        
        int M[][] = knapsack(values.length,W,values,weights);
        
        printKnapsack(values.length,W,M,weights,values);
        
        System.out.println("Knapsack solution: " + M[values.length][W]);
	}
	
	
	/* Iterative algorithm for the Knapsack problem
	 * Time complexity: O(n*W)
	 * */
	public static int[][] knapsack(int n, int W, int values[], int weights[]) {
		
		int M[][] = new int[n+1][W+1];
		
		// base case
		for(int i=0; i<=n; i++)
			M[i][0] = 0;
		
		// base case
		for(int w=0; w<=W; w++)
			M[0][w] = 0;
		
		// "recursive step" (i,j) > 0
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=W; j++) {
				
				if(weights[i-1] > j)
					M[i][j] = M[i-1][j];
				else
					M[i][j] = Math.max(M[i-1][j], M[i-1][j-weights[i-1]] + values[i-1]);
			}
		}
		
		return M;
	}
	
	
	// Recursive algorithm to print the solution (with all subproblems  (i,c) )
	public static void printKnapsack (int i, int c, int M[][], int weights[], int values[]){
		
		// i --> object of index i
		// c --> remaining capacity of the knapsack
		// M --> matrix of the lengths of all solutions
		
		if(i == 0 || c == 0)
			System.out.println();
		else {
			
			if(weights[i-1] > c)
				printKnapsack(i-1,c,M,weights,values);
			else {
				
				if(M[i-1][c-weights[i-1]] + values[i-1] >= M[i-1][c]) {
					printKnapsack(i-1,c-weights[i-1],M,weights,values);
					System.out.println("Object " + i + "   weight: " + weights[i-1] + "   value: " + values[i-1]);
				}
				else
					printKnapsack(i-1,c,M,weights,values);
			}
		}
		
	}
	
	
}
