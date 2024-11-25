package ex2.geo;

import ex2.ex2.Ex2_Const;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */

/**
 * This class represents a 2D line segment defined by two endpoints.
 * Provides methods for construction, manipulation, and calculation related to line segments.
 * @author : Harel Weinberg
 * ID: 322351883
 */
public class Segment_2D implements GeoShape {
	// Points defining the segment
	private Point_2D _p1, _p2;

	/**
	 * Constructs a 2D line segment from a formatted string containing coordinates.
	 * @param t The formatted string with coordinates. The string should contain four comma-separated values representing the x and y coordinates of two points defining the segment. The points should be provided in the order: start point, end point.
	 *          For example, "x1,y1,x2,y2".
	 */
	public Segment_2D(String t) {
		String[] a = t.split(",");
		String s1 = a[0] + "," + a[1];
		String s2 = a[2] + "," + a[3];

		_p1 = new Point_2D(s1);
		_p2 = new Point_2D(s2);
	}


	/**
	 * Constructs a segment with two given points.
	 * @param a The first point.
	 * @param b The second point.
	 */
	public Segment_2D(Point_2D a, Point_2D b) {
		_p1 = new Point_2D(a);
		_p2 = new Point_2D(b);
	}


	/**
	 * Constructs a copy of a given segment.
	 * @param t1 The segment to copy.
	 */
	public Segment_2D(Segment_2D t1) {
		_p1 = new Point_2D(t1._p1);
		_p2 = new Point_2D(t1._p2);
	}


	/**
	 * Gets the first point of the segment.
	 * @return The first point of the segment.
	 */
	public Point_2D get_p1() {
		return new Point_2D(_p1);
	}


	/**
	 * Gets the second point of the segment.
	 * @return The second point of the segment.
	 */
	public Point_2D get_p2() {
		return new Point_2D(_p2);
	}


	/**
	 * Checks if a given point lies on the segment.
	 * @param ot The point to check.
	 * @return True if the point lies on the segment, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {

		double dist = _p1.distance(_p2);
		double d1 = _p1.distance(ot);
		double d2 = ot.distance(_p2);
		boolean ans = d1 + d2 < dist + Ex2_Const.EPS;
		return ans;
	}


	/**
	 * Calculates the area of the segment (which is 0).
	 * @return The area of the segment.
	 */
	@Override
	public double area() {
		return 0;
	}


	/**
	 * Calculates the perimeter of the segment.
	 * @return The perimeter of the segment.
	 */
	@Override
	public double perimeter() {
		double d = _p1.distance(_p2);
		return 2 * d;
	}


	/**
	 * Translates the segment by a given vector.
	 * @param vec The vector for translation.
	 */
	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
	}


	/**
	 * Creates a copy of the segment.
	 * @return A copy of the segment.
	 */
	@Override
	public GeoShape copy() {
		return new Segment_2D(this);
	}


	/**
	 * Scales the segment around a given center point by a given ratio.
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {//לבדוק שזה עובד

		_p2.scale(center, ratio);
		_p1.scale(center, ratio);
	}


	/**
	 * Calculates the center point between two given points.
	 * @param p1 The first point.
	 * @param p2 The second point.
	 * @return The center point between p1 and p2.
	 */
	public Point_2D center(Point_2D p1, Point_2D p2) {
		Point_2D p = new Point_2D((p1.x() + p2.x()) / 2, (p1.y() + p2.y()) / 2);
		return p;
	}


	/**
	 * Rotates the segment around a given center point by a given angle (in degrees).
	 * @param center       The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {

		_p1.rotate(center, angleDegrees);
		_p2.rotate(center, angleDegrees);
	}


	/**
	 * Returns a string representation of the line segment by concatenating the string representations of its endpoints.
	 * @return A string representation of the line segment.
	 */
	@Override
	public String toString() {
		return _p1.toString() + "," + _p2.toString();
	}


	/**
	 * Checks if the current Segment object is equal to another object.
	 * @param o The object to compare with the current Segment.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {//I check if the order of appearance of the points is equal
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment_2D segment2D = (Segment_2D) o;
		if (segment2D._p2.close2equals(_p1, Ex2_Const.EPS) && segment2D._p1.close2equals(_p2, Ex2_Const.EPS) || segment2D._p1.close2equals(_p1, Ex2_Const.EPS) && segment2D._p2.close2equals(_p2, Ex2_Const.EPS)) {
			return true;
		} else return false;
	}

}