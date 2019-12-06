
/*
 * File: Pyramid.java
 * Name: Natali Baidoshvili
 * Section Leader: Tato Katsitadze
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import java.awt.*;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
// in public void run I use only one method pyramid which I will describe below.
	public void run() {
		pyramid();
	}
// I use private GRect method to draw one rectangular
	private GRect drawingOneRect(int x, int a, int b) {
		GRect rect = new GRect(a, b, BRICK_WIDTH, BRICK_HEIGHT);
		add(rect);
		return rect;
	}
// I use drawingRects method to draw rectangulars as many as in the BRICKS_IN_BASE are told. I used for loop for it.
// This method only draws one horizontal line.
	private void drawingRects(int x, int a, int b) {
		for (int j = 0; j < x; j++) {
			GRect rect1 = drawingOneRect(x, a, b);
			add(rect1);
			a = a + BRICK_WIDTH;
		}
	}
// In this method I use x because I want to change rectangulars' number in each next line.
// a and b are coordinates of the first rectangular and then I change them to draw them on the other coordinates.
// I use second for loop to draw rectangulars not only horizontally but vertically too. 
// This method firstly draws one horizontal line of pyramid. Then it draws second line and it continues. 
// It won't stop until vertical lines won't be equal to BRICKS_IN_BASE
	private void pyramid() {
		int x = BRICKS_IN_BASE;
		int a = getWidth() / 2 - x * BRICK_WIDTH / 2;
		int b = getHeight() - BRICK_HEIGHT;
		for (int i = 0; i < BRICKS_IN_BASE; i++) {
			drawingRects(x, a, b);
			a = a + BRICK_WIDTH / 2;
			b = b - BRICK_HEIGHT;
			x = x - 1;
		}
	}
}
