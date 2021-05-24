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

public class countingSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		countingSort(myArray);
		
		System.out.println(Arrays.toString(myArray));
	}

	
	public static void countingSort(int myArray[]) {
		
		int [] output = new int[myArray.length+1];
		
		int max = getMax(myArray);
		int range = max+1;
		
		//range of the values of array myArray
		int [] count = new int[range];
		
		//it's not indispensable, it depends by the programming language
		//choosen for implementing countingSort
		for(int i=0; i<max; ++i) {
			count[i] = 0;
		}
		
		//count the number of times each element appear
		int posMyArray = 0;
		for(int i=0; i<myArray.length; i++) {
			count[myArray[i]]++;
		}
		
		//each element stores (element at current index+element
		//at previous index) to get the actual position of the element
		for(int i=1; i<range; i++) {
			count[i] += count[i-1];
		}
		
		int posOutput = 0;
		int posCount = 0;
		//for correct placement of elements
		for(int i=myArray.length-1; i>=0; i--) {
			posCount = myArray[i];
			posOutput = count[posCount]-1;
			output[posOutput] = myArray[i];
			count[posCount]--;
		}
		
		//because so far the algorithm actually ordered array output
		for(int i=0; i<myArray.length; i++) {
			myArray[i] = output[i];
		}
		
	}


	public static int getMax(int myArray[]){
		
		int max = myArray[0];
		for(int i=0; i<myArray.length; i++) {
			if(myArray[i] > max)
				max = myArray[i];
		}
		
		return max;
	}
	
	
}