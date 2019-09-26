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
		boolean finished = false;
		
		//Welcome message
		System.out.println("Welcome to the Quadratic Describer program c:");			
		
		//start game loop
		while (finished == false) { 															
			System.out.println("Provide coeficients a, b, c for your quadratic equation");	//ask for values
			System.out.print("a: \nb: \nc:");
			a = userInput.nextDouble();
			b = userInput.nextDouble();
			c = userInput.nextDouble();
			
			String description = Quadratic.quadrDescriber(a, b, c);						//pass values to the describer 
			System.out.println(description);											//print out all the description of the graph
			
			System.out.print("Continue? (type \"quit\" to exit)");						//ask if user wants to continue
			String answer = userInput.next();
			if (answer.equals(toLowerCase("quit"))) {
				cont = true;															//
			}
		}
		System.out.println("Thanks for using me!");
		
	}

}

