/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version	1.0
* @since	9/11/2022
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.util.Scanner;

public class Interleaving {

	
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Insert first sequence: ");
		String X = keyboard.next();
		
		System.out.println("Insert second sequence: ");
		String Y = keyboard.next();
	
		System.out.println("Insert interleaving sequence: ");
		String W = keyboard.next();
		
		System.out.println("Is " + W + " interleaving of " + X + " " + Y + " --> " + isInterleave(X,Y,W));
		
	}
	
	
	/* Iterative algorithm that fills matrix S with the solutions of all subproblems (Xi,Yj,Wi+j)
	 * Time complexity: O(m*n) 
	 */
	public static boolean isInterleave(String X, String Y, String W) {
		
		int m = X.length();
		int n = Y.length();
		
		boolean S[][] = new boolean[m+1][n+1];
		
		// by definition if W is interleaving of X,Y
		// W.length() == X.length() + Y.length()
		if ((m+n) != W.length())
			return false;
		
		// W.charAt(i+j-1) current char of W
		// X.charAt(i-1) current char of X
		// Y.charAt(j-1) current char of Y
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
		
				if(i == 0 && j == 0)		// base case
					S[i][j] = true;
				
				else if(i == 0 && j > 0) {	// base case
					
					if(W.charAt(i+j-1) == Y.charAt(j-1))
						S[i][j] = S[i][j-1];
					else
						S[i][j] = false;
				}
				else if(j == 0 && i > 0) {	// base case
					
					if(W.charAt(i+j-1) == X.charAt(i-1))
						S[i][j] = S[i-1][j];
					else
						S[i][j] = false;
				}
				
				// "recursive step" (i,j) > 0
				else {
					
					if(W.charAt(i+j-1) != X.charAt(i-1) && W.charAt(i+j-1) != Y.charAt(j-1))		// W(i+j) != X(i) AND W(i+j) != Y(j)
						S[i][j] = false;
					else if(W.charAt(i+j-1) == X.charAt(i-1) && W.charAt(i+j-1) != Y.charAt(j-1))	// W(i+j) == X(i) AND W(i+j) != Y(j)
						S[i][j] = S[i-1][j];
					else if(W.charAt(i+j-1) != X.charAt(i-1) && W.charAt(i+j-1) == Y.charAt(j-1))	// W(i+j) != X(i) AND W(i+j) == Y(j)
						S[i][j] = S[i][j-1];
					else if(W.charAt(i+j-1) == X.charAt(i-1) && W.charAt(i+j-1) == Y.charAt(j-1))	// W(i+j) == X(i) AND W(i+j) == Y(j)
						S[i][j] = S[i-1][j] || S[i][j-1];
				}
					
			}
		}
		
		return S[m][n];
	}
	
	
}
