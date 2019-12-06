
/*
 * File: PythagoreanTheorem.java
 * Name: Natali Baidoshvili
 * Section Leader: Tato Katsitadze
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;
import acm.program.ConsoleProgram;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		pythagorean();
	}

	// I use println method to warn what reader has to do
	// I use double valuea(b) to warn reader where to put numbers
	// I use double c to calculate pythagorean theorem
	// I use println to get result
	private void pythagorean() {
		println("Enter values to compute Pythagorean Theorem");
		double valuea = readInt("a:");
		double valueb = readInt("b:");
		double c = Math.sqrt(valuea * valuea + valueb * valueb);
		println("c=" + c);
	}
}
