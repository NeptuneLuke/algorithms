/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @since	21/01/2024
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.util.Scanner;

public class EditDistance {

	
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Insert first string: ");
		String X = keyboard.next();
		
		System.out.println("Insert second string: ");
		String Y = keyboard.next();
		
		
		System.out.println("Edit distance of " + X + " and " + Y + " is " + editDistance(X,Y));
		
	}
	
	
	public static int editDistance(String X, String Y) {
		
		int m = X.length();
		int n = Y.length();
		
		int edit_distance[][] = new int[m+1][n+1];
		
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
		
				// base case i==0
				if (i == 0) {
					edit_distance[i][j] = j;
				}
				// base case j==0
				else if (j == 0) {
					edit_distance[i][j] = i;
				}
				else {
				    if (X.charAt(i-1) == Y.charAt(j-1)) {
				    	edit_distance[i][j] = edit_distance[i-1][j-1];
				    }
				    else {
				    	edit_distance[i][j] = 1 + Math.min(Math.min(edit_distance[i-1][j], edit_distance[i][j-1]), edit_distance[i-1][j-1]);
				    }
				}
					
			}
		}
		
		return edit_distance[m][n];
	}
	
	
}