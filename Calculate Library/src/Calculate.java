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
		double degree = radian * (180 / 3.14159);
		return degree;
	}
	
	//a call to transform degree passed into radian
	public static double toRadians(double degree) {
		double radians = degree * (3.14159 / 180);
		return radians;
	}
	
	//a call to calculate the discriminant in a quadratic equation in standard from
	public static double discriminant(double a, double b, double c) {
		double answer = (b * b) - (4 * a * c);
		return answer;
	}

	//a call to convert a mixed number to improper fraction
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("division by zero is undefined, denominator:" + denominator);
		}
		int wholePositive =  (int)absValue(whole);
		int newNum = ( denominator * wholePositive ) + numerator;
		if (whole < 0) {
			newNum = newNum * -1;
		}
		return newNum + "/" + denominator;
	}

	//a call to convert improper fraction into a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("division by zero is undefined, denominator:" + denominator);
		}
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
		if (divisor == 0) {
			throw new IllegalArgumentException("division by zero is undefined, denominator" + divisor);
		}
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
	
	//a call to raise a value to a positive integer
	public static double exponent(double base, int power) {
		if (power < 0) {
			throw new IllegalArgumentException("method can't raise number to a negative exponent:" + power);
		}
		double answer = 1;                		//any base to the 0 power is 1
		for (int i = 1;  i <= power; i++) {
			answer = answer * base;
		}
		return answer;
	}
	
	//a call to return the factorial of a whole number passed 
	public static int factorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("negative number:" + number);
		}
		int answer = 1;						//zero factorial is 1 
		for (int factor = number; factor > 1; factor--) {
			answer = answer * factor;
		}
		return answer;
	}
	
	//a call to determine if a integer is a prime number
	public static boolean isPrime(int number) {
		boolean notPrime = false;
		int factor = 1;
		while (notPrime == false) {			//while no factor is found, then the number is a still a prime
			notPrime = isDivisibleBy(number, factor);
			factor++;
			if (factor == number) {			//if the factor equals the number, then it is a prime
				return true;
			}
		}
		return false;
	}
	
	//a call to find the greatest common between two numbers
	public static int gcf(int num1, int num2) {
		int minNum = (int)min(absValue(num1), absValue(num2)); 
		int factor = 1;                   //if they don't share any factor then the factor is 1
		for (int i = 1; i <= minNum; i++) {
			if (isDivisibleBy(num1, i) == true && isDivisibleBy(num2, i) == true) {
				factor = i;
			}
		}
		return factor;
	}
	
	//a call to return an approximation of the square root of value passed by two decimal places
	public static double sqrt(double number) {
		if (number < 0) {
			throw new IllegalArgumentException("negative number:" + number);
		}
		double edGuess = 0;
		boolean isAccurate = false;
		//get educated guess to use later on
		for (int i=0; square(i) <= number ; i++) {
			edGuess = i;
		}
		//use Newton's formula to get square
		while (isAccurate == false) {
			edGuess = ((number/edGuess) + edGuess)/2;
			if (number-(edGuess*edGuess) < 0.005) {
				isAccurate = true;
			}
		}
		return round2(edGuess);
	}
}
