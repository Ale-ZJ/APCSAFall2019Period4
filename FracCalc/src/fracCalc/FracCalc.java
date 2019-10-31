//Alexandra Zhang Jiang
//October 28th 
//calculator with fractions

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	
    	System.out.print("Operation: ");
    	String operation = userInput.next();
    	System.out.println("result: " + produceAnswer(operation));	

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
    	String[] array = input.split(" ");
    	String operand1 = array[0];
    	String operator = array[1];
    	String operand2 = array[2];
    	
        return operand2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
