//Alexandra Zhang Jiang
//November 25th 2019
//Project to practice ArrayList

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPracticeLab 
{
	// printMe is just a quick tool to check your work.  Use it in conjunction with the test cases in main
	public static void printMe(ArrayList<String> theList)
	{
		for (String str : theList)
			System.out.print(str + ", ");
			// I know, it prints an extra comma... live with it.  
		System.out.println();
	}
	
	//accepts an array of String and returns an ArrayList containing those Strings
	public static ArrayList<String> convertArrayToList(String[] array) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < array.length; i++) {
//			list.add(array[i]);
//		}
		return list;
	}
	
	//returns the longest string in the list
	public static int maxLength(ArrayList<String> list) {
		int longestStr = 0;
		for (String str : list) {
			if (str.length() > longestStr) {
				longestStr = str.length();
			}
		}
		return longestStr;
	}
	
	
	//method to switch the order of two elements in a list
	public static ArrayList<String> swapPairs(ArrayList<String> list){
		ArrayList<String> swapped = new ArrayList<String>();
		for (int i = 1; i <= list.size() - 1; i += 2) { //swap the pairs
			swapped.add(list.get(i));
			swapped.add(list.get(i - 1));
		}
		if (list.size() % 2 != 0) {		//add last element of the list if it is odd
			swapped.add(list.get(list.size() - 1));
		}
		return swapped;
	}
	
	//delete strings in list that are even
	public static ArrayList<String> removeEvenLength(ArrayList<String> list){
		ArrayList<String> removed = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) { 
			String str = list.get(i);
			if(str.length() % 2 != 0) { 		//only add to the new list if the string is odd
				removed.add(list.get(i));
			}
		}
		return removed;
		
	}
	
	//duplicates all elements of list. {a,b,c} now its {a,a,b,b,c,c}
	public static void doubleList(ArrayList<String> list) {
		for(int i = 1; i <= list.size(); i += 2) {		//+2 each time because the elements will shift once one is doubled
			list.add(i, list.get(i - 1));
		}
	}
	
	//main method to test everything
	public static void main(String[] args) 
	{
		// Declare an ArrayList of String named myList.  Then fill it with: "this", "is", "it".  Print myList using printMe().
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("this");
		myList.add("is");
		myList.add("it");
		printMe(myList);
		

		// To test your maxLength method, convert the following to ArrayLists of Strings and 
		// pass them into your maxLength method.  (You'll want to complete the convertArrayToList method first.)
		// Expected output:  6, 27, 0
		String[] test_max_1 = {"to", "be", "or", "not", "to", "be", "hamlet"};  
		String[] test_max_2 = {"Only one really long string"};
		String[] test_max_3 = {};
		
		System.out.println( maxLength( convertArrayToList( test_max_1)));
		System.out.println( maxLength( convertArrayToList( test_max_2)));
		System.out.println( maxLength( convertArrayToList( test_max_3)));
		

		
		// To test your swapPairs method, convert the following to ArrayLists of Strings and 
		// pass them into your swapPairs method.  
		// Expected output:  
		//    score, four, seven, and, ago, years
		//    love, I, programming!
		//    don't move me
		//    <blank>
		String[] test_swap_1 = {"four", "score", "and", "seven", "years", "ago"};
		String[] test_swap_2 = {"I", "love", "programming!"};
		String[] test_swap_3 = {"don't move me"};
		String[] test_swap_4 = {};
		
		printMe( swapPairs( convertArrayToList(test_swap_1)));
		printMe( swapPairs( convertArrayToList(test_swap_2)));
		printMe( swapPairs( convertArrayToList(test_swap_3)));
		printMe( swapPairs( convertArrayToList(test_swap_4)));
		
		

		// To test your removeEvenLength method, convert the following to ArrayLists of Strings and 
		// pass them into your removeEvenLength method.  
		// Expected output:  
		//    a
		//    Did, you, solve, what?
		//    <blank>
		String[] test_rem_1 = {"This", "is", "a", "test"};
		String[] test_rem_2 = {"Did", "you", "solve", "it", "or", "what?"};
		String[] test_rem_3 = {};
		printMe( removeEvenLength( convertArrayToList(test_rem_1)));
		printMe( removeEvenLength( convertArrayToList(test_rem_2)));
		printMe( removeEvenLength( convertArrayToList(test_rem_3)));

		
		
		// To test your doubleList method, convert the following to ArrayLists of Strings and 
		// pass them into your doubleList method.  
		// Expected output:  
		//    [how, how, are, are, you?, you?]
		//    [One string only, One string only]
		//    <blank>
		String[] test_doub_1 = {"how", "are", "you?"};
		String[] test_doub_2 = {"One string only"};		
		String[] test_doub_3 = {};	
		
		ArrayList<String> test_list_doub_1 = convertArrayToList(test_doub_1);
		ArrayList<String> test_list_doub_2 = convertArrayToList(test_doub_2);
		ArrayList<String> test_list_doub_3 = convertArrayToList(test_doub_3);
		
		doubleList( test_list_doub_1);
		doubleList( test_list_doub_2);
		doubleList( test_list_doub_3);
		
		printMe(test_list_doub_1);
		printMe(test_list_doub_2);
		printMe(test_list_doub_3);
		
	}

}
