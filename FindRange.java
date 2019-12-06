
/*
 * File: FindRange.java
 * Name: Natali Baidoshvili
 * Section Leader: Tato Katsitadze
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SPECIAL_NUMBER = 0;

// In public void run() I use only one method which I described below
	public void run() {
		defining();
	}

	// This method prints a text with a definiton smallest and largest
	private void printing(int smallest, int largest) {
		println("smallest: " + smallest);
		println("largest: " + largest);
	}

	/*
	 * First, I print a text which warns reader what this code does. Then I use
	 * readInt to read number and I define smallest and largest as a zero. Then I
	 * use define n. I need n to count how many numbers we write. Then I use if loop
	 * to find if the number = SPECIAL_NUMBER. I have special warning for that.
	 * If number isn't equal to SPECIAL_NUMBER I use else to do next step.
	 * I use while loop to stop the code when the number will be equal to SPECIAL_NUMBER
	 * Then I count how many numbers I've written. if n = 1, then smallest and largest are the same
	 * if it is not then I do else, I use Math.max and Math.min methods to recognize smallest and largest
	 * and I use readInt again to read new numbers.
	 * at the end of the void I use printing method which I described up. 
	 */
	private void defining() {
		println("This program finds the largest and the smallest numbers.");
		int number = readInt("?");
		int smallest = 0;
		int largest = 0;
		int n = 0;
		if (number == SPECIAL_NUMBER) {
			println("Smallest and Largest are undefined");
		} else {
			while (number != SPECIAL_NUMBER) {
				n = n + 1;
				if (n == 1) {
					smallest = number;
					largest = number;

				} else {
					smallest = Math.min(number, smallest);
					largest = Math.max(number, largest);
					number = readInt("?");
				}
			}
			printing(smallest, largest);
		}
	}
}
