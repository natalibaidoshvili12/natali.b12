
/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	/*
	 * Karel moves forward until it gets blocked. Then it turns right moves and
	 * turns left. Then it moves again. It picks newspaper and turns around. Then it
	 * moves forward. Turns first right, then moves and turns left. Then moves
	 * forward until it gets blocked and turns around
	 */
	public void run() {
		moveUntilStop();
		turningRightAndLeft();
		move();
		pickBeeper();
		turnAround();
		move();
		turningRightAndLeft();
		moveUntilStop();
		turnAround();
	}

	/*
	 * This helps Karel to move until front is blocked and it helps us to use less
	 * commands
	 */
	private void moveUntilStop() {
		while (frontIsClear()) {
			move();
		}
	}

	/*
	 * preCondition: Karel faces East postCondition: Karel Faces South and is on the
	 * down avenue
	 */
	private void turningRightAndLeft() {
		turnRight();
		move();
		turnLeft();
	}
}
