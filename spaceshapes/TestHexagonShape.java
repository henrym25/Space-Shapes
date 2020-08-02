package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs
 * in the implementation of the HexagonShape Class
 * 
 * @author Henry Man
 */

public class TestHexagonShape {
	
	private MockPainter _painter;
	
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/**
	 * Tests a simple movement without bouncing off a edge within the 2D space
	 * by making sure it is in the correct position after it moves
	 */
	@Test
	public void testSimpleMove() {
		HexagonShape shape = new HexagonShape(255, 72, 5, 5, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 255,77,275,72)(line 275,72,327,72)"
				+ "(line 327,72,347,77)(line 347,77,327,82)(line 327,82,275,82)"
				+ "(line 275,82,255,77)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterMove = "(line 260,82,280,77)(line 280,77,332,77)"
				+ "(line 332,77,352,82)(line 352,82,332,87)(line 332,87,280,87)"
				+ "(line 280,87,260,82)";
		assertEquals(hexBeforeMove + hexAfterMove, _painter.toString());
	}
	
	/**
	 * Tests the HexagonShape with a collision against the right edge
	 * Shape should hit the edge, bounce off and move towards the left
	 */
	@Test
	public void testHexagonMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(405, 72, 5, 5, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 405,77,425,72)(line 425,72,477,72)"
				+ "(line 477,72,497,77)(line 497,77,477,82)(line 477,82,425,82)"
				+ "(line 425,82,405,77)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 408,82,428,77)(line 428,77,480,77)"
				+ "(line 480,77,500,82)(line 500,82,480,87)(line 480,87,428,87)"
				+ "(line 428,87,408,82)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 403,87,423,82)(line 423,82,475,82)"
				+ "(line 475,82,495,87)(line 495,87,475,92)(line 475,92,423,92)"
				+ "(line 423,92,403,87)";
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the HexagonShape with a collision against the left edge
	 * Shape should hit the edge, bounce off and move towards the right
	 */
	@Test
	public void testHexagonMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(2, 72, -5, 5, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 2,77,22,72)(line 22,72,74,72)"
				+ "(line 74,72,94,77)(line 94,77,74,82)(line 74,82,22,82)"
				+ "(line 22,82,2,77)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 0,82,20,77)(line 20,77,72,77)"
				+ "(line 72,77,92,82)(line 92,82,72,87)(line 72,87,20,87)"
				+ "(line 20,87,0,82)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 5,87,25,82)(line 25,82,77,82)"
				+ "(line 77,82,97,87)(line 97,87,77,92)(line 77,92,25,92)"
				+ "(line 25,92,5,87)";
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the HexagonShape with a collision against the top edge
	 * Shape should hit the edge, bounce off and move towards the bottom
	 */
	@Test
	public void testHexagonMoveWithBounceOffTop() {
		HexagonShape shape = new HexagonShape(255, 4, 5, -5, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 255,9,275,4)(line 275,4,327,4)"
				+ "(line 327,4,347,9)(line 347,9,327,14)(line 327,14,275,14)"
				+ "(line 275,14,255,9)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 260,5,280,0)(line 280,0,332,0)"
				+ "(line 332,0,352,5)(line 352,5,332,10)(line 332,10,280,10)"
				+ "(line 280,10,260,5)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 265,10,285,5)(line 285,5,337,5)"
				+ "(line 337,5,357,10)(line 357,10,337,15)(line 337,15,285,15)"
				+ "(line 285,15,265,10)";
		System.out.println(_painter.toString());
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the HexagonShape with a collision against the bottom edge
	 * Shape should hit the edge, bounce off and move towards the top
	 */
	@Test
	public void testHexagonMoveWithBounceOffBottom() {
		HexagonShape shape = new HexagonShape(255, 487, 5, 5, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 255,492,275,487)(line 275,487,327,487)"
				+ "(line 327,487,347,492)(line 347,492,327,497)(line 327,497,275,497)"
				+ "(line 275,497,255,492)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 260,495,280,490)(line 280,490,332,490)"
				+ "(line 332,490,352,495)(line 352,495,332,500)(line 332,500,280,500)"
				+ "(line 280,500,260,495)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 265,490,285,485)(line 285,485,337,485)"
				+ "(line 337,485,357,490)(line 357,490,337,495)(line 337,495,285,495)"
				+ "(line 285,495,265,490)";
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the OvalShape with two consecutive collisions.
	 * Firstly against the top and then left edge.
	 * Shape would hit the first edge, start moving in the opposite y direction
	 * then hit the second edge and move in the opposite x direction 
	 * e.g. Shape should end up traveling toward the bottom right corner
	 */
	@Test
	public void testHexagonMoveWithBounceOffTopAndLeft() {
		HexagonShape shape = new HexagonShape(3, 8, -5, -10, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 3,13,23,8)(line 23,8,75,8)"
				+ "(line 75,8,95,13)(line 95,13,75,18)(line 75,18,23,18)"
				+ "(line 23,18,3,13)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 0,5,20,0)(line 20,0,72,0)"
				+ "(line 72,0,92,5)(line 92,5,72,10)(line 72,10,20,10)"
				+ "(line 20,10,0,5)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 5,15,25,10)(line 25,10,77,10)"
				+ "(line 77,10,97,15)(line 97,15,77,20)(line 77,20,25,20)"
				+ "(line 25,20,5,15)";
		System.out.println(_painter.toString());
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the OvalShape with two consecutive collisions.
	 * Firstly against the bottom and then right edge.
	 * Shape would hit the first edge, start moving in the opposite y direction
	 * then hit the second edge and move in the opposite x direction 
	 * e.g. Shape should end up traveling toward the top left corner
	 */
	@Test
	public void testHexagonMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(405, 487, 5, 10, 92, 10);
		shape.paint(_painter);
		String hexBeforeMove = "(line 405,492,425,487)(line 425,487,477,487)"
				+ "(line 477,487,497,492)(line 497,492,477,497)(line 477,497,425,497)"
				+ "(line 425,497,405,492)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterOneMove = "(line 408,495,428,490)(line 428,490,480,490)"
				+ "(line 480,490,500,495)(line 500,495,480,500)(line 480,500,428,500)"
				+ "(line 428,500,408,495)";
		shape.move(500, 500);
		shape.paint(_painter);
		String hexAfterTwoMoves = "(line 403,485,423,480)(line 423,480,475,480)"
				+ "(line 475,480,495,485)(line 495,485,475,490)(line 475,490,423,490)"
				+ "(line 423,490,403,485)";
		assertEquals(hexBeforeMove + hexAfterOneMove + hexAfterTwoMoves, 
				_painter.toString());
	}
	
	/**
	 * Tests the construction of a "small" hexagon.
	 * A hexagon is considered small when it's width is less than or equal to 40 pixels
	 * If the hexagon is small, it will only have 4 edges
	 */
	@Test
	public void testPaintSmallHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 5, 10, 40, 30);
		shape.paint(_painter);
		String hexagonEdges = "(line 100,35,120,20)(line 120,20,140,35)"
				+ "(line 140,35,120,50)(line 120,50,100,35)";
		assertEquals(hexagonEdges, _painter.toString());
	}
	
	/**
	 * Tests the construction of a "regular" hexagon.
	 * A hexagon is considered regular when it's width is greater than 40 pixels
	 * A regular hexagon has 6 edges
	 */
	@Test
	public void testPaintRegularHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 5, 10, 41, 30);
		shape.paint(_painter);
		String hexagonEdges = "(line 100,35,120,20)(line 120,20,121,20)"
				+ "(line 121,20,141,35)(line 141,35,121,50)(line 121,50,120,50)"
				+ "(line 120,50,100,35)";
		assertEquals(hexagonEdges, _painter.toString());
	}
}
