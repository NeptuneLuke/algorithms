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

public class selectionSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		selectionSort(myArray);
		
		System.out.println(Arrays.toString(myArray));
	}

	
	public static void selectionSort(int myArray[]) {
		
		for(int i=0; i<myArray.length-1; i++) {
			
			int min = i;
			for(int j=i+1; j<myArray.length; j++) {
				
				if(myArray[j] < myArray[min])
					min = j;
			}
			
			swap(myArray,i,min);
		}
		
	}
	
	public static void swap(int myArray[], int a, int b) {
		
		int temp = myArray[a];
	    myArray[a] = myArray[b];
	    myArray[b] = temp;
	}
	
	
}