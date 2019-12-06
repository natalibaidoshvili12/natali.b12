
/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	/*
	 * Karel does fillingPotholes Method while front Is clear and I add that method
	 * one more time because last street needs to be filled too.
	 */
	public void run() {
		while (frontIsClear()) {
			fillingPotholes();
		}
		fillingPotholes();
	}

// move four times forward or back
	private void moveFourTimes() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}

	/*
	 * This method helps us to check if front is clear and not to be blocked
	 */
	private void checkingIfFrontIsClear() {
		if (frontIsClear()) {
			move();
		}
	}

	/*
	 * This method helps us to fill first street with beepers until it is blocked by
	 * hurdle and not to add one more beeper on the avenue if there is one.
	 */
	private void puttingBeepers() {
		if (!beepersPresent()) {
			while (!beepersPresent()) {
				putBeeper();
				checkingIfFrontIsClear();
			}
		} else {
			if (frontIsClear()) {
				move();
				if (!beepersPresent()) {
					putBeeper();
				}
			}
		}
	}

	/*
	 * This method helps us to make sure if front is clear and gives us a chance if
	 * it is not then do appropriate action, also we put beepers on the streets and
	 * we make sure that there is beeper on every street but not two beepers on the
	 * one street
	 */
	private void fillingWithBeepers() {
		if (frontIsClear()) {
			while (frontIsClear()) {
				puttingBeepers();
			}
		} else {
			if (!beepersPresent()) {
				putBeeper();
			} else {
				move();
				if (!beepersPresent()) {
					putBeeper();
				}
			}
		}
	}

	/*
	 * preCondition: only some street of first avenue have beepers postCondition:
	 * every street of first avenue is full of beepers and each street has only one
	 * beeper
	 */
	private void fillingPotholes() {
		turnLeft();
		fillingWithBeepers();
		turnAround();
		while (frontIsClear()) {
			checkingIfFrontIsClear();
		}
		turnLeft();
		if (frontIsClear()) {
			moveFourTimes();
		}
	}
}
