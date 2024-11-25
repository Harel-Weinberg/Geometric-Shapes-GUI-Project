package ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
/**
 * This class iscomparator for comparing GUI_Shape objects based on different criteria.
 * Implements the Comparator interface.
 * @author : Harel Weinberg
 * ID: 322351883
 */

public class ShapeComp implements Comparator<GUI_Shape> {

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final ShapeComp CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final ShapeComp CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);


	// Flag indicating the type of comparison
	private int _flag;

	/**
	 * Constructor to initialize the comparison flag.
	 *
	 * @param flag The comparison flag.
	 */
	public ShapeComp(int flag) {
		_flag = flag;
	}


	/**
	 * Compares two GUI_Shape objects based on the sorting flag _flag.
	 *
	 * @param o1 The first GUI_Shape object to compare.
	 * @param o2 The second GUI_Shape object to compare.
	 * @return An integer indicating the relative order of the objects.
	 */
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1 = -1, a2 = -1;

		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans = 0;

		if (_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if (a1 > a2) {
				ans = 1;
			}
			if (a1 < a2) {
				ans = -1;
			}
		}

		if (_flag == Ex2_Const.Sort_By_Anti_Area) {
			a1 = -s1.area();
			a2 = -s2.area();
			if (a1 > a2) {
				ans = 1;
			} else if (a1 < a2) {
				ans = -1;
			}
		}

		if (_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}

		if (_flag == Ex2_Const.Sort_By_Anti_toString) {
			ans = o2.toString().compareTo(o1.toString());
		}

		if (_flag == Ex2_Const.Sort_By_Perimeter) {
			double p1 = s1.perimeter();
			double p2 = s2.perimeter();
			if (p1 > p2) {
				ans = 1;
			} else if (p1 < p2) {
				ans = -1;
			}
		}

		if (_flag == Ex2_Const.Sort_By_Anti_Perimeter) {
			double p1 = -s1.perimeter();
			double p2 = -s2.perimeter();
			if (p1 > p2) {
				ans = 1;
			} else if (p1 < p2) {
				ans = -1;
			}
		}
		if (_flag == Ex2_Const.Sort_By_Tag) {
			double p1 = o1.getTag();
			double p2 = o2.getTag();
			if (p1 > p2) {
				ans = 1;
			} else if (p1 < p2) {
				ans = -1;
			}
		}
		if (_flag == Ex2_Const.Sort_By_Anti_Tag) {
				double p1 = o1.getTag();
				double p2 = o2.getTag();
				if (p1 > p2) {
					ans = -1;
				} else if (p1 < p2) {
					ans = 1;
				}
			}
		return ans;
		}

	}