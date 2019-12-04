//Alexandra Zhang Jiang
//October 28th 
//calculator with fractions

package fracCalc;
import java.util.*;

public class FracCalc {

	//get input from the user and get an answer
    public static void main(String[] args) {
    	String operation = "";
    	Scanner userInput = new Scanner(System.in);
    	
    	do {				//loop until user says to quit
	    	System.out.print("Operation: ");
	    	operation = userInput.nextLine();
	    	System.out.println("result: " + produceAnswer(operation));	
    	} while (!operation.equals("quit"));
    	
    	userInput.close(); //close scanner
    }
    
    //method that evaluates the input and calculates the answer 
    public static String produceAnswer(String input){ 
    	String[] equation = input.split(" ");
    	System.out.println("split on space:" + Arrays.toString(equation));				//DELETE for checking purposes
    	int startIdx;
    	String answer = "";
    	
    	//reduces the original equation array until there is only one element left which is the answer
    	while (equation.length > 1) {														
    		for (int i = 1; i < equation.length - 1; i += 2) {									//check for the operator
    			String operator = equation[i];
    			
        		if (operator.equals("*") || (operator.equals("/"))) {					//md in pemdas
        			startIdx = i - 1; 
        			int[] operand1 = getFraction(equation[startIdx]);
        			int[] operand2 = getFraction(equation[startIdx + 2]);
        			
        			if (operator.equals("/")) {
        	    		reciprocal(operand2);
        	    	} 
        			
        			answer = multiply(operand1, operand2);
        			
        			equation = replace(equation, answer, startIdx);
            		System.out.println("answer:" + answer);				//DELETE for checking purposes
            		System.out.println("after replace:" + Arrays.toString(equation) + "\n");				//DELETE for checking purposes
            		
            		i = -1; //reset loop
        		}
    		}
        	
    		for (int i = 1; i < equation.length - 1; i += 2) {									//check for the operator
    			String operator = equation[i];
        		if (operator.equals("+") || (operator.equals("-"))){
        			startIdx = i - 1; 
        			int[] operand1 = getFraction(equation[startIdx]);
        			int[] operand2 = getFraction(equation[startIdx + 2]);
        			
        			if (operator.equals("-")) {
        				operand2[1] *= -1;
        			}
        			
        			answer = addition(operand1, operand2);
        			
        			equation = replace(equation, answer, startIdx);
            		System.out.println("answer:" + answer);				//DELETE for checking purposes
            		System.out.println("after replace:" + Arrays.toString(equation) + "\n");				//DELETE for checking purposes
            		
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
		if (newDen < 0) {
			frac[1] *= -1;
		}
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
  		int wholePositive =  Math.abs(whole);
  		int newNum = ( den * wholePositive ) + num;
  		if (whole < 0) {
  			newNum = newNum * -1;
  		}
  		int[] improper = {0, newNum, den};
  		
  		return improper;
  	}

  	//convert fraction to a simplified mixed
	public static String toMixedFrac(int num, int den) {
		//simplify the fraction 
  		int gcfNum = gcf(num, den);
  		num /= gcfNum;
  		den /= gcfNum;
  		
  		System.out.println("improper:" + num + "/" + den);								//DELETE for checking purpose
  		  		
  		int wholeNum = num / den;	//int divided by int cast decimals
		int newNum = num % den; 
		
		if (newNum == 0) {			//no fraction
			return "" + wholeNum;
		} else if (wholeNum == 0) {
			return newNum + "/" + den;
		} else {
		return wholeNum + "_" + Math.abs(newNum) + "/" + den;
		}
  	}
  	
	
	
  	/* * * * * * * * * * METHODS TO CHANGE ORIGINAL EQUATION * * * * * * * * * */
	//replace answer on original equation array on specified index and removes the following two
  	public static String[] replace(String[] original, String solution, int idx) {
  		original[idx] = solution; 
  		System.out.println("original:" + Arrays.toString(original));				//DELETE for checking purposes
  		
  		System.out.println("startIdx:" + idx);														//DELETE for checking purposes
  		
  		String[] beforeIdx = Arrays.copyOfRange(original, 0, idx + 1);
  		System.out.println("beforeIdx:" + Arrays.toString(beforeIdx));								//DELETE for checking purposes
  		
  		String[] afterIdx = Arrays.copyOfRange(original, idx + 3, original.length);
  		System.out.println("afterIdx:" + Arrays.toString(afterIdx));								//DELETE for checking purposes
  		
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
  	
//  	public static String checkInput(String[] input) {
//  		boolean noProb = false;
//  		
//  		ArrayList<String> invalidOp = new ArrayList<>(Arrays.asList("/0"));
//  		ArrayList<String> op = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
//  		ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
//  		
//  		while(input.length > 3) {
//  			for(int i = 1; i < input.length; i+=2) { //odd
//  				if(!op.contains(input[i])) {
//  					return "Error: Spacing might be wrong";
//  				}
//  			} 
//  			
//  			for(int i = 0; i < input.length; i+=2) { //even
//  				int underscoreIdx = input[i].indexOf('_');
//  				int slashIdx = input[i].indexOf('/');
//  				
//  				if (underscoreIdx > 0) {
//  					if(input[i].length() < 5) {
//  						return "Error: incomplete";
//  					}
//  				} else if (slashIdx > 0) {
//  					if (input[i].length() < 3) {
//  						return "Error: incomplete fraction";
//  					}
//  				}
//  			}
//  			return "";
//  		}
//
//  	}

}
