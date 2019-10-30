// Alexandra Zhang Jiang
// Oct 18, 2019
// Play around with the split() method for strings

public class Split {
	public static void main(String[] args) {
		System.out.println(part1("bread"));
		System.out.println(part1("breadham"));
		System.out.println(part1("mayobread"));
		System.out.println(part1("ham"));
		System.out.println(part1("breadbread"));
		System.out.println(part1("hambreadbread"));
		
		System.out.println(part1("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
		System.out.println(part1("breadmayobread"));
		System.out.println(part1("cheesebreadmayobreadham"));
		System.out.println(part1("hambreadhambread"));
		
		System.out.println(part1("hambreadhambreadcheesebread"));
		System.out.println(part1("hambreadbreadhambreadcheesebreadegg"));
		
		System.out.println(part2("cheese bread ham"));
		System.out.println(part2("bread mayo bread ham"));
		System.out.println(part2("apples pineapples bread lettuce tomato bread bacon mayo ham bread cheese"));
	}
	
	//accepts a string of sandwich components without spaces in between 
	public static String part1(String sandwich) {
		String fillings = "";
		
		int idxFirstBread = sandwich.indexOf("bread");					//find first bread
		int idxLastBread = sandwich.lastIndexOf("bread");				//find last bread
		int difference = idxLastBread - idxFirstBread;					
		
		if (difference > 5) {			//bread is at an appropriate distance from each other					
			String betweenBreads = sandwich.substring(idxFirstBread + 5, idxLastBread);		//get ride of the outside fillings
			String[] components = betweenBreads.split("bread");								//new array will contain all the fillings except other breads
			
			for (String element: components) {							//concatenate all those fillings into a string 
				fillings += element;
			}
			return fillings;
		}
		return "Not a sandwich"; //one bread only difference is 0, bread next to each other dif is 5
	}
	
	//accepts a string of sandwich components with a space in between 
	public static String part2(String sandwichSpaces) {
		String[] components = sandwichSpaces.split(" ");
		String withoutSpace = "";
		for (int i = 0; i < components.length; i++) {	//get each element in the array and concatenate in a string
			withoutSpace += components[i];
		}
		String fillings = part1(withoutSpace);
		return fillings;
	}
}
