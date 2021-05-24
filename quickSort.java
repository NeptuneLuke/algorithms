/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	24/5/2021
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/

import java.util.Scanner;
import java.util.Arrays;

public class quickSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		quickSort(myArray,0,myArray.length-1);
		
		System.out.println(Arrays.toString(myArray));
	}
	
	
	public static void quickSort(int myArray[], int start, int end) {
		
		if(start < end) {
			
			int mid = partition(myArray,start,end);
			quickSort(myArray,start,mid-1);		//sort the first half
			quickSort(myArray,mid+1,end);		//sort the second half
		}
		
	}
	
	
	public static int partition(int myArray[], int left, int right) {

		int pivot = myArray[right];
	    int i = left-1;
	 
	    for(int current=left; current<right; current++) {
	         
	        if (myArray[current] <= pivot) {
	            i++;
	            swap(myArray,i,current);
	        }
	    }
	    swap(myArray,i+1,right);
        
	    return i+1;
	}
	
	
	public static void swap(int myArray[], int a, int b) {
		
		int temp = myArray[a];
	    myArray[a] = myArray[b];
	    myArray[b] = temp;
	}
	
	
}