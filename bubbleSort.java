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

public class bubbleSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		bubbleSort(myArray);
		
		System.out.println(Arrays.toString(myArray));
	}


	public static void bubbleSort(int myArray[]) {
		
		boolean swap = true;
		
		while(swap) {
			swap = false;
			for(int i=0; i<myArray.length-1; i++) {
				
				if(myArray[i] > myArray[i+1]) {
					
					int app = myArray[i];
					myArray[i] = myArray[i+1];
					myArray[i+1] = app;
					swap = true;
				}
			}
		}
		
	}


}