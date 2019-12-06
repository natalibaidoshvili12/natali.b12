
/*
 * File: Breakout.java
 * -------------------
 * Name: Natali Baidoshvili	
 * Section Leader: Tato Katsitadze
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	/* Method: run() */
	/** Runs the Breakout program. */
	GRect paddle;
	GRect ball;
	private double vx; // is the x coordinate of the ball velocity
	private double vy; // is the y coordinate of the ball velocity
	private RandomGenerator rgen = RandomGenerator.getInstance(); // using for changing vx as a random
	private static final int PAUSE_TIME = 15; // using it as ball's velocity too.
	private GRect brick;
	private GObject object;

// I have two parts in run, drawing the whole board and moving them.
	public void run() {

		drawingBoard();
		ballMoving();

	}

	/*
	 * In this void I am defining nLives as NTURNS and nBricks as multiplied
	 * NBRICK_ROWS and NBRICKS_PER_ROW. Then I am defining the velocity of the ball.
	 * Then I am using while loop and moving the ball with the velocity. I am
	 * checking if the X coordinate of the ball is equal or larger than 0, width and
	 * I am changing the direction. If the Y coordinate of the ball is equal to 0,
	 * direction changes. And if it is larger then paddle's y coordinate, then I am
	 * taking one from nLives and game starts again. When nLives will be equal to
	 * zero, game is over and the player lost the game.
	 */
	private void ballMoving() {
		addMouseListeners();
		int nLives = NTURNS;
		int nBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
		velocity();
		while (true) {
			ball.move(vx, vy);
			checkingObject(nBricks);
			if (ball.getX() <= -vx || ball.getX() + 2 * BALL_RADIUS >= WIDTH - vx) {
				vx = -vx;
			} else if (ball.getY() <= 0) {
				vy = -vy;
			} else if (ball.getY() >= getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT) {
				nLives = nLives - 1;
				if (nLives > 0) {
					remove(ball);
					ball.setLocation(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS);
					pause(300);
					add(ball);
				} else if (nLives == 0) {
					removeAll();
					losing();
					break;
				}
			}
			pause(PAUSE_TIME);
		}
	}

	// In this void I am defining velocity of the ball

	private void velocity() {
		vy = +3;
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) {
			vx = -vx;
		}

	}

	/*
	 * I am checking if the ball is touching the object, if the object is the paddle
	 * I am changing the direction, but if it is brick I am removing brick and changing
	 * direction at the same time. I am also counting Bricks and if nBrick = 0,
	 * then player won the game. And the game is over
	 */
	private void checkingObject(int nBricks) {
		object = checking();
		if (object == paddle) {
			vy = -vy;
		} else if (ball.getX() == paddle.getX() || ball.getX() == paddle.getX() + PADDLE_WIDTH) {
			vy = -vy;
		} else if (object != null) {
			remove(object);
			nBricks = nBricks - 1;
			vy = -vy;
			if (nBricks == 0) {
				removeAll();
				winning();
			}
		}
	}

// In this void I am writing GLabel if the player lost the game.
	private void losing() {
		GLabel losing = new GLabel("You lost", 0, 0);
		losing.setFont(new Font("SANS_SERIF", Font.BOLD, 40));
		double a = losing.getAscent();
		double b = losing.getWidth();
		losing.setLocation(getWidth() / 2 - b / 2, HEIGHT / 2 - a / 2);
		losing.setColor(Color.RED);
		add(losing);
	}

	// In this void I am writing GLabel if the player win the game and cleared all
	// the bricks.
	private void winning() {
		GLabel winning = new GLabel("You Won", 0, 0);
		winning.setFont(new Font("SANS_SERIF", Font.BOLD, 40));
		double a = winning.getAscent();
		double b = winning.getWidth();
		winning.setLocation(getWidth() / 2 - b / 2, HEIGHT / 2 - a / 2);
		winning.setColor(Color.GREEN);
		add(winning);
	}

// I am using getElementAt method to check if the object is at the same coordinates where the ball is.
	public GObject checking() {
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY()) != null) {
			return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY());
		} else if (getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS) != null) {
			return getElementAt(ball.getX() + 2 * BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS);
		} else if (getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS) != null) {
			return getElementAt(ball.getX(), ball.getY() + 2 * BALL_RADIUS);
		} else {
			return null;
		}
	}

	/*
	 * I use mouseMoved method to move paddle with mouse moves. I use if loop
	 * because paddle should not be gone outside the window
	 */
	public void mouseMoved(MouseEvent e) {
		if (e.getX() <= getWidth() - PADDLE_WIDTH && e.getX() >= 0) {
			paddle.setLocation(e.getX(), paddle.getY());
		}
	}

	/*
	 * I use drawingBoard method to draw the whole board. I use for loop for drawing
	 * bricks. Then I draw paddle and I set its color. Lastly I draw ball and set
	 * its color
	 */

	private void drawingBoard() {
		int x = BRICK_SEP / 2;
		int y = BRICK_Y_OFFSET;
		for (int i = 0; i < NBRICKS_PER_ROW; i++) {
			drawOneLine(x, y);
			y = y + BRICK_HEIGHT + BRICK_SEP;
		}
		paddle = new GRect(0, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
		add(paddle);
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);
		ball = new GRect(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		ball.setFillColor(Color.BLACK);
		add(ball);
	}

	/*
	 * I use drawOneLine method to draw one horizontal line with bricks and they are
	 * colored by their y coordinate
	 */
	private void drawOneLine(int x, int y) {

		for (int i = 0; i < NBRICK_ROWS; i++) {
			brick = drawingOneRect(x, y);
			add(brick);
			x = x + BRICK_WIDTH + BRICK_SEP;
		}
	}

	/*
	 * I use drawingOneRect method to draw one brick and I define with if and else
	 * if loops its color. I used int a,b,c to learn on what coordinates are bricks
	 * and they are colored by their y coordinate. I only used a b and c because it
	 * would be easier to read
	 */
	private GRect drawingOneRect(int x, int y) {
		GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(rect);
		rect.setFilled(true);
		int a = BRICK_Y_OFFSET;
		int b = BRICK_HEIGHT;
		int c = BRICK_SEP;
		if (y >= a && y <= a + b + c) {
			rect.setColor(Color.RED);
			rect.setFillColor(Color.RED);
		} else if (y >= a + 2 * b + 2 * c && y <= a + 3 * b + 3 * c) {
			rect.setColor(Color.ORANGE);
			rect.setFillColor(Color.ORANGE);
		} else if (y >= a + 4 * b + 4 * c && y <= a + 5 * b + 5 * c) {
			rect.setColor(Color.YELLOW);
			rect.setFillColor(Color.YELLOW);
		} else if (y >= a + 6 * b + 6 * c && y <= a + 7 * b + 7 * c) {
			rect.setColor(Color.GREEN);
			rect.setFillColor(Color.GREEN);
		} else if (y >= a + 8 * b + 8 * c && y <= a + 9 * b + 9 * c) {
			rect.setColor(Color.CYAN);
			rect.setFillColor(Color.CYAN);
		}
		return rect;
	}
}
