package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
/**
 * This class represents a 2D rectangle defined by four corner points.
 * Provides methods for construction, manipulation, and calculation related to rectangles.
 *  @author : Harel Weinberg
 *  ID: 322351883
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1,_p2,_p3,_p4;

	/**
	 * Constructs a rectangle from a formatted string containing coordinates.
	 * @param t The formatted string with coordinates.
	 */
	public Rect_2D(String t) {
		String[] a = t.split(",");
		String s1 = a[0] + "," + a[1];
		String s2 = a[2] + "," + a[3];
		String s3 = a[4] + "," + a[5];
		String s4 = a[6] + "," + a[7];

		_p1 = new Point_2D(s1);
		_p3 = new Point_2D(s2);
		_p2 = new Point_2D(s3);
		_p4 = new Point_2D(s4);
	}


	/**
	 * Constructs a rectangle from two points representing opposite corners.
	 * @param p1 One corner point of the rectangle.
	 * @param p2 The diagonally opposite corner point of the rectangle.
	 */
	public Rect_2D(Point_2D p1, Point_2D p2) {
		_p1= new Point_2D(p1);
		_p2= new Point_2D(p1.x(),p2.y());
		_p3= new Point_2D(p2);
		_p4= new Point_2D(p2.x(), p1.y());
	}


	/**
	 * Constructs a rectangle from four points representing its corners.
	 * @param p1 First corner point.
	 * @param p2 Second corner point.
	 * @param p3 Third corner point.
	 * @param p4 Fourth corner point.
	 */
	public Rect_2D(Point_2D p1, Point_2D p2,Point_2D p3,Point_2D p4) {
		_p1= new Point_2D(p1);
		_p2= new Point_2D(p3);
		_p3= new Point_2D(p2);
		_p4= new Point_2D(p4);
	}


	/**
	 * Returns a string representation of the rectangle by concatenating the string representations
	 * of its corner points.
	 * @return A string representation of the rectangle.
	 */
	@Override
	public String toString() {
		return _p1 +
				"," + _p2 +
				"," + _p3 +
				"," + _p4;
	}


	/**
	 * Checks if the current Rect object is equal to another object.
	 * @param o The object to compare with the current Rect.
	 * @return True if the objects are equal, false otherwise.
	*/
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rect_2D rect2D = (Rect_2D) o;
		Point_2D[] thisVertices = { _p1, _p2, _p3, _p4 };
		Point_2D[] thatVertices = { rect2D._p1, rect2D._p2, rect2D._p3, rect2D._p4 };
		for (int i = 0; i < thisVertices.length; i++) {
			boolean foundMatch = false;
			for (int j = 0; j < thatVertices.length; j++) {
				if (thisVertices[i].close2equals(thatVertices[j], Ex2_Const.EPS)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		return true;
	}


	/**
	 * Constructs a copy of a given rectangle.
	 * @param t1 The rectangle to copy.
	 */
	public Rect_2D(Rect_2D t1) {
		_p1= new Point_2D(t1._p1);
		_p2= new Point_2D(t1._p2);
		_p3= new Point_2D(t1._p3);
		_p4= new Point_2D(t1._p4);
	}


	/**
	 * Returns an array containing all points of the rectangle.
	 * @return An array containing the rectangle's corner points.
	 */
	public Point_2D[] getAllPoints() {
		return new Point_2D[]{new Point_2D(this._p1)
				,new Point_2D(this._p2)
				,new Point_2D(this._p3)
				,new Point_2D(this._p4)};
	}


	/**
	 * Checks if a given point is contained within a defined rectangle.
	 * @param ot The point to check.
	 * @return True if the point is contained within the rectangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		// Define a rectangle with diagonal vertices a2 and b2
		Point_2D a2 = new Point_2D(0,0);
		Point_2D b2 = new Point_2D(4,4);
		Rect_2D real = new Rect_2D(a2, b2);
		// Calculate the area of the rectangle
		double area = real.area();

		// Define the vertices of triangle formed by points a, b, and ot
		Point_2D a = new Point_2D(0,0);
		Point_2D b = new Point_2D(0,4);
		Point_2D c = new Point_2D(4,4);
		Point_2D d = new Point_2D(4,0);
		Point_2D o = new Point_2D(5,6);
		// Calculate the areas of the triangles formed by the rectangle vertices and ot
		Triangle_2D x = new Triangle_2D(a, b, o);
		double area1 = x.area();
		Triangle_2D y = new Triangle_2D(b, c, o);
		double area2 = y.area();
		Triangle_2D z = new Triangle_2D(c, d, o);
		double area3 = z.area();
		Triangle_2D t = new Triangle_2D(d, a, o);
		double area4 = t.area();

		// Calculate the sum of the areas of these triangles
		double sum = area1 + area2 + area3 + area4;

		// Check if the sum is greater than the area of the rectangle
		if (sum > area + Ex2_Const.EPS)
			return false;
		return true;
	}


	/**
	 * Calculates the area of the rectangle formed by the given corner points.
	 * @return The area of the rectangle.
	 */
	@Override
	public double area() {
		// Calculate the width and height of the rectangle using the distance between its corner points
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		// Calculate the area using width and height
		double area = a * b;
		return area;
	}


	/**
	 * Calculates the perimeter of the rectangle formed by the given corner points.
	 * @return The perimeter of the rectangle.
	 */
	@Override
	public double perimeter() {
		// Calculate the length of each side of the rectangle
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		double c = _p3.distance(_p4);
		double d = _p4.distance(_p1);
		// Calculate the perimeter by summing all side lengths
		double peri = a + b + c + d;
		return peri;
	}


	/**
	 * Translates the rectangle by the given 2D vector.
	 * @param vec The 2D vector used for translation.
	 */
	@Override
	public void translate(Point_2D vec) {
		// Translate all corner points of the rectangle by the given vector
		this._p1.move(vec);
		this._p2.move(vec);
		this._p3.move(vec);
		this._p4.move(vec);
	}


	/**
	 * Creates a copy of the rectangle.
	 * @return A new rectangle object that is a copy of this rectangle.
	 */
	@Override
	public GeoShape copy() {
		// Create a copy of the rectangle
		return new Rect_2D(this);
	}


	/**
	 * Scales the rectangle relative to the given center point and ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		// Scale all corner points of the rectangle relative to the given center point and ratio
		this._p1.scale(center, ratio);
		this._p2.scale(center, ratio);
		this._p3.scale(center, ratio);
		this._p4.scale(center, ratio);
	}


	/**
	 * Rotates the rectangle around the given center point by the specified angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		// Rotate all corner points of the rectangle around the given center point by the specified angle
		this._p1.rotate(center, angleDegrees);
		this._p2.rotate(center, angleDegrees);
		this._p3.rotate(center, angleDegrees);
		this._p4.rotate(center, angleDegrees);
	}

}
