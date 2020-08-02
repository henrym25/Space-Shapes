package spaceshapes;
/**
 * Class representing a simple 2-D Hexagon Shape
 * 
 * @author Henry Man
 *
 */
public class HexagonShape extends Shape {
	
	/**
	 * Default constructor that creates a HexagonShape instance with
	 * variables set to default values
	 */
	public HexagonShape() {
		super();
	}
	
	/**
	 * Creates HexagonShape instance with specified values for instance variables
	 * @param x x position for top left corner of bounding box
	 * @param y y position for top left corner of bounding box
	 */
	public HexagonShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates HexagonShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY deltaY speed(pixels per move call) and direction for y axis
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates HexagonShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY speed(pixels per move call) and direction for y axis
	 * @param width width in pixels
	 * @param height height in pixels
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	/**
	 * Paints this HexagonShape object using the supplied Painter object.
	 * HexagonShapes with a width <= 40 are "small" hexagons and will only have 4 edges
	 * HexagonShapes with a width > 40 are "regular" hexagons and will have 6 edges
	 */
	@Override
	public void paintShape(Painter painter) {		
		if(_width <= 40) {//Small Hexagon
			painter.drawLine(_x, _y+_height/2, _x + _width/2, _y);
			painter.drawLine(_x +_width/2, _y, _x + _width, _y + _height/2);
			painter.drawLine(_x + _width, _y + _height/2, _x + _width/2, _y + _height);
			painter.drawLine( _x + _width/2, _y + _height, _x, _y + _height/2);
		} else {//Regular Hexagon
			painter.drawLine(_x, _y + _height/2, _x + 20, _y);
			painter.drawLine(_x + 20, _y, _x + _width - 20, _y);
			painter.drawLine(_x + _width - 20, _y, _x + _width, _y + _height/2);
			painter.drawLine(_x + _width, _y + _height/2, _x + _width-20, _y + _height);
			painter.drawLine(_x + _width - 20, _y + _height, _x + 20, _y + _height);
			painter.drawLine(_x + 20, _y + _height, _x, _y + _height/2);
		}
	}

}
