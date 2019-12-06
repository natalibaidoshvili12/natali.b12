
/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	/*
	 * Main actions are in the public void run(). I used putting and picking Beepers
	 * method to count how many avenues are there. Then Karel picks Beeper until it
	 * is there. The last beeper which karel picks is on the midpoint and it moves
	 * forward. Then I tried to move karel backward and put beeper there.
	 */
	public void run() {
		if (frontIsClear()) {
			midpointFinding();
		} else {
			putBeeper();
		}
	}

	/*
	 * this method helps us to fill every avenue first street with beepers and we
	 * try to find midpoint with beepers
	 */
	private void puttingBeepers() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
		turnAround();
	}

	/*
	 * This method helps us to find midpoint with picking beepers and moving
	 * forward. In public void run() I use while (beepersPresent()) and if Karel
	 * picks beeper then it can't do anything from there. And if it moves forward
	 * with one step, then beeper will be there and while construction won't be
	 * false
	 */
	private void pickingBeepers() {
		pickBeeper();
		move();
	}

// karel moves until front is blocked and beeper isn't present.
	private void moving() {
		while (frontIsClear() && beepersPresent()) {

			move();
		}
	}
	private void midpointFinding() {
		puttingBeepers();
		for (int i = 0; i < 2; i++) {
			moving();
			turnAround();
			pickingBeepers();
		}
		while (frontIsClear() && beepersPresent()) {
			moving();
			turnAround();
			move();
			if (beepersPresent()) {
				pickBeeper();
				move();
			}
		}
		turnAround();
		move();
		putBeeper();
	}
}
