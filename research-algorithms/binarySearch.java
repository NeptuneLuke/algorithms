/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	25/5/2021
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/

import java.util.Scanner;
import java.util.Arrays;

public class binarySearch {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int A[] = new int[5];
		for(int i=0; i<A.length; i++) {
			System.out.println("Insert number: ");
			A[i] = keyboard.nextInt();
		}
		System.out.println();
		
		//binarySearch works only if the array is sorted
		Arrays.sort(A);
		
		System.out.println(Arrays.toString(A));
		
		System.out.println("Insert the number to search: ");
		int k = keyboard.nextInt();
		
		boolean found = binarySearch(A,k);
		if(!found)
			System.out.println("Number not found!");
		else
			System.out.println("Number found!");
	}

	
	public static boolean binarySearch(int A[], int k) {
		
		int start = 0;
		int end = A.length-1;
		int mid = (start+end)/2;
		
		while(A[mid] != k && start < end) {
			
			if(A[mid] > k)
				end = mid - 1;
			else
				start = mid + 1;
			
			mid = (start+end)/2;
		}
		
		if(A[mid] == k)
			return true;
		else
			return false;
	}
	
	
	public static boolean recursiveBinarySearch(int[] A, int k, int start, int end){
		
		//base case -> array is empty
		if (start > end)
			return false;
		
		int mid = (start+end)/2;
		
		//final step -> found k
		if (A[mid] == k)
			return true;
		
		//recursive step -> on the two halves of the array
		if (A[mid] > k)
			return recursiveBinarySearch(A,k,start,mid-1);
		else
			return recursiveBinarySearch(A,k,mid+1,end);
	}
	
	
}