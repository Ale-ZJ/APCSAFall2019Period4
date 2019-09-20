//Alexandra Zhang Jiang 
//August 29
//Call math methods from the calculate library I created
//client code or runner code

public class DoMath {

	public static void main(String[] args) {
		//part 1
		System.out.println("---------- P A R T  1 ----------");
		System.out.println(Calculate.square(3));
		System.out.println(Calculate.cube(-2));
		System.out.println(Calculate.average(2,4));
		System.out.println(Calculate.average(9,8,4));
		System.out.println(Calculate.toDegrees(3.141592));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1,2,1));
		System.out.println(Calculate.toImproperFrac(-3,1,2));
		System.out.println(Calculate.toMixedNum(7,2));
		System.out.println(Calculate.foil(2,3,6,-7,"n"));
		
		//part 2
		System.out.println("\n---------- P A R T  2 ----------");
		System.out.println(Calculate.isDivisibleBy(8,-2));
		System.out.println(Calculate.absValue(-0.324));
		System.out.println(Calculate.max(2,-3));
		System.out.println(Calculate.max(1,-976,-1442));
		System.out.println(Calculate.min(24,22));
		System.out.println(Calculate.round2(0.00500));
		
		//part 3
		System.out.println("\n---------- P A R T  3 ----------");
		System.out.println(Calculate.exponent(-4,3));
		System.out.println(Calculate.factorial(6));
		System.out.println(Calculate.isPrime(-7));
		System.out.println(Calculate.gcf(12,-6));
		System.out.println(Calculate.sqrt(7));
		
		//part 4
		System.out.println("\n---------- P A R T  4 ----------");
		System.out.println(Calculate.quadForm(1,2,1));
	}
}
