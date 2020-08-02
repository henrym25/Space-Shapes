package spaceshapes;

/**
 * Class representing representing a simple 2-D Oval shape
 * 
 * @author Henry Man
 *
 */

public class OvalShape extends Shape {	
	/**
	 * Default constructor that creates a OvalShape instance with
	 * variables set to default values
	 */
	public OvalShape() {
		super();
	}

	/**
	 * Creates OvalShape instance with specified values for instance variables
	 * @param x x position for top left corner of bounding box
	 * @param y y position for top left corner of bounding box
	 */
	public OvalShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates OvalShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY deltaY speed(pixels per move call) and direction for y axis
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates OvalShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY speed(pixels per move call) and direction for y axis
	 * @param width width in pixels
	 * @param height height in pixels
	 */
	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	/**
	 * Paints this OvalShape object using the supplied Painter object.
	 */
	@Override
	public void paintShape(Painter painter) {
		painter.drawOval(_x, _y, _width, _height);

	}

}
