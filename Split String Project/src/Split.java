// Alexandra Zhang Jiang
// Oct 18, 2019
// Play aaround with the split() method for strings

import java.util.*;

public class Split {
	public static void main(String[] args) {

		// Your task Part 0

		//String.split();

		//It's a method that acts on a string, <StringName>.split(<sp>);

		//Where sp is the string where the string splits

		//And it returns an array

		// Example: "I like apples!".split(" ");

		// it will split at spaces and return an array of ["I","like","apples!"]

		// Example 2: "I really like really red apples!".split("really")

		// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

		//play around with String.split!

		//What happens if you "I reallyreally likeapples".split("really") ?
		
//		String[] outputArray = "I like apples".split(" ");
//		System.out.println(Arrays.toString(outputArray));
//		
//		String[] outputArray2 = "I really like really red apples".split(" really ");
//		System.out.println(Arrays.toString(outputArray2));
//		
//		String[] outputArray3 = "I really like really red apples".split("really");
//		System.out.println(Arrays.toString(outputArray3));
//		
//		String[] outputArray4 = "really I really like really red apples".split("really");
//		System.out.println(Arrays.toString(outputArray4));
		
//		System.out.println(part1("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
//		System.out.println(part1("bread"));
//		System.out.println(part1("breadham"));
//		System.out.println(part1("mayobread"));
//		System.out.println(part1("breadmayobread"));
//		System.out.println(part1("breadbread"));
//		System.out.println(part1("breadmayobreadham"));
//		System.out.println(part1("ham"));
//		System.out.println(part1("hambreadhambreadcheesebread"));
		System.out.println(part1("hambreadhambreadcheesebreadegg"));
//		System.out.println(part1("hambreadbreadhambreadcheesebreadegg"));


	}
	
	public static String part1(String sandwich) {
		String[] components = sandwich.split("bread");		//return an array of all components not bread
		String ingredients = "";
		boolean finished = false;
		System.out.println(Arrays.toString(components));
		
		int indexBread = sandwich.indexOf("bread");
		System.out.println(indexBread);																//DELETE
		
		if (indexBread != -1) {	
			while (!finished) {
			int i=1;
			String newString = sandwich.substring(indexBread + 5);		//cut the sandwich where first bread is
			System.out.println(newString);                      									//DELETE
			int anotherIndex = newString.indexOf("bread");
			System.out.println(anotherIndex);														//DELETE
			
			if ( anotherIndex > 0) {									//there is next bread 
				ingredients += components [i];
				finished = true;
				i++;
			} else if (anotherIndex == 0){								//there is bread right after
				ingredients = "This is not a sandwich, you are missing the ingredients!";
				finished = true;

			} else {
				ingredients = "This is not a sandwich";
				finished = true;

			}
			}
		}else {	//no bread found
			ingredients = "This is not a sandwich, you forgot the bread!";
			finished = true;
		}
		return ingredients;
		
	}
	
	
	
	


		
		//Your task Part 1:

		/*Write a method that take in a string like

		* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

		* describing a sandwich.

		* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

		* the sandwich and ignores what's on the outside

		* What if it's a fancy sandwich with multiple pieces of bread?

		*/

		//Your task pt 2:

		/*Write a method that take in a string like

		* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

		* describing a sandwich

		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

		* the sandwich and ignores what's on the outside.

		* Again, what if it's a fancy sandwich with multiple pieces of bread?

		*/

		 
}
