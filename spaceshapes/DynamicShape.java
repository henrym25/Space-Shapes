package spaceshapes;
import java.awt.Color;

/**
 * Class representing a DynamicShape in the shape of a Rectangle.
 * A DynamicShape is filled with color when it hits either the top or bottom edge of the 2-D world
 * and gets unfilled when it hits either the left or right edge of the 2-D world
 * 
 * @author Henry Man
 */

public class DynamicShape extends Shape {
	
	//Color to fill shape with. Set to white by default.
	private Color _shapeColor = new Color(255, 255, 255);
	private boolean _fill = false; //Keeps track of whether the shape should be filled or not

	/**
	 * Default constructor that creates a DynamicShape instance with
	 * variables set to default values
	 */
	public DynamicShape() {
		super();
	}
		
	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x x position for top left corner of bounding box
	 * @param y y position for top left corner of bounding box
	 */
	public DynamicShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x x position for top left corner of bounding box
	 * @param y y position for top left corner of bounding box
	 * @param color color object that specifies what color the DynamicShape should be filled with
	 */
	public DynamicShape(int x, int y, Color color) {
		super(x, y);
		_shapeColor = color;
	}
	
	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY deltaY speed(pixels per move call) and direction for y axis
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY deltaY speed(pixels per move call) and direction for y axis
	 * @param color color object that specifies what color the DynamicShape should be filled with
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, Color color) {
		super(x, y, deltaX, deltaY);
		_shapeColor = color;
	}

	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY speed(pixels per move call) and direction for y axis
	 * @param width width in pixels
	 * @param height height in pixels
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
		
	/**
	 * Creates DynamicShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY speed(pixels per move call) and direction for y axis
	 * @param width width in pixels
	 * @param height height in pixels
	 * @param color color object that specifies what color the DynamicShape should be filled with
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
		super(x, y, deltaX, deltaY, width, height);
		_shapeColor = color;
	}
	
	/**
	 * Moves the DynamicShape and upon hitting a wall, decides whether the
	 * shape should be filled or unfilled and updates the state
	 * 
	 * NOTE: As a y-collision is checked first, it will always have priority over
	 * x-collisions if they happen simultaneously. Therefore the shape will come out as
	 * filled if they happen simultaneously.
	 */
	@Override
	public void move(int width, int height) {
		super.move(width, height); //Moves the DynamicShape
		
		//Checks for collision and updates filled state
		if(_y == 0 || _y + _height == height) {//Top and bottom collisions
			_fill = true;
		} else if (_x == 0 || _x + _width == width){//Left and right collisions
			_fill = false;
		}
	}
	
	/*
	 * Paints this DynamicShape object using specified painter object
	 * Painter will paint an unfilled or filled rectangle based on the current
	 * state of DynamicShape
	 */
	@Override
	public void paintShape(Painter painter) {
		if(_fill) {
			Color color = painter.getColor();
			painter.setColor(_shapeColor);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(color);
		} else {
			painter.drawRect(_x, _y, _width, _height);
		}
	}
}
