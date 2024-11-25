package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.*;
import java.awt.*;
import java.util.Objects;
/**
 * This class implements the GUI_Shape interface and represents a graphical shape in the application.
 * It encapsulates a GeoShape object, fill status, color, tag, and selection status.
 *
 * @auther: Harel Weinberg
 * ID: 322351883
 */

public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;


	/**
	 * Constructs a new GUIShape object with the provided parameters.
	 * @param g The GeoShape object to associate with the GUIShape. If null, no GeoShape will be associated.
	 * @param f The fill status indicating whether the shape should be filled or not.
	 * @param c The color of the shape.
	 * @param t The tag value associated with the shape.
	 * @return A new GUIShape object initialized with the provided parameters.
	 */
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}


	/**
	 * Constructs a new GUIShape object by copying another GUIShape object.
	 * @param ot The GUIShape object to copy.
	 * @return A new GUIShape object initialized with the same properties as the provided GUIShape.
	 */
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}


	/**
	 * Constructs a new GUIShape object based on the string representation.
	 * @param s The string representation containing color, fill status, tag, and shape details.
	 * @return A new GUIShape object initialized with the properties parsed from the string.
	 * @throws IllegalArgumentException If the shape type in the string is unknown.
	 */
	public GUIShape(String s) {
		String[] parts = s.split(",");
		int rgb = Integer.parseInt(parts[1]);
		_color = new Color(rgb);
		_fill = Boolean.parseBoolean(parts[2]);
		_tag = Integer.parseInt(parts[3]);
		String shapeType = parts[4];
		GeoShape geoShape = null;
		switch (shapeType) {
			case "Circle_2D":
				double centerX = Double.parseDouble(parts[5]);
				double centerY = Double.parseDouble(parts[6]);
				double radius = Double.parseDouble(parts[7]);
				geoShape = new Circle_2D(new Point_2D(centerX, centerY), radius);
				break;
			case "Rect_2D":
				double x1 = Double.parseDouble(parts[5]);
				double y1 = Double.parseDouble(parts[6]);
				double x2 = Double.parseDouble(parts[7]);
				double y2 = Double.parseDouble(parts[8]);
				double x3 = Double.parseDouble(parts[9]);
				double y3 = Double.parseDouble(parts[10]);
				double x4 = Double.parseDouble(parts[11]);
				double y4 = Double.parseDouble(parts[12]);
				geoShape = new Rect_2D(new Point_2D(x1, y1), new Point_2D(x3, y3), new Point_2D(x2, y2), new Point_2D(x4, y4));

				break;

			case "Segment_2D":
				double x1s = Double.parseDouble(parts[5]);
				double y1s = Double.parseDouble(parts[6]);
				double x2s = Double.parseDouble(parts[7]);
				double y2s = Double.parseDouble(parts[8]);
				geoShape = new Segment_2D(new Point_2D(x1s, y1s), new Point_2D(x2s, y2s));

				break;

			case "Triangle_2D":
				for (int i = 0; i < parts.length; i++) {
					System.out.println(parts[i]);
				}

				double x1t = Double.parseDouble(parts[5]);
				double y1t = Double.parseDouble(parts[6]);
				double x2t = Double.parseDouble(parts[7]);
				double y2t = Double.parseDouble(parts[8]);
				double x3t = Double.parseDouble(parts[9]);
				double y3t = Double.parseDouble(parts[10]);
				geoShape = new Triangle_2D(new Point_2D(x1t, y1t), new Point_2D(x2t, y2t), new Point_2D(x3t, y3t));

				break;

			case "Polygon_2D":
				double[] coordinates = new double[(parts.length - 5)];
				for (int i = 0; i < (parts.length - 5); i++) {
					coordinates[i] = Double.parseDouble(parts[5 + i]);
				}

				int numPoints = coordinates.length / 2;
				Point_2D[] points = new Point_2D[numPoints];
				for (int i = 0; i < numPoints; i++) {
					points[i] = new Point_2D(coordinates[i * 2], coordinates[i * 2 + 1]);
				}

				geoShape = new Polygon_2D(points);

				break;

			default:
				throw new IllegalArgumentException("Unknown shape type: " + shapeType);
		}

		_g = geoShape;
	}


	/**
	 * Retrieves the GeoShape associated with this GUIShape.
	 * @return The GeoShape object associated with this GUIShape.
	 */
	@Override
	public GeoShape getShape() {
		return _g;
	}


	/**
	 * Sets the GeoShape associated with this GUIShape.
	 * @param g The GeoShape object to associate with this GUIShape.
	 */
	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}


	/**
	 * Checks if this GUIShape is filled.
	 * @return True if the GUIShape is filled, false otherwise.
	 */
	@Override
	public boolean isFilled() {
		return _fill;
	}


	/**
	 * Sets the fill status of this GUIShape.
	 * @param filled True to fill the GUIShape, false to leave it unfilled.
	 */
	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}


	/**
	 * Retrieves the color of this GUIShape.
	 * @return The color of this GUIShape.
	 */
	@Override
	public Color getColor() {
		return _color;
	}


	/**
	 * Sets the color of this GUIShape.
	 * @param cl The color to set for this GUIShape.
	 */
	@Override
	public void setColor(Color cl) {
		_color = cl;
	}


	/**
	 * Retrieves the tag associated with this GUIShape.
	 * @return The tag value associated with this GUIShape.
	 */
	@Override
	public int getTag() {
		return _tag;
	}


	/**
	 * Sets the tag value associated with this GUIShape.
	 * @param tag The tag value to set for this GUIShape.
	 */
	@Override
	public void setTag(int tag) {
		_tag = tag;
	}


	/**
	 * Creates a copy of this GUI_Shape.
	 * @return A copy of this GUI_Shape.
	 */
	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}


	/**
	 * Returns a string representation of this GUIShape.
	 * @return A string representing this GUIShape.
	 */
	@Override
	public String toString() {
		String ans = this.getClass().getSimpleName()+","+colorencoding(_color)+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}


	/**
	 * Encodes a Color object into an integer representation.
	 * @param c The Color object to encode.
	 * @return An integer representing the Color object.
	 */
	public static int colorencoding(Color c) {
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r * 256 * 256 + g * 256 + b;
		return ce;
	}


	/**
	 * Checks if this GUIShape is selected.
	 * @return True if the GUIShape is selected, false otherwise.
	 */
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}


	/**
	 * Sets the selection status of this GUIShape.
	 * @param s True to select the GUIShape, false to deselect it.
	 */
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}


	/**
	 * Indicates whether some other object is "equal to" this one.
	 * @param o The reference object with which to compare.
	 * @return True if this object is the same as the o argument; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GUIShape guiShape = (GUIShape) o;
		return _fill == guiShape._fill && _tag == guiShape._tag && _isSelected == guiShape._isSelected && Objects.equals(_g, guiShape._g) && Objects.equals(_color, guiShape._color);
	}

}
