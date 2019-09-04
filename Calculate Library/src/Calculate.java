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
	public static double discriminant(double a, b, c) {
		double answer = b - (4 * a * c)
	}
	
	public static toImproperFrac(int whole, numerator, denominator) {
		double newNumerator = ( denominator * whole ) + numerator;
		
	}
	
}
