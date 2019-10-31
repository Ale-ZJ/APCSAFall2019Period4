//Alexandra Zhang Jiang 
//October 24, 2019
//Practice Array with a 3rd project!

import java.util.Arrays;

public class ArrayLab3 {

	public static void main(String[] args) {
		//initialize variables
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		
		int appendNum = 200; 
		int removeIdx = 5;
		
		int[] sumArr = sum(a1, a2);
		int[] appendArr = append(a1, appendNum);
		int[] removeArr = remove(a2, removeIdx);
		
		int sumOfEvens = 0;
		sumOfEvens = sumEven(appendArr);
		
		rotateRight(a1);
		
		//print results
		System.out.println("Sum of a1 & a2: " + Arrays.toString(sumArr));
		System.out.println("Appended array: " + Arrays.toString(appendArr));
		System.out.println("Shortened array: " + Arrays.toString(removeArr));
		System.out.println("Sum of Evens in appended array: " + sumOfEvens);
		System.out.println("Rotated array a1: " + Arrays.toString(a1));
	}
	
	//every element is the sum of the elements at that index for the arrays arr1 and arr2. 
	//arr1 and arr2 have at least one element and are the same length.
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] sumArray = new int[arr1.length];
		for (int i = 0; i < sumArray.length; i++) {
			sumArray[i] = arr1[i] + arr2[i];
		}
		return sumArray;
	}

	//Gives an array with num appended at the end of arr.  
	//Assume array arr has at least one element.
	public static int[] append(int[] arr, int num) {
		int arrSize = arr.length;
		int[] appendedArray = Arrays.copyOf(arr, arrSize + 1);
		appendedArray[arrSize] = num;
		return appendedArray;
	}
	
	//array of integers consisting of all of the elements of arr except for the element at index idx
	//You can assume arr has at least two elements.
	public static int[] remove(int[] arr, int idx) {
		int arrSize = arr.length;
		int[] beforeIdx = Arrays.copyOfRange(arr, 0, idx);					//array of elements before the idx
		int[] afterIdx = Arrays.copyOfRange(arr, idx + 1, arrSize);			//array of elements after
		int[] removedArray = new int[beforeIdx.length + afterIdx.length];
		
		int index = 0;
		
		for (int element : beforeIdx) {			//store elements 
			removedArray[index] = element;
			index++;
		}
		
		for (int element : afterIdx) {
			removedArray[index] = element;
			index++;
		}
		
		return removedArray;
	}
	
	//returns an integer containing the sum of the elements at the even indices of arr.  
	//You can assume arr has at least one element.
	public static int sumEven(int[] arr) {
		int evenSum = 0;
		for (int i = 0; i < arr.length; i += 2) {
			evenSum += arr[i];
		}
		return evenSum;
	}
	
	//The rotateRight method moves each element of arr one index to the right (element 0 goes to element 1, element 1 goes to element 2, …, element n-1 goes to element 0).  
	//You can assume arr has at least one element.
	public static void rotateRight(int[] arr) {
		int lastElement = arr[arr.length - 1];			//stores temporarily last element
		for (int i = arr.length - 1; i > 0; i--) {		//last index will store previous element
			arr[i] = arr[i - 1];
		}
		arr[0] = lastElement;
	}

}
