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
		System.out.println("Welcome to the Quadratic Describer program c:");			
		
		//start game loop
		while (notContinue == false) { 															
			System.out.println("Provide coeficients a, b, c for your quadratic equation");	//ask for values
			
			//get user's input and store them in respective variables
			System.out.print("a: ");
			a = userInput.nextInt();
			System.out.print("b: ");
			b = userInput.nextInt();
			System.out.print("c: ");
			c = userInput.nextInt();
			
			String description = Quadratic.quadrDescriber(a, b, c);						//pass values to the describer 
			System.out.println(description);											//print out all the description of the graph
			
			System.out.print("Continue? (type \"quit\" to exit)");						//ask if user wants to continue
			String answer = userInput.next();
			if (answer.equalsIgnoreCase("quit") || answer.equalsIgnoreCase("no") ) {
				notContinue = true;														//get out of the loop
			}
		}
		System.out.println("Thanks for using me!");
		
	}

}

