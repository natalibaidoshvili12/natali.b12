
/*
 * File: ProgramHierarchy.java
 * Name: Natali Baidoshvili	
 * Section Leader: Tato Katsitadze
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.graphics.*;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.program.ConsoleProgram;
import java.awt.*;
import acm.program.GraphicsProgram;

public class ProgramHierarchy extends GraphicsProgram {
	private static final double RECT_WIDTH = 150;
	private static final double RECT_HEIGHT = 60;

// First I add the first rectangular on the window. Its text is program.
// Then I add the second rectangular on the window. Its text is graphics Program.
// Then I add the third rectangular. Its text says console Program.
// Then I add the fourth rectangular. Its text says dialog Program.
// Finally I add the lines among the rectangulars.
	public void run() {
		program();
		graphicsProgram();
		consoleProgram();
		dialogProgram();
		addingLines();
	}

	/*
	 * In every method these commands are the same: space between program and
	 * graphics program rectangulars which I use is equal to RECT_HEIGHT / 2 space
	 * between horizontal rectangulars which I use is equal to RECT_WIDTH / 2 I use
	 * x and y as coordinates of the middle point of the window a and b are the
	 * width and the height of the text
	 */
	/*
	 * I calculate first rectangular's coordinates and I give it width and height, I
	 * described it in private static final. Then I add label which says "program"
	 * Then I described text's height and width and used it to calculate where the
	 * text has to start because it needs to be in the middle of the rectangular.
	 */
	private void program() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GRect program = new GRect(x - RECT_WIDTH / 2, y - 5 * RECT_HEIGHT / 4, RECT_WIDTH, RECT_HEIGHT);
		add(program);
		GLabel program1 = new GLabel("Program", x - RECT_WIDTH / 2, y - 5 * RECT_HEIGHT / 4);
		double a = program1.getWidth();
		double b = program1.getAscent();
		program1.move(RECT_WIDTH / 2 - a / 2, RECT_HEIGHT / 2 + b / 2);
		add(program1);
	}

	/*
	 * I calculated second rectangular's coordinates and I give it width and height.
	 * I added label to print a text in the rectangular. I calculated with a and b
	 * text's width and height and I moved it to the center of the rectangular
	 */
	private void graphicsProgram() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GRect graphicsProgram = new GRect(x - 7 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4, RECT_WIDTH, RECT_HEIGHT);
		add(graphicsProgram);
		GLabel graphicsProgram1 = new GLabel("GraphicsProgram", x - 7 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4);
		double a = graphicsProgram1.getWidth();
		double b = graphicsProgram1.getAscent();
		graphicsProgram1.move(RECT_WIDTH / 2 - a / 2, RECT_HEIGHT / 2 + b / 2);
		add(graphicsProgram1);
	}

	/*
	 * I calculated third rectangular's coordinates. I printed a text and then I
	 * moved it. I used move method instead of setLocation, because for me it was
	 * easier. I printed rectangular's coordinates in the label's coordinates and
	 * then I moved it with the coordinates int the move command
	 */
	private void consoleProgram() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GRect consoleProgram = new GRect(x - RECT_WIDTH / 2, y + RECT_HEIGHT / 4, RECT_WIDTH, RECT_HEIGHT);
		add(consoleProgram);
		GLabel consoleProgram1 = new GLabel("ConsoleProgram", x - RECT_WIDTH / 2, y + RECT_HEIGHT / 4);
		double a = consoleProgram1.getWidth();
		double b = consoleProgram1.getAscent();
		consoleProgram1.move(RECT_WIDTH / 2 - a / 2, RECT_HEIGHT / 2 + b / 2);
		add(consoleProgram1);
	}

// I use same methods in dialogProgram because it does with the same logic.
	private void dialogProgram() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GRect dialogProgram = new GRect(x + 3 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4, RECT_WIDTH, RECT_HEIGHT);
		add(dialogProgram);
		GLabel dialogProgram1 = new GLabel("DialogProgram", x + 3 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4);
		double a = dialogProgram1.getWidth();
		double b = dialogProgram1.getAscent();
		dialogProgram1.move(RECT_WIDTH / 2 - a / 2, RECT_HEIGHT / 2 + b / 2);
		add(dialogProgram1);
	}

	/*
	 * I started driving lines from the same spot. It is on the down line of the
	 * program (GRect) and it is in the middle of the line. I stop lines on the each
	 * rectangulars' top line and each of them is in the middle of the top line.
	 */
	private void addingLines() {
		double x = getWidth() / 2;
		double y = getHeight() / 2;
		GLine line1 = new GLine(x, y - RECT_HEIGHT / 4, x, y + RECT_HEIGHT / 4);
		add(line1);
		GLine line2 = new GLine(x, y - RECT_HEIGHT / 4, x - 5 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4);
		add(line2);
		GLine line3 = new GLine(x, y - RECT_HEIGHT / 4, x + 5 * RECT_WIDTH / 4, y + RECT_HEIGHT / 4);
		add(line3);
	}
}
