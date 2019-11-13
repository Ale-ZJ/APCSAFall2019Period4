//Alexandra Zhang Jiang
//October 28th 
//calculator with fractions

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	String operation = "";
    	Scanner userInput = new Scanner(System.in);
    	
    	do {
	    	System.out.print("Operation: ");
	    	operation = userInput.nextLine();
	    	System.out.println(operation);
	    	System.out.println("result: " + produceAnswer(operation));	
    	} while (!operation.equals("quit"));
    	
    	userInput.close(); //close scanner
    }
    
    public static String produceAnswer(String input){ 
    	String[] noSpace = input.split(" ");
    	System.out.println("split on space:" + Arrays.toString(noSpace));				//DELETE for checking purposes
    	int startIdx;
    	int noSpaceSize = noSpace.length;
    	int[] answer = {0,0,0};
    	
    	while (noSpaceSize > 1) {														//do while the array contains one element
    		for (int i = 1; i < noSpaceSize; i += 2) {									//check for the operator
    			String operator = noSpace[i];
    			
        		if (operator.equals("*") || (operator.equals("/"))) {					//mdas
        			startIdx = i - 1; 
        			int[] fraction1 = getFraction(noSpace[startIdx]);
        			int[] fraction2 = getFraction(noSpace[startIdx + 2]);
        			
        			if (operator.equals("*")) {
        	    		multiply(fraction1, fraction2, answer);
        	    		
        	    	} else if (operator.equals("/")) {
        	    		divide(fraction1, fraction2, answer);
        	    	}
        		}
        	}
    	}
    	
    	String operand1 = noSpace[0];
    	String operator = noSpace[1];
    	String operand2 = noSpace[2];
    	int[] answer = {0, 0, 0};
    	
    	int whole1 = getWhole(operand1);
    	int num1 = getNum(operand1);
    	int den1 = getDen(operand1);
    	
    	int[] fraction1 = toImproperFrac(whole1, num1, den1);
    	
    	int whole2 = getWhole(operand2);
    	int num2 = getNum(operand2);
    	int den2 = getDen(operand2);
    	
    	int[] fraction2 = toImproperFrac(whole2, num2, den2);
    	
    	else if (operator.equals("+")) {
    		addition(fraction1, fraction2, answer);
    	}else if (operator.equals("-")) {
    		fraction2[1] *= -1;
    		addition(fraction1, fraction2, answer);
    	}
    	
    	return toMixedFrac(answer);
    }

    //Parsing method
    
    public static int getFraction(String frac) {
    	int
    }
    public static int getWhole(String frac) {
    	if(frac.contains("/")) {	//mixed num
    		if(frac.contains("_")) {
        		return Integer.parseInt(frac.substring(0, frac.indexOf("_")));
    		}
    		return 0;
    	}
    	return Integer.parseInt(frac); //fraction and there is no mixed num
    }
    
    public static int getNum(String frac) {
    	if(frac.contains("/")) {
    		return Integer.parseInt(frac.substring(frac.indexOf("_") + 1, frac.indexOf("/")));
    	} else { //whole num
    		return 0;
    	}
    }
    
    public static int getDen(String frac) {
    	if(frac.contains("/")) {
    		return Integer.parseInt(frac.substring(frac.indexOf("/") + 1));
    	} else { //whole num
    		return 1;
    	}
    }
    
    
    
    //Methods that perform operations 
    //CHECK -3_3/4, -, -2_2/4
    
    public static void multiply(int[] fraction1, int[] fraction2, int[] answer) {
    	System.out.println("Frac1" + Arrays.toString(fraction1));
    	System.out.println("Frac2" + Arrays.toString(fraction2));
    	answer[1] = fraction1[1] * fraction2[1];
    	answer[2] = fraction1[2] * fraction2[2];
    }
    
    public static void divide(int[] fraction1, int[] fraction2, int[] answer) {
    	reciprocal(fraction2);
    	multiply(fraction1, fraction2, answer);
    }
    
    public static void reciprocal(int[] frac) {
    	int newDen = frac[1];
    	frac[1] = frac[2];
    	frac[2] = Math.abs(newDen);
    	if (newDen < 0) {
    		frac[1] *= -1;
    	}
    }
    
    public static void addition(int[] fraction1, int[] fraction2, int[] answer) {
//    	int lcmNum = lcm(fraction1[2], fraction2[2]);
    	answer[1] = (fraction2[2] * fraction1[1]) + (fraction1[2] * fraction2[1]);
    	answer[2] = fraction1[2] * fraction2[2];
    }
    
    
    
    public static int lcm(int num1, int num2) {
    	int gcfNum = gcf(num1, num2);
    	return num1 * num2 / gcfNum;
    }
    
    //a call to find the greatest common between two numbers
  	public static int gcf(int num1, int num2) {
  		int minNum = Math.min(Math.abs(num1), Math.abs(num2)); 
  		int factor = 1;                   			//if they don't share any factor then the factor is 1
  		if (minNum == 0) {
  			factor = Math.max(Math.abs(num1), Math.abs(num2));
  		}
  		for (int i = 1; i <= minNum; i++) {			//not necessary to check on all numbers
  			if (isDivisibleBy(num1, i) == true && isDivisibleBy(num2, i) == true) { //store COMMON factor
  				factor = i;
  			}
  		}
  		return factor;
  	}
  	
  //a call to determine if one integer is divisible by another
  	public static boolean isDivisibleBy(int dividend, int divisor) {
  		if (divisor == 0) {
  			throw new IllegalArgumentException("division by zero is undefined, denominator" + divisor);
  		}
  		if (dividend % divisor == 0) {
  			return true; //it is divisible
  		} else { 
  			return false; 
  		}
  	}
  	
  	//convert fraction to improper
  	public static int[] toImproperFrac(int whole, int num, int denominator) {
	int wholePositive =  Math.abs(whole);
	int newNum = ( denominator * wholePositive ) + num;
	if (whole < 0) {
		newNum = newNum * -1;
	}
	int[] improper = {0, newNum, denominator};
	return improper;
}

	public static String toMixedFrac(int[] answer) {
  		simplify(answer);
  		System.out.println("Answer array:" + Arrays.toString(answer));				//DELETE
  		int num = answer[1];
  		int den = answer[2];
  		int wholeNum = num / den;	//int divided by another int cast decimals
		int newNum = num % den; 
		
		if (newNum == 0) {			//no fraction
			return "" + wholeNum;
		} else if (wholeNum == 0) {
			return newNum + "/" + den;
		} else {
		return wholeNum + "_" + Math.abs(newNum) + "/" + den;
		}
  	}
  	
  	public static void simplify(int[] frac) {
  		int gcfNum = gcf(frac[1], frac[2]);
  		frac[1] = frac[1] / gcfNum;
  		frac[2] = frac[2] / gcfNum;
  	}
  	
//  	public static boolean checkInput(String input) {
//  		for (int {
//  			if (element.contains(s))
//  		}
//  	}
  	
  	//to replace answer in array 
  	//preconditions idx tells where the operation starts
//  	public static void replace(String[] equation, String answer, int idx) {
//  		int arrSize = equation.length;
//  		String[] beforeIdx = Arrays.copyOfRange(equation, 0, idx);
//  		String[] afterIdx = Arrays.copyOfRange(equation, idx + 2, arrSize);
//  		String[] removedArray = new int[beforeIdx.length + afterIdx.length]
//  		
//  		
//  	}
//  	
//	//array of integers consisting of all of the elements of arr except for the element at index idx
//	//You can assume arr has at least two elements.
//	public static int[] remove(int[] arr, int idx) {
//		int arrSize = arr.length;
//		int[] beforeIdx = Arrays.copyOfRange(arr, 0, idx);					//array of elements before the idx
//		int[] afterIdx = Arrays.copyOfRange(arr, idx + 1, arrSize);			//array of elements after
//		int[] removedArray = new int[beforeIdx.length + afterIdx.length];
//		
//		int index = 0;
//		
//		for (int element : beforeIdx) {			//store elements 
//			removedArray[index] = element;
//			index++;
//		}
//		
//		for (int element : afterIdx) {
//			removedArray[index] = element;
//			index++;
//		}
//		
//		return removedArray;
//	}
}
