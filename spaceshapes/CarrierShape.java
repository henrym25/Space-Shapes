package spaceshapes;

import java.util.List;
import java.util.ArrayList;

/**
 * Class representing a CarrierShape Object.
 * A CarrierShape is a rectangle shape which contains other shapes
 * inside of itself(e.g. RectangleShape, OvalShape or other CarrierShapes)
 * 
 * @author Henry Man
 *
 */
public class CarrierShape extends Shape {
	
	private List<Shape> _children = new ArrayList<Shape>();


	/**
	 * Default constructor that creates a OvalShape instance with
	 * variables set to default values
	 */
	public CarrierShape() {
		super();
	}
	/**
	 * Creates CarrierShape instance with specified values for instance variables
	 * @param x x position for top left corner of bounding box
	 * @param y y position for top left corner of bounding box
	 */
	public CarrierShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates CarrierShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY deltaY speed(pixels per move call) and direction for y axis
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	/**
	 * Creates CarrierShape instance with specified values for instance variables
	 * @param x position for top left corner of bounding box
	 * @param y position for top left corner of bounding box
	 * @param deltaX speed(pixels per move call) and direction for x axis
	 * @param deltaY speed(pixels per move call) and direction for y axis
	 * @param width width in pixels
	 * @param height height in pixels
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds
	 * specified by arguments width and height
	 */
	@Override
	public void move(int width, int height) {
		super.move(width, height);
		for(Shape child: _children) {
			child.move(_width, _height);
		}
	}

	/**
	 * Paints a carrierShape object by drawing a rectangle around the edge
	 * of its bounding box. The CarrierShape object's children are then painted
	 */
	@Override
	public void paintShape(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y);
		for(Shape child: _children) {
			child.paint(painter);
		}
		painter.translate(-_x, -_y);
	}
	
	/**
	 * Attempts add a Shape to a CarrierShape object. If successful, a 
	 * two-way link is established between the CarrierShape and the newly
	 * added Shape.
	 * @param shape the shape to be added.
	 * @throws IllegalArgumentException if an attempt is made to add a Shape to a
	 * CarrierShape instance where the Shape argument is already a child
	 * within a CarrierShape instance or when an attempt is made to add a Shape that
	 * will not fit within the bounds of the proposed CarrierShape object
	 */
	void add(Shape shape) throws IllegalArgumentException{
		if(shape.parent() != null || shape.x() + shape.width() > _x + _width || shape.y() + shape.height() > _y + _height) {
			System.out.println("hi");
			throw new IllegalArgumentException();
		}
		_children.add(shape);
		shape.setParentCarrierShape(this);
	}
	
	/**
	 * Removes a particular Shape from a CarrierShape instance. Once removed,
	 * the two-way link between the CarrierShape and its former child is destroyed.
	 * This method has no effect if the Shape specified to remove is not a child
	 * of the CarrierShape.
	 * @param shape the shape to be removed.
	 */
	void remove(Shape shape) {
		_children.remove(shape);
		shape.setParentCarrierShape(null);
		
	}
	
	/**
	 * Returns the Shape at the specified position within a CarrierShape. 
	 * @param index
	 * @throws IndexOutOfBoundsException if the position specified is less 
	 * than zero or greater than the number of children stored in the CarrierShape 
	 * less one
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException{
		return _children.get(index);
	}
	
	/**
	 * Returns the number of children contained within a CarrierShape object.
	 * This method will only return the children at the top level within the callee
	 * CarrierShape object
	 */
	public int shapeCount() {
		return _children.size();
	}
	
	
	/**
	 * Returns the index of a specified child within a CarrierShape object.
	 * If the Shape specified is not actually a child of the CarrierShape
	 * this methods returns -1; otherwise the value returned is in the range
	 * 0.... shapeCount() -1.
	 * @param shape the shape whose index position within the CarrierShape
	 * is requested
	 */
	public int indexOf(Shape shape) {
		return _children.indexOf(shape);
	}
	
	/**
	 * Returns true if the Shape argument is a child of the CarrierShape
	 * object on which this method is called, false otherwise.
	 */
	public boolean contains(Shape shape) {
		return _children.contains(shape);
	}
}
