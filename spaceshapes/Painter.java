package spaceshapes;

import java.awt.Color;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Draws a filled rectangular shape with the specified color
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Gets the current color of the painter object
	 * @return The painter's current color
	 */
	public Color getColor();
	
	/**
	 * Sets the color of the painter to the specified color
	 * @param color color which painter is to be changed to
	 */
	public void setColor(Color color);
	
	/**
	 * Sets origins of coordinate system to be at the specified coordinates
	 * @param x x coordinate for new origin
	 * @param y y coordinate for new origin
	 */
	public void translate(int x, int y);
	
	/**
	 * Draws text provided centered vertically and horizontally within
	 * a shape
	 * @param string String containing text to draw
	 * @param shape Shape which contains text which needs to be drawn
	 */
	public void drawCenteredText(String string, Shape shape);
}
