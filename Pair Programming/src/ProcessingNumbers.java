// Alexandra Zhang Jiang
// 10-02-2019
// Pair Programming assignment 
// to process some numbers and apply cumulative algorithm until user tells to stop

import java.util.*;

public class ProcessingNumbers {

	public static void main(String[] args) {
		//declare variables
		Scanner input = new Scanner(System.in);
		boolean cont = true;
		int sumEven, min, max, maxEven;
		sumEven =  min = max = maxEven = 0;
		int i = 1;									//index for user to keep track of how many numbers they type
		String evenAns = "\nNo even numbers";		//default as no evens until you find one
		
		System.out.println("Enter the list of numbers you want me to process OwO)/ \n(enter any letter when done)");
		
		//make sure that every input is a integer
		while (cont == true) {						
			System.out.print("#"+ i + " = ");
			if (input.hasNextInt()) {				//if the user input is a number then continue 
				int num = input.nextInt();			//get number
				//set first number for comparison
				if (i==1) {							
					min = num;
					max = num;
					if (num % 2 == 0) maxEven = num;
					else maxEven = num - 1;
				}
				//process numbers
				if (num < min) min = num;
				if (num > max ) max = num;
				if (num % 2 == 0) {
					sumEven += num;
					if (num > maxEven) maxEven = num;
					evenAns = "\nSum of even numbers: " + sumEven + "\nMaximum even number: " + maxEven;
				}
				i++; 								//next index
			}else { 								//if input is not a number
				System.out.println("Finished!");
				cont = false;						//exit loop to process num when user says no
			}	
		}
		System.out.print("\nMaximum: " + max + "\nMinimum: " + min + evenAns);
	}

}
