//Alexandra Zhang Jiang
//October 28th 
//calculator with fractions

package fracCalc;
import java.util.*;

public class FracCalc {

	//get input from the user and get an answer
	public static void main(String[] args){
		String operation = "";
		Scanner userInput = new Scanner(System.in);

		do{ 
			System.out.print("Operation: ");
			operation = userInput.nextLine();
			if(inputChecked(operation)){
				System.out.println("Result: " + produceAnswer(operation));
			}
		} while(!operation.equals("quit"));

		userInput.close();
	}
    
    //method that evaluates the input and calculates the answer 
    public static String produceAnswer(String input){ 
    	String[] equation = input.split(" ");
    	int startIdx;
    	String answer = "";
    	
    	//reduces the original equation array until there is only one element left which is the answer
    	while (equation.length > 1) {														
    		for (int i = 1; i < equation.length - 1; i += 2) {						//check for the operator
    			String operator = equation[i];
        		if (operator.equals("*") || (operator.equals("/"))) {				//md in pemdas
        			startIdx = i - 1; 
        			int[] operand1 = getFraction(equation[startIdx]);
        			int[] operand2 = getFraction(equation[startIdx + 2]);
        			
        			if (operator.equals("/")) reciprocal(operand2);
        	    	
        			answer = multiply(operand1, operand2);
        			equation = replace(equation, answer, startIdx);
            		
            		i = -1; //reset loop
        		}
    		}
        	
    		for (int i = 1; i < equation.length - 1; i += 2) {						//check for the operator
    			String operator = equation[i];
    			if (operator.equals("+") || (operator.equals("-"))){				//as in pemdas
        			startIdx = i - 1; 
        			int[] operand1 = getFraction(equation[startIdx]);
        			int[] operand2 = getFraction(equation[startIdx + 2]);
        			
        			if (operator.equals("-")) operand2[1] *= -1;
        			
        			answer = addition(operand1, operand2);
        			equation = replace(equation, answer, startIdx);
            		
            		i = -1; //reset loop
        		}
        	}
    	}
    	return answer;
    }
    
    
    
    /* * * * * * * * * * * PARSING METHODS * * * * * * * * * * * * * * * */
    //get the int values from the string fraction passed, converts to improper fraction and stores them in an array
    public static int[] getFraction(String strFrac) {
    	int whole = 0; 
    	int num = 0; 
    	int den = 1; 
    	
    	if(strFrac.contains("/")) {					//there is a fraction 
    		num = getNum(strFrac);
    		den = getDen(strFrac);
    		if(strFrac.contains("_")) {				//there is a whole w the fraction 
    			whole = getWhole(strFrac);
    		}
    	}else {										//it is only the whole
    		whole = Integer.parseInt(strFrac);
    	}
    	
    	int[] intFraction = toImproperFrac(whole, num, den);
    	return intFraction;
    }
    
    public static int getWhole(String frac) {
        return Integer.parseInt(frac.substring(0, frac.indexOf("_")));
    }
    
    public static int getNum(String frac) {
    	if(frac.contains("_")) {					//it is mixed
    		return Integer.parseInt(frac.substring(frac.indexOf("_") + 1, frac.indexOf("/")));
    	} else {   									//only fraction 
    		return Integer.parseInt(frac.substring(0, frac.indexOf("/")));
    	}
    }
    
    public static int getDen(String frac) {
    	return Integer.parseInt(frac.substring(frac.indexOf("/") + 1));
    }
    
    
    
    /* * * * * * * * * * * OPERATION METHODS * * * * * * * * * * */
    //return product of two fractions 
    public static String multiply(int[] fraction1, int[] fraction2) {    	
    	int num = fraction1[1] * fraction2[1];
    	int den = fraction1[2] * fraction2[2];
    	return toMixedFrac(num, den);
    }

    //return addition of two fractions
    public static String addition(int[] fraction1, int[] fraction2) {
    	int num = (fraction2[2] * fraction1[1]) + (fraction1[2] * fraction2[1]);
    	int den = fraction1[2] * fraction2[2];
    	return toMixedFrac(num, den);
    }
    
    
    
    /* * * * * * * * * * METHODS TO CHANGE A FRACTION * * * * * * * * * * */
    //flip num and den 
    public static void reciprocal(int[] frac) {
		int newDen = frac[1];
		frac[1] = frac[2];
		frac[2] = Math.abs(newDen);
		if (newDen < 0) frac[1] *= -1;
	}

	//a call to find the greatest common factor between two numbers using Euclid's algorithm
    public static int gcf(int num1, int num2){
        while(num2 != 0){
            int newNum2 = num1 % num2;
            num1 = num2;
            num2 = newNum2;
        }
        return Math.abs(num1);
    }
  	
  	//convert fraction to improper
  	public static int[] toImproperFrac(int whole, int num, int den) {
  		int newNum = ( den * Math.abs(whole) ) + num;
  		if (whole < 0) newNum = newNum * -1;
  		int[] improper = {0, newNum, den};
  		return improper;
  	}

  	//convert fraction to a simplified mixed
	public static String toMixedFrac(int num, int den) {
		//simplify the fraction 
  		int gcfNum = gcf(num, den);
  		num /= gcfNum;
  		den /= gcfNum;
  		  		  		
  		int wholeNum = num / den;	//int divided by int cast decimals
		int newNum = num % den; 
		
		if (newNum == 0) return "" + wholeNum;
		else if (wholeNum == 0) return newNum + "/" + den;
		else return wholeNum + "_" + Math.abs(newNum) + "/" + den;
  	}
  	
	
	
  	/* * * * * * * * * * METHODS TO CHANGE ORIGINAL EQUATION * * * * * * * * * */
	//replace answer on original equation array on specified index and removes the following two
  	public static String[] replace(String[] original, String solution, int idx) {
  		original[idx] = solution;   		
  		
  		String[] beforeIdx = Arrays.copyOfRange(original, 0, idx + 1);
  		String[] afterIdx = Arrays.copyOfRange(original, idx + 3, original.length);
  		String[] newArr = new String[beforeIdx.length + afterIdx.length];
  		
  		int index = 0;
		
		for (String element : beforeIdx) {			//store elements 
			newArr[index] = element;
			index++;
		}
		for (String element : afterIdx) {
			newArr[index] = element;
			index++;
		}
		
		return newArr;
  	}
  	
  	
  	
  	/* * * * * * * * * * ERROR CHECKING METHODS * * * * * * * * * */
  	//checks that the input has no errors
  	public static boolean inputChecked(String input){
  		boolean noError = true; 
  		
  		//if input is a non-digit except for -, /, +, *, _, " "
  		if(input.matches(".*([\\D&&[^-|/|\\+|\\*|_| ]]).*")){
  			if(!input.equals("quit")) {
  				System.out.println("Error: invalid input");
  			}
  			noError = false;
  			
  		}else if(input.contains("/0")) {
  			System.out.println("Error: division by 0 is undefined :c");
  			noError = false;
  			
  		}else {
  			String[] array = input.split(" ");
  	    	if (array.length < 3){ 
  				noError = false;
  				System.out.println("Error: couldn't find operation");
  			}
  			int i = 0;
  			while(noError && i < array.length - 1){ //loop until you find an error 
  				if (i % 2 != 0) noError = checkOdd(array[i], array[i + 1]);
  				else noError = checkEven(array[i]);
  				i++;
  			}
  	  }
  	  return noError;
  	}
  	
  	//check for the operator place
  	public static boolean checkOdd(String operator, String operand2) {
  		ArrayList<String> validOperators = new ArrayList<String>(Arrays.asList("*", "+", "-", "/"));
  		if ((operator.equals("/") && operand2.matches("(\\d+)?(_)?(0)(/)?(\\d+)?"))) { //check for zero division
  			System.out.println("Error: cannot divide by 0 :c");
  			return false;
  		}
  		if (!validOperators.contains(operator)) return false;
  		
  		return true;
  	}
  	
  	//check formating (regex pattern) of the fraction
  	public static boolean checkEven(String value) {
  		//if format: a_b/c or b/c or a, where a,b,c are one or more digits
  		if (!(value.matches("-?(\\d+)(_)(\\d+)(/)(\\d+)") || value.matches("-?\\d+/\\d+") || value.matches("-?(\\d+)"))) {	
  			System.out.println("Error: incorrect fraction format");
  			return false;
  		}
  		return true;
  	}

}
