
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	/*
	 * Karel checks if front is clear. If it is not then turns left and checks it
	 * again. If it is not again, puts beeper. If it is while front is clear it does
	 * putBeeperAndSkip method. And if first time front is clear, Karel puts beeper
	 * and skips one step. Then it moves backward until front is clear. Then turns
	 * right goes up turns left, skips one step and then puts beeper. Then it goes
	 * back again. And Karel does this until front is clear.
	 */
	public void run() {
		if (frontIsClear()) {
			
		} else {
			turnLeft();
			if (frontIsClear()) {
				while (frontIsClear()) {
					putBeeperAndSkip();
				}
			} else {
				putBeeper();
			}
		}
	}
	/*
	 * preCondition: First street is empty postCondition: avenues of first street
	 * has beepers with one leap, for example 1x1 has beeper and 1x2 hasn't This
	 * method helps us to fill Karel's world like chess. This method fills only odd
	 * streets
	 */

	private void putBeeperAndSkip() {
		while (frontIsClear()) {
			putBeeper();
			move();
			if (frontIsClear()) {
				move();
			}
		}
		turningAroundAndMove();
		if (beepersPresent()) {
			turningAroundAndMove();
		} else {
			turningAroundAndMove();
			putBeeper();
		}
	}

	/*
	 * preCondition: first street is filled with beepers like chess but not other
	 * streets are full of beepers postCondition: second street is full of beepers
	 * with one leap between two beepers This method helps us to fill Karel's world
	 * like chess too. It is only used for even streets
	 */
	private void skipAndPutBeeper() {
		while (frontIsClear()) {
			move();
			putBeeper();
			if (frontIsClear()) {
				move();
			}
		}
	}

	/*
	 * This action helps us to move backward and we start new action from were we
	 * started filling avenues with beepers
	 */
	private void movingBackward() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnRight();
		if (frontIsClear()) {
			move();
			turnRight();
		}
	}

// Karel turns around and moves forward.
	private void turningAroundAndMove() {
		turnAround();
		move();
	}
	private void checkerBoard() {
		while (frontIsClear()) {
			putBeeperAndSkip();
			movingBackward();
			skipAndPutBeeper();
			movingBackward();
		}
	}
}
