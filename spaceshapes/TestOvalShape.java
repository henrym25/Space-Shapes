package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementation of the OvalShape Class.
 * 
 * @author Henry Man
 * 
 */

public class TestOvalShape {

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
			OvalShape shape = new OvalShape(100, 20, 12, 15);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", 
					_painter.toString());
		}
		
		/**
		 * Tests the OvalShape with a collision against the right edge
		 * Shape should hit the edge, bounce off and move towards the left
		 */
		@Test
		public void testShapeMoveWithBounceOffRight() {
			OvalShape shape = new OvalShape(100, 20, 12, 15);
			shape.paint(_painter);
			shape.move(135, 10000);
			shape.paint(_painter);
			shape.move(135, 10000);
			shape.paint(_painter);
			assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
					+ "(oval 98,50,25,35)", _painter.toString());
		}
		
		/**
		 * Tests the OvalShape with a collision against the left edge
		 * Shape should hit the edge, bounce off and towards the right
		 */
		@Test
		public void testShapeMoveWithBounceOffLeft() {
			OvalShape shape = new OvalShape(10, 20, -12, 15);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			shape.move(10000, 10000);
			shape.paint(_painter);
			assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
					+ "(oval 12,50,25,35)", _painter.toString());
		}
		
		/**
		 * Tests the OvalShape with a collision against the top edge
		 * Shape should hit the edge, bounce off and towards the bottom
		 */
		@Test
		public void testShapeMoveWithBounceOffTop() {
			OvalShape shape = new OvalShape(100, 3, 10, -15);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(oval 100,3,25,35)(oval 110,0,25,35)(oval 120,15,25,35)", _painter.toString());
		}
		
		/**
		 * Tests the OvalShape with a collision against the bottom edge
		 * Shape should hit the edge, bounce off and move towards the top
		 */
		@Test
		public void testShapeMoveWithBounceOffBottom() {
			OvalShape shape = new OvalShape(100, 462, 10, 15);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(oval 100,462,25,35)(oval 110,465,25,35)(oval 120,450,25,35)", _painter.toString());
		}

		/**
		 * Tests the OvalShape with two consecutive collisions.
		 * Firstly against the top and then then right edge.
		 * Shape would hit the first edge, start moving in the opposite y direction
		 * then hit the second edge and move in the opposite x direction 
		 * e.g. Shape should end up traveling toward the bottom left corner
		 */
		@Test
		public void testShapeMoveWithBounceOffTopAndRight() {
			OvalShape shape = new OvalShape(471, 3, 10, -15);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			shape.move(500, 500);
			shape.paint(_painter);
			assertEquals("(oval 471,3,25,35)(oval 475,0,25,35)(oval 465,15,25,35)", _painter.toString());
		}
		
		/**
		 * Tests the OvalShape with two consecutive collisions.
		 * Firstly against the top and then then right edge.
		 * Shape would hit the first edge, start moving in the opposite y direction
		 * then hit the second edge and move in the opposite x direction 
		 * e.g. Shape should end up traveling towards the top right corner
		 */
		@Test
		public void testShapeMoveWithBounceOffBottomAndLeft() {
			OvalShape shape = new OvalShape(10, 90, -12, 15);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			shape.move(125, 135);
			shape.paint(_painter);
			assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
					+ "(oval 12,85,25,35)", _painter.toString());
		}
}
