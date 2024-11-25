package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {

    @Test
    void getAllPoints() {
        Triangle_2D tri = new Triangle_2D(new Point_2D(1,1),new Point_2D(1,4),new Point_2D(5,1));
        System.out.println(tri);
        Point_2D[] allPoints = tri.getAllPoints();
        Point_2D[] p = {(new Point_2D(1,1)), (new Point_2D(1,4)), (new Point_2D(5,1))};
        for (int i = 0; i < allPoints.length; i++) {
            System.out.println(allPoints[i]);
            assertTrue(allPoints[i].equals(p[i]));
        }
    }

    @Test
    void contains() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D real = new Triangle_2D(a,b,c);
        Point_2D o = new Point_2D(5,6);
        assertFalse(real.contains(o));
    }

    @Test
    public void testToString() {
        Triangle_2D triangle = new Triangle_2D(new Point_2D(0, 0), new Point_2D(1, 0), new Point_2D(0, 1));
        String expected = "0.0,0.0" + ",1.0,0.0" + ",0.0,1.0";
        assertEquals(expected, triangle.toString());
    }

    @Test
    void area() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D area = new Triangle_2D(a,b,c);
        System.out.println(area.area());
        double ecpected = 6.0;
        assertEquals(ecpected,area.area(), Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D peri = new Triangle_2D(a,b,c);
        System.out.println(peri.perimeter());
        double ecpected = 12;
        assertEquals(ecpected, peri.perimeter(),Ex2_Const.EPS);
        assertEquals(1,1);
    }

    @Test
    void translate() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D tri = new Triangle_2D(a,b,c);
        Point_2D p = new Point_2D(5,5);
        tri.translate(p);
        System.out.println(tri);
        Point_2D a2 = new Point_2D(5,5);
        Point_2D b2 = new Point_2D(8,5);
        Point_2D c2 = new Point_2D(5,9);
        assertTrue(a2.close2equals(tri.getAllPoints()[0], Ex2_Const.EPS));
        assertTrue(b2.close2equals(tri.getAllPoints()[1], Ex2_Const.EPS));
        assertTrue(c2.close2equals(tri.getAllPoints()[2], Ex2_Const.EPS));

    }

    @Test
    void copy() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D tri = new Triangle_2D(a,b,c);
        Triangle_2D copy = (Triangle_2D)tri.copy();
        System.out.println(copy);
        assertTrue(tri.getAllPoints()[0].equals(copy.getAllPoints()[0]));
        assertTrue(tri.getAllPoints()[1].equals(copy.getAllPoints()[1]));
        assertTrue(tri.getAllPoints()[2].equals(copy.getAllPoints()[2]));
    }

    @Test
    public void testEquals() {
        Triangle_2D triangle1 = new Triangle_2D(new Point_2D(0, 0), new Point_2D(1, 0), new Point_2D(0, 1));
        assertTrue(triangle1.equals(triangle1));
        Triangle_2D triangle2 = new Triangle_2D(new Point_2D(1, 0), new Point_2D(0, 1), new Point_2D(0, 0));
        assertTrue(triangle1.equals(triangle2));
        Triangle_2D triangle3 = new Triangle_2D(new Point_2D(0, 0), new Point_2D(2, 0), new Point_2D(0, 2));
        assertFalse(triangle1.equals(triangle3));
        Object obj = new Object();
        assertFalse(triangle1.equals(obj));
        assertFalse(triangle1.equals(null));
    }

    @Test
    void scale() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D tri = new Triangle_2D(a,b,c);
        Point_2D center = new Point_2D(1,1);
        double ratio = 2;
        tri.scale(center,ratio);
        Point_2D a2 = new Point_2D(-1,-1);
        Point_2D b2 = new Point_2D(5,-1);
        Point_2D c2 = new Point_2D(-1,7);
        Triangle_2D tri2 = new Triangle_2D(a2,b2,c2);
        System.out.println(tri2);
        assertTrue(tri.getAllPoints()[0].equals(tri2.getAllPoints()[0]));
        assertTrue(tri.getAllPoints()[1].equals(tri2.getAllPoints()[1]));
        assertTrue(tri.getAllPoints()[2].equals(tri2.getAllPoints()[2]));

    }

    @Test
    void rotate() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(3,0);
        Point_2D c = new Point_2D(0,4);
        Triangle_2D tri = new Triangle_2D(a,b,c);
        Point_2D center = new Point_2D(1,1);
        double angle = 360;
        tri.rotate(center,360);
        Point_2D a2 = new Point_2D(0,0);
        Point_2D b2 = new Point_2D(3,0);
        Point_2D c2 = new Point_2D(0,4);
        Triangle_2D tri2 = new Triangle_2D(a,b,c);
        assertTrue(tri.getAllPoints()[0].close2equals(tri2.getAllPoints()[0],Ex2_Const.EPS));
        assertTrue(tri.getAllPoints()[1].close2equals(tri2.getAllPoints()[1],Ex2_Const.EPS));
        assertTrue(tri.getAllPoints()[2].close2equals(tri2.getAllPoints()[2],Ex2_Const.EPS));
    }

}