package ex2.geo;
import ex2.gui.GUI_Shape;
import ex2.ex2.Ex2_Const;

import java.util.Arrays;


/**
 * This class represents a 2D polygon defined by an array of vertices.
 * Provides methods for construction, manipulation, and calculation related to polygons.
 *
 * @author : Harel Weinberg
 * ID: 322351883
 */
public class Polygon_2D implements GeoShape{

	private Point_2D[] vertices;

	/**
	 * Constructs a Polygon_2D object from an array of string coordinates representing points in the plane.
	 * The array should have an even length, where each pair represents X and Y coordinates.
	 * Each pair is parsed into doubles to create an array of Point_2D objects.
	 * @param coordinates An array of string coordinates.
	 * @throws NumberFormatException If parsing strings into doubles fails.
	 */
	public Polygon_2D(String[] coordinates){
		Point_2D[] result = new Point_2D[coordinates.length / 2];

		for (int i = 0; i < coordinates.length; i += 2) {
			String x = new String(coordinates[i]);
			String y = new String(coordinates[i + 1]);

			result[i / 2] = new Point_2D(Double.parseDouble(x),
					Double.parseDouble(y));
		}

		this.vertices = result;
	}

	/**
	 * Constructs an empty Polygon_2D object with no vertices.
	 * Useful for creating a Polygon_2D object that can later have vertices added to it.
	 */
	public Polygon_2D() {
		this.vertices = new Point_2D[0];
	}


	/**
	 * Constructs a new Polygon_2D object that is a copy of the specified Polygon_2D object.
	 * @param po the Polygon_2D object to copy.
	 */
	public Polygon_2D(Polygon_2D po) {
		this.vertices = new Point_2D[po.vertices.length];
		for (int i = 0; i < po.vertices.length; i++) {
			this.vertices[i] = new Point_2D(po.vertices[i]);
		}
	}


	/**
	 * Constructs a Polygon_2D object from an array of vertices.
	 * @param vertices an array of Point_2D objects representing the vertices of the polygon.
	 */
	public Polygon_2D(Point_2D[] vertices) {
		this.vertices = Arrays.copyOf(vertices, vertices.length);
	}


	/**
	 * Retrieves all points of the polygon.
	 * @return An array containing all the points of the polygon.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D[] result = new Point_2D[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			result[i] = new Point_2D(vertices[i]);
		}
		return result;
	}


	/**
	 * Constructs a 2D polygon from a string of coordinates.
	 * Each point is represented by a pair of x and y values separated by a comma.
	 * The string should be in the format "x1,y1,x2,y2,...,xn,yn".
	 * @param t A string representing the points of the polygon.
	 * @return A 2D polygon created from the points contained within the string.
	 */
	public Polygon_2D(String t) {
		String[] coordinates = t.split(",");
		Point_2D[] result = new Point_2D[coordinates.length / 2];

		for (int i = 0; i < coordinates.length; i += 2) {
			String x = coordinates[i];
			String y = coordinates[i + 1];
			result[i / 2] = new Point_2D(Double.parseDouble(x), Double.parseDouble(y));
		}

		this.vertices = result;
	}


	/**
	 * Adds a new point to the polygon if it's not already present.
	 * Checks for duplicate points before adding.
	 * @param p The point to be added.
	 */
	public void add(Point_2D p) {
		if (vertices != null) {
			boolean flag = true;
			for (int i = 0; i < vertices.length; i++) {
				if (vertices[i].x() == p.x() && vertices[i].y() == p.y()) {
					flag = false;
				}
			}
			if (flag) {
				vertices = Arrays.copyOf(vertices, vertices.length + 1);
				vertices[vertices.length - 1] = new Point_2D(p);
			}
		}
	}


	/**
	 * Returns a string representation of the polygon by concatenating the string representations of its vertices.
	 * @return A string representation of the polygon.
	 */
	@Override
	public String toString() {
		String s =vertices[0].toString();
		for (int i = 1; i < vertices.length; i++) {
			s+=","+vertices[i].toString();
		}
		return s.toString();
	}


	/**
	 * Checks if a point is inside the polygon using the ray-casting algorithm.
	 * @param ot The point to be checked.
	 * @return True if the point is inside the polygon, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		int count = 0;
		for (int i = 0; i < vertices.length; i++) {
			int next = (i + 1) % vertices.length;
			if ((vertices[i].y() < ot.y() && vertices[next].y() >= ot.y())
					|| (vertices[next].y() < ot.y() && vertices[i].y() >= ot.y())) {
				if (vertices[i].x() + (ot.y() - vertices[i].y()) /
						(vertices[next].y() - vertices[i].y())
						* (vertices[next].x() - vertices[i].x()) < ot.x()) {
					count++;
				}
			}
		}
		return count % 2 != 0;
	}


	/**
	 * Calculates the area of the polygon using the shoelace formula.
	 * @return The area of the polygon.
	 */
	@Override
	public double area() {
		double area = 0;
		for (int i = 0; i < vertices.length; i++) {
			int next = (i + 1) % vertices.length;
			area += (vertices[i].x() * vertices[next].y()) - (vertices[next].x() * vertices[i].y());
		}
		return Math.abs(area) / 2;
	}


	/**
	 * Calculates the perimeter of the polygon by summing the lengths of its edges.
	 * @return The perimeter of the polygon.
	 */
	@Override
	public double perimeter() {
		double result = 0;
		for (int i = 0; i < vertices.length - 1; i++) {
			result += vertices[i].distance(vertices[i + 1]);
		}
		result += vertices[0].distance(vertices[vertices.length - 1]);
		return result;
	}


	/**
	 * Translates (moves) all vertices of the polygon by a given vector.
	 * @param vec The vector by which to translate the polygon.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].move(vec);
		}
	}


	/**
	 * Creates a copy of the polygon.
	 * @return A copy of the polygon.
	 */
	@Override
	public GeoShape copy() {
		return new Polygon_2D(this);
	}


	/**
	 * Scales the polygon relative to a given center point by a specified ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].scale(center, ratio);
		}
	}


	/**
	 * Rotates the polygon around a given center point by a specified angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].rotate(center, angleDegrees);
		}
	}


	/**
	 * Checks if this polygon is equal to another object.
	 * @param o The object to compare with.
	 * @return True if the polygons are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Polygon_2D polygon2D = (Polygon_2D) o;
		Point_2D[] thisVertices = getAllPoints();
		Point_2D[] thatVertices = polygon2D.getAllPoints();

		if (thisVertices.length != thatVertices.length) {
			return false;
		}
		if (this.area() != this.area())
			return false;

		if (this.perimeter() != this.perimeter())
			return false;



		outerLoop:
		for (int i = 0; i < thisVertices.length; i++) {
			for (int j = 0; j < thatVertices.length; j++) {
				if (thisVertices[i].close2equals(thatVertices[j], Ex2_Const.EPS)) {
					continue outerLoop;
				}
			}
			return false;
		}
		return true;
	}

}