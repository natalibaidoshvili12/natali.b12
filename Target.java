
/*
 * File: Target.java
 * Name: Natali Baidoshvili
 * Section Leader: Tato Katsitadze
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.graphics.*;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import java.awt.*;
import acm.program.GraphicsProgram;

public class Target extends GraphicsProgram {
	/*
	 * I use Diameters instead of radiuses because for me it's easier to calculate
	 * and if anyone wants to change circles radiuses, they have to multiply to 2
	 * (D=2R)
	 */
	private static final double RADIUS_BIG = 72;
	private static final double RADIUS_MIDDLE = 46.8;
	private static final double RADIUS_SMALL = 21.6;
	private static final double DIAMETER_BIG = 2 * RADIUS_BIG;
	private static final double DIAMETER_MIDDLE = 2 * RADIUS_MIDDLE;
	private static final double DIAMETER_SMALL = 2 * RADIUS_SMALL;

// I draw firstly big circle because if I draw middle circle first we can't notice if it is there or not.
// it's because middle circle's color is white.
// and if I drew small circle it would be covered by middle and big circle and we couldn't notice middle and small circle.
	public void run() {
		big();
		middle();
		small();
	}

	/*
	 * I use (x; y) as a middle point of the window In big(), small() and middle() I
	 * add First circle. I use getWidth and getHeight to calculate circle's
	 * coordinates. I use (x-DIAMETER/2; y-DIAMETER/2) as coordinates because that
	 * is the point where circle starts and each circles' center would be the middle
	 * point of the window Then I set color and set fill color in each method.
	 */
// x and y are coordinates of the middle point of the window in every method
// I calculate big circle's coordinates. Then I fill it inside with red color and I set it's color (red) 
	private void big() {
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		GOval big = new GOval(x - DIAMETER_BIG / 2, y - DIAMETER_BIG / 2, DIAMETER_BIG, DIAMETER_BIG);
		big.setFilled(true);
		big.setFillColor(Color.RED);
		big.setColor(Color.RED);
		add(big);
	}
// I calculate middle circle's coordinates. Then I fill it inside with white color and I set it's color (white)
	private void middle() {
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		GOval middle = new GOval(x - DIAMETER_MIDDLE / 2, y - DIAMETER_MIDDLE / 2, DIAMETER_MIDDLE, DIAMETER_MIDDLE);
		middle.setFilled(true);
		middle.setFillColor(Color.WHITE);
		middle.setColor(Color.WHITE);
		add(middle);
	}
// I calculate small circle's coordinates. Then I fill it inside with red color and I set it's color (as red)
// small middle and big circles three of them are concentric circle's and their center's coordinates are the same.
// but their coordinates change by their radiuses because GOval draws circles by it's start point.
	private void small() {
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		GOval small = new GOval(x - DIAMETER_SMALL / 2, y - DIAMETER_SMALL / 2, DIAMETER_SMALL, DIAMETER_SMALL);
		small.setFilled(true);
		small.setFillColor(Color.RED);
		small.setColor(Color.RED);
		add(small);
	}
}
