//Alexandra Zhang Jiang 
//August 29
//Group of methods that performs math calculations (a library)

public class Calculate {
	
	//a call to return a square of integer passed
	public static int square(int number) {
		int answer = 0;
		answer = number * number;
		return answer;
	}
	
	//a call to return a cube of integer passed
	public static int cube(int number) {
		int answer = number * number * number; 
		return answer;
	}
	
	//a call to average two numbers passed 
	public static double average(double num1, double num2) {
		double answer = (num1 + num2) / 2;
		return answer;
	}
	
	//a call to average three numbers passed
	public static double average(double num1, double num2, double num3) {
		double answer = (num1 + num2 + num3) / 3; 
		return answer;
	}
	
	//a call to transform radian passed into degrees
	public static double toDegrees(double number) {
		double answer = number * (180 / 3.14159);
		return answer;
	}
	
	//a call to transform degree passed into radian
	public static double toRadians(double number) {
		double answer = number * (3.14159 / 180);
		return answer;
	}
	
	//a call to calculate the discriminant in a quadratic equation in standard from
	public static double discriminant(double a, double b, double c) {
		double answer = b - (4 * a * c);
		return answer;
	}
	
	//a call to convert a mixed number to improper fraction
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		int newNumerator = ( denominator * whole ) + numerator;
		return newNumerator + "/" + denominator;
	}
	
	//a call to convert improper fraction into a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		int wholeNum = numerator / denominator;
		int newNumerator = numerator % denominator; 
		return wholeNum + "_" + newNumerator + "/" + denominator;
	}
	
	//a call to convert a binomial multiplication of the form (ax + b)(cx + d) 
	//into quadratic form ax^2 + bx + c
	public static String foil(int a, int b, int c, int d, String variable) {
		int firstTerm = a * c; 
		int secondTerm = (b * c) + (a * d);
		int thirdTerm = b * d; 
		return firstTerm + variable + "^2" + " + " + secondTerm + variable + " + " + thirdTerm;
	}
}
