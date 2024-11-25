package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
/**
 * This class represents a 2D circle defined by a center point and a radius.
 * Provides methods for construction, manipulation, and calculation related to circles.
 * @author : Harel Weinberg
 * ID:322351883
 */
public class Circle_2D implements GeoShape {

	// The center point of the circle
	private Point_2D _center;

	// The radius of the circle
	private double _radius;

	/**
	 * Constructs a Circle_2D object from a string representation.
	 * The string should contain the x and y coordinates of the center of the circle, followed by the radius.
	 *
	 * @param t a string representation of the circle in the format "x,y,radius".
	 */
	public Circle_2D(String t) {
		this(new Point_2D(t.split(",")[0]+","+t.split(",")[1]),Double.parseDouble(t.split(",")[2]));
//		String[] a = t.split(",");
//		String s1 = a[0] + "," + a[1];
//		String r = a[2];
//
//		Point_2D _p1 = new Point_2D(Double.parseDouble(a[0]), Double.parseDouble(a[1]));
//		this(_p1, Double.parseDouble(r));
	}


	/**
	 * Constructs a Circle_2D object with the specified center and radius.
	 *
	 * @param cen the center point of the circle.
	 * @param rad the radius of the circle.
	 */
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}


	/**
	 * Constructs a copy of the given Circle_2D object.
	 * @param c the circle to copy.
	 */
	public Circle_2D(Circle_2D c) {
		this(c.getCenter(), c.getRadius());
	}


	/**
	 * Gets the radius of the circle.
	 * @return the radius of the circle.
	 */
	public double getRadius() {
		return this._radius;
	}


	/**
	 * Gets the center point of the circle.
	 * @return the center point of the circle.
	 */
	public Point_2D getCenter() {
		return _center;
	}


	/**
	 * Returns a string representation of the Circle_2D object.
	 * @return a string representation of the circle in the format "center, radius".
	 */
	@Override
	public String toString() {
		return _center.toString() + ", " + _radius;
	}


	/**
	 * Checks if the circle contains the specified point.
	 * @param ot the point to check.
	 * @return true if the point is inside or on the boundary of the circle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		if (ot.distance(_center) <= _radius)
			return true;
		return false;
	}


	/**
	 * Calculates the area of the circle.
	 * @return the area of the circle.
	 */
	@Override
	public double area() {

		return Math.PI * _radius * _radius;
	}


	/**
	 * Calculates the perimeter (circumference) of the circle.
	 * @return the perimeter of the circle.
	 */
	@Override
	public double perimeter() {

		return Math.PI * 2 * _radius;
	}


	/**
	 * Translates the circle by the specified vector.
	 * @param vec the vector by which to translate the circle.
	 */
	@Override
	public void translate(Point_2D vec) {
		this._center.move(vec);
	}


	/**
	 * Creates a copy of the Circle_2D object.
	 * @return a copy of the circle.
	 */
	@Override
	public GeoShape copy() {
		return new Circle_2D(this);
	}


	/**
	 * Scales the circle relative to the specified center point and ratio.
	 * @param center the center point for scaling.
	 * @param ratio  the scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		this._center.scale(center, ratio);
		this._radius *= ratio;
	}


	/**
	 * Rotates the circle around the specified center point by the given angle in degrees.
	 * @param center       the center point for rotation.
	 * @param angleDegrees the angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._center.rotate(center, angleDegrees);
	}


	/**
	 * Indicates whether some other object is "equal to" this one.
	 * This method implements the equality comparison between Circle_2D objects.
	 * @param o the reference object with which to compare.
	 * @return true if this Circle_2D object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Circle_2D circle2D = (Circle_2D) o;

		return Math.abs(_radius - circle2D._radius) < Ex2_Const.EPS && _center.close2equals(circle2D._center, Ex2_Const.EPS);

	}

}