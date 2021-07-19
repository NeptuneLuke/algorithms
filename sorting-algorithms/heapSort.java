/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
* @version 	1.0
* @since	19/7/2021
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/

import java.util.Scanner;
import java.util.Arrays;

public class heapSort {


	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int myArray[] = new int[5];
		for(int i=0; i<myArray.length; i++) {
			System.out.println("Insert number: ");
			myArray[i] = keyboard.nextInt();
		}
		System.out.println();
		
		heapSort(myArray);
		
		System.out.println(Arrays.toString(myArray));
	}

	//the actual algorithm of heapSort
	public static void heapSort(int myArray[]) {
		
		buildheap(myArray);
		int heapsize = myArray.length-1;
		
		for(int i=heapsize; i>0; i--) {
			swap(myArray,0,i);
			heapsize--;
			heapify(myArray,0,heapsize);
		}
	}
	
	//the actual function that make heap
	public static void heapify(int myArray[], int k, int size) {
		
		int largest = k;
		int left = (2*k)+1;
		int right = (2*k)+2;
		
		if (left <= size && myArray[left] > myArray[largest])
	        largest = left;
		
		if (right <= size && myArray[right] > myArray[largest])
	        largest = right;
		
		
		if (largest != k) {
	        swap(myArray,k,largest);
	        heapify(myArray,largest,size);
	    }
		
	}
	
	//build the heap starting from an array (maxHeap)
	public static void buildheap(int myArray[]) {
		
		for(int i=(myArray.length/2)-1; i>=0; i--)
			heapify(myArray,i,myArray.length-1);
	}
	
	public static void swap(int myArray[], int a, int b) {
		
		int temp = myArray[a];
	    myArray[a] = myArray[b];
	    myArray[b] = temp;
	}
	
	
}