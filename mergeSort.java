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

public class mergeSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		mergeSort(myArray,0,myArray.length-1);
		
		System.out.println(Arrays.toString(myArray));
	}

	
	public static void mergeSort(int myArray[], int start, int end) {
		
		if(start < end) {
			
			int mid = (start+end)/2;
			mergeSort(myArray,start,mid);	//sort the first half
			mergeSort(myArray,mid+1,end);	//sort the second half
			merge(myArray,start,mid,end);	//merge the two halves of the array
		}
		
	}
	
	public static void merge(int myArray[], int start, int mid, int end) {
		
		int i = start, j = mid+1, k = start;
		
		int[] temp = new int[myArray.length];
		
		while(i <= mid && j <= end) {
			if(myArray[i] <= myArray[j]) {
				temp[k] = myArray[i];
				k++;
				i++;
			}
			else {
				temp[k] = myArray[j];
				k++;
				j++;
			}
		}
		
		while(i <= mid) {
			temp[k] = myArray[i];
			k++;
			i++;
		}
		
		while(j <= end) {
			temp[k] = myArray[j];
			k++;
			j++;
		}
		
		k = start;
		while(k <= end) {
			myArray[k] = temp[k];
			k++;
		}
		
	}
	
	
}