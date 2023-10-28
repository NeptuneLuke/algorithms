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
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		//binarySearch works only if the array is sorted
		Arrays.sort(myArray);
		
		System.out.println(Arrays.toString(myArray));
		
		System.out.println("Insert the number to search: ");
		int k = keyboard.nextInt();
		
		boolean found = binarySearch(myArray,k);
		if(!found)
			System.out.println("Number not found!");
		else
			System.out.println("Number found!");
	}

	
	public static boolean binarySearch(int myArray[], int k) {
		
		int start = 0;
		int end = myArray.length-1;
		int mid = (start+end)/2;
		
		while(myArray[mid] != k && start < end) {
			
			if(myArray[mid] > k)
				end = mid - 1;
			else
				start = mid + 1;
			
			mid = (start+end)/2;
		}
		
		if(myArray[mid] == k)
			return true;
		else
			return false;
	}
	
	
	public static boolean recursiveBinarySearch(int myArray[], int k, int start, int end){
		
		//base case -> array is empty
		if (start > end)
			return false;
		
		int mid = (start+end)/2;
		
		//final step -> found k
		if (myArray[mid] == k)
			return true;
		
		//recursive step -> on the two halves of the array
		if (myArray[mid] > k)
			return recursiveBinarySearch(myArray,k,start,mid-1);
		else
			return recursiveBinarySearch(myArray,k,mid+1,end);
	}
	
	
}
