/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	4/11/2022
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.util.Scanner;
import java.lang.Math;

public class Knapsack {

	
	public static void main(String args[]) {
		
		int values [] = {7,5,10,15,9,8,4};		// values (how many units of that element)
        int weights [] = {1,1,2,5,3,4,2}; 		// weights (how much each element weights)
        int W = 15;								// knapsack capacity (in units)
        
        int M[][]= knapsack(W,weights,values,values.length);
        
        printKnapsack(values.length,W,M,weights,values);
        
        System.out.println("Knapsack solution: " + M[values.length][W]);
	}
	
	
	/* This is the iterative algorithm for the Knapsack problem
	 * Time complexity: O(n*W)
	 * */
	public static int[][] knapsack(int W, int weights[], int values[], int n) {
		
		int M[][] = new int[n+1][W+1];
		
		// base case
		for(int i=0; i<=n; i++)
			M[i][0] = 0;
		
		// base case
		for(int w=0; w<=W; w++)
			M[0][w] = 0;
		
		// "recursive step"
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
	
	
	// Recursive algorithm to print the solution (with all subproblems)
	public static void printKnapsack (int i, int j, int M[][], int weights[], int values[]){
		
		if(i == 0 || j == 0)
			System.out.println();
		else {
			
			if(weights[i-1] > j)
				printKnapsack(i-1,j,M,weights,values);
			else {
				
				if(M[i-1][j-weights[i-1]] + values[i-1] >= M[i-1][j]) {
					printKnapsack(i-1,j-weights[i-1],M,weights,values);
					System.out.println("Object " + i + "   weight: " + weights[i-1] + "   value: " + values[i-1]);
				}
				else
					printKnapsack(i-1,j,M,weights,values);
			}
		}
		
	}
	
	
}