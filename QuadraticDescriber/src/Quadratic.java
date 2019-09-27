//Alexandra Zhang Jiang 
//September 23
//Class responsible for all the math calculations 

public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {

	String description = "";
	
	//combine all the descriptions in one String to return it
	description = "\n" + equation(a,b,c) + "\n\n" + open(a) + "\n" + getVertex(a,b,c) + "\n" + xInter(a,b,c) + "\n" + yInter(c) + "\n\n";
	
	return description;
	}
	
	//write the equation in standard form based on the coeficients given
	public static String equation(double a, double b, double c) {
		return "Your equation: (" + a + " x^2) + (" + b +  " x) + (" + c + ")";
	}
	
	//get the direction where the graph opens
	public static String open(double a) {
		String direction = "Up";		//set default direction to up
		if (a < 0) {
			direction = "Down";			//change to down if stretch factor is negative
		}
		return "Opens: " + direction;
	}
	
	//get the vertex and axis of symmetry
	public static String getVertex(double a, double b, double c) {
		double h,k;
		h = -b / (2 * a);							//use formula -b/2a
		k = (a * square(h)) + (b * h) + c;			//replace in f(h)
		return "Axis of Symmetry: " + round2(h) + "\nVertex: (" + round2(h) + ", " + round2(k) + ")";
	}
	
	//use quadratic formula to get the x-intercepts
	public static String xInter(double a, double b, double c) {
		double discri = discriminant(a,b,c);				//get discriminant 
		//declaring variables
		String output="";
		double root1;
		double root2;
		//test to see what types of roots will I get
		if (discri < 0) { 									//negative
			output = "none";
		} else {											//positive
			root1 = (sqrt(discri) - b ) / (2 * a);			//quadratic formula
			root2 = (-sqrt(discri) - b ) / (2 * a);
			output = round2(min(root1,root2)) + " and " + round2(max(root1,root2));
			if (root1 == root2) {							//0
				output = round2(root1) + "";
			}
		}
	return "X-intercept(s): " + output;	
	}
	
	//get the y-intercept
	public static String yInter(double c) {
		return "Y-intercept: " + round2(c);
	}
	
	/*From the CALCULATE PROJECT*********/
	
	//a call to return a square of number passed
	public static double square(double number) {
		double answer = 0;
		answer = number * number;
		return answer;
	}
	
	//calculate square root of a number
	public static double sqrt(double number) {
		double answer = 0;
		for (double i = 0.001; (square(i) - number) < 0.005; i += 0.001) {
			answer = i;
		}
		return round2(answer);
	}
	
	//a call to calculate the discriminant in a quadratic equation in standard from
	public static double discriminant(double a, double b, double c) {
		double answer = (b * b) - (4 * a * c);
		return answer;
	}
	
	//a call to round a number to 2 decimal places and return a double
	public static double round2(double decimal) {
		double number = absValue(decimal); 	//work w positive numbers
		number = (number * 100) + 0.5;     	//move decimal place two places right and add 0.5 
												//will increase unit digit by one if <= 5
		number = (int)number;              	//cast the decimals we don't want
		number = number / 100;        		//back to a decimal number!
		if (decimal < 0) {                 	//don't forget that some numbers might be negative
			number = number * -1;
		}
		return number;
	}
	
	//a call to return minimum between two numbers
	public static double min(double num1, double num2) {
		double minNum = num1;
		if (num1 > num2) {
			minNum = num2; //num2 is bigger than num1
		}
		return minNum;
	}
	
	//a call to return absolute value 
	public static double absValue(double number) {
		double absNum;
		if (number < 0) {
		absNum = number * -1; //convert to positive number
		} else {
			absNum = number;
		}
		return absNum;
	}
	
	//a call to return the max value of two numbers 
	public static double max(double num1, double num2) {
		double maxNum = num1;
		if (num1 < num2) {
			maxNum = num2; //num2 is bigger than num1
		}
		return maxNum;
	}		
}
