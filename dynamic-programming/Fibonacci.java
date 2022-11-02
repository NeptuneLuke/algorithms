/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	2/11/2022
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/


import java.util.Scanner;
import java.util.Arrays;	

public class Fibonacci {

	
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Insert the nth number of Fibonacci: ");
		int n = keyboard.nextInt();
		
		int fib [] = fibonacci_iter(n);
		System.out.println("Fibonacci sequence: ");
		System.out.println(Arrays.toString(fib));
		
		int fib_num = fibonacci_rec(n);
		System.out.println("Fibonacci recursive: " + fib_num);	
	}
	
	
	/* This is an iterative algorithm of Fibonacci sequence
	 * Time complexity: O(n)
	 */
	public static int[] fibonacci_iter(int n) {
	
		int A[] = new int [n+1];
		A[0] = 0;
		A[1] = 1;
		for(int i=2; i<=n; i++)
			A[i] = A[i-1] + A[i-2];
		
		return A;
	}
	
	
	/* This is the recursive algorithm for nth Fibonacci number
	 * Time complexity: O( ((1-sqrt(5))/2 )^n ) exponential
	 */
	public static int fibonacci_rec(int n) {
		
		if(n<=1)
			return n;
		else
			return fibonacci_rec(n-1) + fibonacci_rec(n-2);
	}
	
}
