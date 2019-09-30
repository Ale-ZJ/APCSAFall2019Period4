//Alexandra Zhang Jiang 
//September 23
//Class for user to test QuadraticDescriber

import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		//setting up Scanner and variables
		Scanner userInput = new Scanner(System.in);
		double a;
		double b;
		double c;
		boolean notContinue = false;
		
		//Welcome message
		System.out.println("Welcome to the Quadratic Describer program \\(OwO)/");			
		
		//start game loop
		while (notContinue == false) { 															
			System.out.println("\nProvide coeficients a, b, c for your quadratic equation");	//ask for values
			
			//get user's input and store them in respective variables
			System.out.print("a: ");
			a = getValidInput(userInput);
			
			System.out.print("b: ");
			b = getValidInput(userInput);
			
			System.out.print("c: ");
			c = getValidInput(userInput);
			
			String description = Quadratic.quadrDescriber(a, b, c);						//pass values to the describer 
			System.out.println(description);											//print out all the description of the graph
			
			System.out.print("Continue? (type \"quit\" to exit) ");						//ask if user wants to continue
			String answer = userInput.next();
			if (answer.equalsIgnoreCase("quit") || answer.equalsIgnoreCase("no") ) {
				notContinue = true;														//get out of the loop
			}
		}
		System.out.println("\nThanks for using me! (UwU)");
		
	}
	
	//verify that the input provided are valid for the quadratic describer
	public static double getValidInput(Scanner userInput) {
		double validInput=0;
		boolean isValid = false; 
		while (isValid == false) {						//it will continue to ask you for input until a valid one is reached
			if (userInput.hasNextDouble()) {			//check if what is in the console is a double
				validInput = userInput.nextDouble();	//if yes, store it for use
				isValid = true;
			} else { 									//if not, tell the client what is wrong
				System.out.print("Error: \"" + userInput.next() + "\" is not a number. Try again: ");
			}
		}
		return validInput;
	}
	

}

