/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	12/11/2022
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.util.Scanner;
import java.lang.Math;

public class LongestCommonSubsequence {

	
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Insert first sequence: ");
		String X = keyboard.next();
		int m = X.length();
		
		System.out.println("Insert second sequence: ");
		String Y = keyboard.next();
		int n = Y.length();
		
		int myMatrix[][] = LCS_length(X,Y);
		
		String lcs = LCS_backtrack(X,Y,m,n,myMatrix);
		
		System.out.println("LCS between X,Y: " + lcs);
	}
	
	
	/* LCS algorithm for two generic sequences, this function calculates the length of the/a LCS between X,Y
	 * if i need to find the LCS for n sequences, just build the LCS from the first two, then find the LCS between that and the third
	 * and go on... */
	public static int[][] LCS_length(String X, String Y) {
		
		int m = X.length();
		int n = Y.length();
		int C[][] = new int [m+1][n+1]; 	// matrix of the lengths of LCS 
		
		// base case -> sol: blank string
		for(int i=0; i<=m; i++)
			C[i][0] = 0;
		
		// base case -> sol: blank string
		for(int j=0; j<=n; j++)
			C[0][j] = 0;
		
		// "recursive" step
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
				if(X.charAt(i-1) == Y.charAt(j-1))		// charAt(index-1) because Strings start at 0
					C[i][j] = C[i-1][j-1] + 1;
				else
					C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
			}
		}
		
		return C;
	}
	
	/* LCS_backtrack builds the actual LCS
	 * this type of algorithm builds only one possible LCS (it can be more than one) */
	public static String LCS_backtrack(String X, String Y,int i, int j, int C[][]) {
		
		if(i==0 || j==0)
			return "";
		
		else {
			
			// if X,Y end with the same symbol go diagonal
			if(X.charAt(i-1) == Y.charAt(j-1))
				return LCS_backtrack(X,Y,i-1,j-1,C) + X.charAt(i-1);
			
			else {
				
				// if up > left then go up
				if(C[i-1][j] >= C[i][j-1])
					return LCS_backtrack(X,Y,i-1,j,C);
				
				else	// else go left 
					return LCS_backtrack(X,Y,i,j-1,C);
				
				
				/* this method finds another possible LCS
				 * 
				 * // if left > up then go left
				 * if(C[i][j-1] >= C[i-1][j])
						return LCS_backtrack(X,Y,i,j-1,C);
				   else		// else go up
						return LCS_backtrack(X,Y,i-1,j,C); 
				 */
			}
		}
		
	}
	
	
}
