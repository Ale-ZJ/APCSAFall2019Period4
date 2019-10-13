//Alexandra Zhang Jiang 
//October 9, 2019
//Print an hourglass using nested for loops

import java.util.*;

public class Hourglass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		print("Hourglass size: ");											
		int size = input.nextInt();
		print(base(size) + shape(size) + base(size));
	}
	
	public static String base(int size) {
		String row = "|";
		for (int i = 0; i < size; i++) {
			row += "\"";
		}
		return row + "|\n";
	}
	
	public static String shape(int size) {
		String glass = "";
		int midNum = (size + 1) / 2;
		//to print lines of the hourglass (height)
		for (int line = -midNum + 1; line < midNum; line++) {
			
			//to give the shape of the hourglass
			for (int indent = 0; indent < -Math.abs(line) + midNum; indent++) {
				glass += " ";
			}
			
			//fill glass w sand
			if ( line < 0) {			//upper part
				glass += "\\" + sand(line, size) + "/\n";
			} else if (line == 0){		//center
				glass+=center(size);
			} else {					//lower part
				glass += "/" + sand(line, size) + "\\\n";
			}
		}
		return glass;
	}
	
	//get the sand for the interior of the hourglass
	public static String sand(int line, int size) {
		String fill = "";
		int amount = Math.abs(2 * line);
		if (size % 2  != 0) {							//odd case
			amount--;
		}
		for (int sand = 1; sand <= amount ; sand++) {	//add correct amount of sand to the glass
			fill += ":";
		}
		return fill;
	}
	
	//get the shape of the center of the hourglass
	public static String center(int size) {
		if (size % 2 != 0) return "|\n";				//odd hourglass
		else return "||\n";								//even hourglass
	}
	
	//print all the print statements in the code
	public static void print(String toPrint) {
		System.out.print(toPrint);
	}
}
