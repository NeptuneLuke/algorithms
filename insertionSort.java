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

public class insertionSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		insertionSort(myArray);
		
		System.out.println(Arrays.toString(myArray));
	}

	
	public static void insertionSort(int myArray[]) {
		
		for(int i=1; i<myArray.length; i++) {
			
			int tmp = myArray[i];
			int j = i-1;
			while(j>=0 && myArray[j] > tmp) {
				myArray[j+1] = myArray[j];
				j--;
			}
			
			myArray[j+1] = tmp;
		}
		
	}
	
	
}