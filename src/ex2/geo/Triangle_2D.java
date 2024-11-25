package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
/**
 * This class represents a 2D triangle defined by three corner points.
 * Provides methods for construction, manipulation, and calculation related to triangles.
 * Author: Harel Weinberg
 * ID: 322351883
 */
public class Triangle_2D implements GeoShape {

	// Points of the triangle
	private Point_2D _p1, _p2, _p3;

	/**
	 * Constructs a triangle with three given points.
	 * @param p1 The first point.
	 * @param p2 The second point.
	 * @param p3 The third point.
	 */
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		_p1 = new Point_2D(p1);
		_p2 = new Point_2D(p2);
		_p3 = new Point_2D(p3);
	}


	/**
	 * Constructs a copy of a given triangle.
	 * @param t1 The triangle to copy.
	 */
	public Triangle_2D(Triangle_2D t1) {
		this(t1._p1, t1._p2, t1._p3);
	}


	/**
	 * Returns a string representation of the triangle by concatenating the string representations of its vertices.
	 * @return A string representation of the triangle.
	 */
	@Override
	public String toString() {
		return _p1.toString() + "," + _p2.toString() + "," + _p3.toString();
	}


	/**
	 * Checks if the current Triangle object is equal to another object.
	 * @param o The object to compare with the current Triangle.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;
		Point_2D[] thisVertices = {_p1, _p2, _p3};
		Point_2D[] thatVertices = {that._p1, that._p2, that._p3};
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
	 * Constructs a triangle from a formatted string containing coordinates.
	 * @param t The formatted string with coordinates.
	 */
	public Triangle_2D(String t) {
		String[] a = t.split(",");
		String s1 = a[0] + "," + a[1];
		String s2 = a[2] + "," + a[3];
		String s3 = a[3] + "," + a[4];

		_p1 = new Point_2D(s1);
		_p2 = new Point_2D(s2);
		_p3 = new Point_2D(s3);

	}


	/**
	 * Returns an array containing all points of the triangle.
	 * @return An array containing the triangle's points.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D [] points = {_p1 , _p2 , _p3};
		return points;
	}


	/**
	 * Checks if a given point is inside the triangle.
	 * @param ot The point to check.
	 * @return True if the point is inside the triangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Point_2D a = new Point_2D(0,0);
		Point_2D b = new Point_2D(3,0);
		Point_2D c = new Point_2D(0,4);
		Point_2D o = new Point_2D(5,6);
		Triangle_2D real = new Triangle_2D(a,b,c);
		double areaReal = real.area();
		Triangle_2D x = new Triangle_2D(a,b,o);
		double area1 = x.area();
		Triangle_2D y = new Triangle_2D(a,o,c);
		double area2 = y.area();
		Triangle_2D z = new Triangle_2D(o,b,c);
		double area3 = z.area();
		double sum = area1 + area2 + area3;
		if (sum > areaReal + Ex2_Const.EPS)  return false;
		return true;
	}


	/**
	 * Calculates the area of the triangle.
	 * @return The area of the triangle.
	 */
	@Override
	public double area() {
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		double c = _p3.distance(_p1);
		double area = Math.sqrt((a+b+c)*(a+b-c)*(b+c-a)*(c+a-b))/4;
		return area;
	}


	/**
	 * Calculates the perimeter of the triangle.
	 * @return The perimeter of the triangle.
	 */
	@Override
	public double perimeter() {
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		double c = _p3.distance(_p1);
		double peri = a +b + c;
		return peri;
	}


	/**
	 * Translates the triangle by a given vector.
	 * @param vec The vector for translation.
	 */
	@Override
	public void translate(Point_2D vec) {
		this._p1.move(vec);
		this._p2.move(vec);
		this._p3.move(vec);
	}


	/**
	 * Creates a copy of the triangle.
	 * @return A copy of the triangle.
	 */
	@Override
	public GeoShape copy() {
		return new Triangle_2D(this);
	}


	/**
	 * Scales the triangle around a given center point by a given ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center,ratio);
		this._p2.scale(center,ratio);
		this._p3.scale(center,ratio);
	}


	/**
	 * Rotates the triangle around a given center point by a given angle (in degrees).
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._p1.rotate(center,angleDegrees);
		this._p2.rotate(center,angleDegrees);
		this._p3.rotate(center,angleDegrees);
	}

}