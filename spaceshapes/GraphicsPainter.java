package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	/**
	 * @see spaeshapes.Painter.fillRect.
	 */
	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
		
	}

	/**
	 * @see spaeshapes.Painter.getColor.
	 */
	@Override
	public Color getColor() {
		return _g.getColor();
	}

	/**
	 * @see spaeshapes.Painter.setColor
	 */
	@Override
	public void setColor(Color color) {
		_g.setColor(color);
		
	}

	/**
	 * @see spaeshapes.Painter.translate.
	 */
	@Override
	public void translate(int x, int y) {
		_g.translate(x, y);	
	}

	/**
	 * @see spaeshapes.Painter.drawCenteredText.
	 */
	@Override
	public void drawCenteredText(String string, Shape shape) {
		FontMetrics font = _g.getFontMetrics();
		
		int stringWidth = font.stringWidth(string);
		int ascent = font.getMaxAscent();
		int descent = font.getMaxDescent();
		
		int x = (shape.x() + (shape.width() / 2)) - (stringWidth / 2);
		int y = (shape.y() + (shape.height() / 2));
		
		if(ascent > descent) {
			y += (ascent - descent) / 2;
		} else if(ascent < descent) {
			y -= (ascent - descent) / 2;
		}
		_g.drawString(string, x, y);
	}
}
