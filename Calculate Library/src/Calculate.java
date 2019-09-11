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
	public static double toDegrees(double radian) {
		double degrees = radian * (180 / 3.14159);
		return degrees;
	}
	
	//a call to transform degree passed into radian
	public static double toRadians(double degree) {
		double radians = degree * (3.14159 / 180);
		return radians;
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
	
	//a call to determine if one integer is divisible by another
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (dividend % divisor == 0) {
			return true; //it is divisible
		} else { 
			return false; 
		}
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
	
	//overloading max to accept three inputs
	public static double max(double num1, double num2, double num3) {
		double maxNum = num1; 
		if (num1 < num2) {
			maxNum = num2;
		} 
		if (maxNum < num3) { //either num1 or num2 will be maxNum here
			maxNum = num3;
		} 
		return maxNum;
	}
	
	//a call to return minimum between two numbers
	public static double min(double num1, double num2) {
		double minNum = num1;
		if (num1 > num2) {
			minNum = num2; //num2 is bigger than num1
		}
		return minNum;
	}
	
	//a call to round a number to 2 decimal places and return a double
	public static double round2(double decimal) {
		double number = absValue(decimal); //so that we work w positive numbers only
		number = (number * 100) + 0.5;     //move decimal place two places
		number = (int)number;              //cast the decimals
	                                       //add 0.5 so that the unit digit will go up if its <=5
//		number = (int)number / 100;        //back to a decimal number!
//		if (decimal < 0) {                 //dont forget that some numbers might be negative
//			number = number * -1;
//		}
		return number;
	}
	
	
	
	
}
