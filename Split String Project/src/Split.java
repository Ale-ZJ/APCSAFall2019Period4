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
		System.out.println(part2("bread mayo bread ham"));
//		System.out.println(part1("ham"));
//		System.out.println(part1("hambreadhambreadcheesebread"));
//		System.out.println(part1("hambreadhambread"));
//		System.out.println(part1("hambreadbreadhambreadcheesebreadegg"));
//		System.out.println(part2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));


	}
	
	public static String part1(String sandwich) {
		String[] components = sandwich.split("bread");		//return an array of all components not bread
		String ingredients = "";
		System.out.println(Arrays.toString(components));
		
		int indexBread = sandwich.indexOf("bread");
		System.out.println(indexBread);																//DELETE
		
		if (indexBread != -1) {	
			String newString = sandwich.substring(indexBread + 5);		//cut the sandwich where first bread is
			System.out.println(newString);                      									//DELETE
			indexBread = newString.indexOf("bread");
			System.out.println(indexBread);														//DELETE
			
			if ( indexBread > 0) {									//there is next bread 
				ingredients += components [1];
			} else if (indexBread == 0){								//there is bread right after
				ingredients = "This is not a sandwich, you are missing the ingredients!";
			} else {
				ingredients = "This is not a sandwich";
			}
		}else {	//no bread found
			ingredients = "This is not a sandwich, you forgot the bread!";
		}
		return ingredients;
		
	}
	
	public static String part2(String sandwichSpaces) {
		String[] components = sandwichSpaces.split(" ");
		System.out.println(Arrays.toString(components));			//DELETE
		String withoutSpace = "";
		for (int i = 0; i < components.length; i++) {		//get each element in the array and concagtenate in string
			withoutSpace += components[i];
		}
		System.out.println(withoutSpace);
		String fillings = part1(withoutSpace);
		return fillings;
	}
}
