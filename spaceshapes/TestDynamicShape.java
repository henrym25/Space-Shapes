package spaceshapes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in
 * the implementation of the DynamicShape Class.
 * 
 * @author Henry Man
 */

public class TestDynamicShape {
	
	private MockPainter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/**
	 * Tests a simple movement without bouncing off a edge within the 2D space
	 * by making sure it is in the correct position after it moves.
	 * The DynamicShape is initially empty with no color so is drawn 
	 * exactly the same as RectangleShape
	 */
	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(50, 200, 10, 20);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 50,200,25,35)(rectangle 60,220,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the top edge.
	 * After colliding with the top edge, the DynamicShape should then
	 * be filled with a color and start moving towards the bottom edge
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffTop() {
		DynamicShape shape = new DynamicShape(50, 10, 10, -20, new Color(100,0,0)); //Testing with a specified color in constructor
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 50,10,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(get color)(set color)(rectangle-filled 60,0,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 70,20,25,35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the bottom edge.
	 * After colliding with the bottom edge, the DynamicShape should then
	 * be filled with a color and start moving towards the top edge
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffBottom() {
		DynamicShape shape = new DynamicShape(50, 460, 10, 20); //Testing with default color
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 50,460,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(get color)(set color)(rectangle-filled 60,465,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 70,445,25,35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the left edge.
	 * After colliding with the left edge, the DynamicShape should be
	 * unfilled and start moving towards the right edge
	 * 
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffLeft() {
		DynamicShape shape = new DynamicShape(5, 100, -10, 20, new Color(100,0,0)); //Testing with a specified color in constructor
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 5,100,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(rectangle 0,120,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(rectangle 10,140,25,35)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the right edge.
	 * After colliding with the right edge, the DynamicShape should be
	 * unfilled and start moving towards the left edge
	 * 
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffRight() {
		DynamicShape shape = new DynamicShape(470, 100, 10, 20); //Testing with default color
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 470,100,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(rectangle 475,120,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(rectangle 465,140,25,35)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the top edge followed by
	 * left edge. After the first collision, the DynamicShape should be
	 * filled with color and upon hitting the left edge, will be unfilled.
	 * Therefore the final state of DynamicShape should be unfilled
	 * 
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffTopThenLeft() {
		DynamicShape shape = new DynamicShape(15, 15, -10, -20, new Color(100,0,0)); //Testing with a specified color in constructor
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 15,15,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtTopCollision = "(get color)(set color)(rectangle-filled 5,0,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtLeftCollision = "(rectangle 0,20,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(rectangle 10,40,25,35)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtTopCollision + DynamicShapeAtLeftCollision
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the right edge followed by
	 * top edge. After the first collision, the DynamicShape should be
	 * still be unfilled and upon hitting the top edge, will be filled with color.
	 * Therefore the final state of DynamicShape should be filled
	 * 
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffRightThenTop() {
		DynamicShape shape = new DynamicShape(470, 25, 10, -20); //Testing with default color
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 470,25,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtRightCollision = "(rectangle 475,5,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtTopCollision = "(get color)(set color)(rectangle-filled 465,0,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 455,20,25,35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtRightCollision + DynamicShapeAtTopCollision
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the bottom edge followed by
	 * left edge. After the first collision, the DynamicShape should be
	 * filled with color and upon hitting the left edge, will be unfilled.
	 * Therefore the final state of DynamicShape should be unfilled
	 * 
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffBottomThenLeft() {
		DynamicShape shape = new DynamicShape(15, 460, -10, 20, new Color(100,0,0)); //Testing with a specified color in constructor
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 15,460,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtBottomCollision = "(get color)(set color)(rectangle-filled 5,465,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtLeftCollision = "(rectangle 0,445,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(rectangle 10,425,25,35)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtBottomCollision + DynamicShapeAtLeftCollision
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the right edge followed by
	 * bottom edge. After the first collision, the DynamicShape should be
	 * still be unfilled and upon hitting the bottom edge, will be filled with color.
	 * Therefore the final state of DynamicShape should be filled
	 *
	 */
	@Test
	public void testDynamicShapeMoveWithBounceOffRightThenBottom() {
		DynamicShape shape = new DynamicShape(470, 440, 10, 20); //Testing with default color
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 470,440,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtRightCollision = "(rectangle 475,460,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtBottomCollision = "(get color)(set color)(rectangle-filled 465,465,25,35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 455,445,25,35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtRightCollision + DynamicShapeAtBottomCollision
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the top and left edge
	 * simultaneously. The implementation of DynamicShape checks for y-bounce first
	 * (see {@link DynamicShape#move(int, int)}) therefore the top-edge collision will take 
	 * priority and the final state of the DynamicShape should be filled
	 */
	public void testDynamicShapeMoveWithBounceOffTopAndLeft() {
		DynamicShape shape = new DynamicShape(5, 10, -10, -20, new Color(100,0,0)); //Testing with a specified color in constructor
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 5,10,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(get color)(set color)(rectangle-filled 0, 0, 25, 35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 10, 20, 25, 35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
	
	/**
	 * Tests the DynamicShape with a collision against the bottom and right edge
	 * simultaneously. The implementation of DynamicShape checks for y-bounce first
	 * (see {@link DynamicShape#move(int, int)}) therefore the bottom-edge collision will take 
	 * priority and the final state of the DynamicShape should be filled
	 */
	public void testDynamicShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(470, 460, 10, 20); //Testing with default color
		shape.paint(_painter);
		String DynamicShapeBeforeCollision = "(rectangle 470,460,25,35)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAtCollision = "(get color)(set color)(rectangle-filled 475, 465, 25, 35)(set color)";
		shape.move(500, 500);
		shape.paint(_painter);
		String DynamicShapeAfterCollision = "(get color)(set color)(rectangle-filled 465, 445, 25, 35)(set color)";
		assertEquals(DynamicShapeBeforeCollision + DynamicShapeAtCollision 
				+ DynamicShapeAfterCollision, _painter.toString());
	}
}
