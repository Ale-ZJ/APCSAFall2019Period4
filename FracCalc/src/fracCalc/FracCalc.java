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

    }
    
    public static String produceAnswer(String input){ 
    	String[] noSpace = input.split(" ");
    	System.out.println(Arrays.toString(noSpace));
    	String operand1 = noSpace[0];
    	String operator = noSpace[1];
    	String operand2 = noSpace[2];
    	String answer = "";
    	
    	int whole1 = getWhole(operand1);
    	int num1 = getNum(operand1);
    	int den1 = getDen(operand1);
    	
    	int[] fraction1 = toImproperFrac(whole1, num1, den1);
    	
    	int whole2 = getWhole(operand2);
    	int num2 = getNum(operand2);
    	int den2 = getDen(operand2);
    	
    	int[] fraction2 = toImproperFrac(whole2, num2, den2);
    	
    	if (operator.equals("*")) {
    		answer = multiply(fraction1, fraction2);
    	} else if (operator.equals("/")) {
    		answer = divide(fraction1, fraction2);
    	}else if (operator.equals("+") || (operator.equals("-"))) {
    		answer = addition(fraction1, fraction2);
    	}
  
    	
    	
        return "whole:" + wholeNum2 + " numerator:" + num2 + " denominator:" + den2;
    }

    //Parsing methods
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
    
    
    
    //Calculate methods 
    
    public static void multiply(int[] fraction1, int[] fraction2) {
    	int newNum = fraction1[1] * fraction2[1];
    	int newDen = fraction1[2] * fraction2[2];
    	
    }
    
    public static void division(int[] fraction1, int[] fraction2) {
    	multiply(fraction1, reciprocal(fraction2));
    }
    
    public static void reciprocal(int[] frac) {
    	int newDen = frac[1];
    	frac[1] = frac[2];
    	frac[2] = newDen;
    }
    
    public static void addition(int[] fraction1, int[] fraction2) {
    	int lcmNum = lcm(fraction1[2], fraction2[2]);
    	int newNum = (lcmNum / fraction1[2] * fraction1[1]) + (lcmNum / fraction2[2] * fraction2[1]);
    	
    }
    
    
    
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
		int wholePositive =  Math.abs(whole);
		int newNum = ( denominator * wholePositive ) + numerator;
		if (whole < 0) {
			newNum = newNum * -1;
		}
		int[] improper = {0, newNum, denominator};
		return improper;
	}
    
    public static int lcm(int num1, int num2) {
    	int gcfNum = gcf(num1, num2);
    	return num1 * num2 / gcfNum;
    }
    
    //a call to find the greatest common between two numbers
  	public static int gcf(int num1, int num2) {
  		int minNum = (int)min(Math.abs(num1), Math.abs(num2)); 
  		int factor = 1;                   			//if they don't share any factor then the factor is 1
  		if (minNum == 0) {
  			factor = (int)max(absValue(num1), absValue(num2));
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
  	
  	public static String toMixedFrac(int[] answer) {
  		simplify(int[]);
  		
  	}
  		
}
