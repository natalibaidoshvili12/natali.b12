
/*
 * File: Hailstone.java
 * Name: Natali Baidoshvili
 * Section Leader: Tato Katsitadze
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;
import acm.program.ConsoleProgram;

public class Hailstone extends ConsoleProgram {
	// I use SENTINEL to stop while loop
	private static final int SENTINEL = 1;

	/*
	 * I use read int to write number. Then I define n as a zero, because I need a
	 * to count steps which are need to find how many steps did it take to reach
	 * SENTINEL. Then I use while loop to repeat and write numbers until it is equal
	 * to SENTINEL. I use if loop to find if the number is even or odd. Then I do
	 * appropriate step (take half or make 3n+1) and print what I did. Finally I
	 * print how many steps did it take to reach SENTINEL.
	 */
	public void run() {
		int n = readInt("Enter a number: ");
		int a = 0;
		while (n != SENTINEL) {
			if (n % 2 == 0) {
				println(n + " is even so I take half: " + n / 2);
				n = n / 2;
			} else {
				println(n + " is odd so I make 3n+1 " + (3 * n + 1));
				n = 3 * n + 1;
			}
			a = a + 1;
		}
		println("This process took " + a + " steps to reach 1");
	}
}
