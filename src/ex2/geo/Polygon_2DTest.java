package ex2.geo;

import ex2.ex2.Ex2_Const;
import ex2.geo.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {

    @Test
    void Equals() {
        Point_2D[] points1 = {
                new Point_2D(2, 0),
                new Point_2D(1, 1),
                new Point_2D(-1, 1),
                new Point_2D(-2, 0),
                new Point_2D(-1, -1),
                new Point_2D(1, -1)
        };
        Point_2D[] points2 = {
                new Point_2D(2, 0),
                new Point_2D(-1, 1),
                new Point_2D(-2, 0),
                new Point_2D(-1, -1),
                new Point_2D(1, -1),
                new Point_2D(1, 1)
        };
        Point_2D[] points3 = {
                new Point_2D(2, 0),
                new Point_2D(-1, 1),
                new Point_2D(-2, 0),
                new Point_2D(-1, -1),
                new Point_2D(1, -1),
        };
        Point_2D[] points4 = {
                new Point_2D(2, 0),
                new Point_2D(-1, 1),
                new Point_2D(-2, 0),
                new Point_2D(-1, -1),
                new Point_2D(1, -1),
                new Point_2D(1, 5)
        };
        Point_2D[] points5 = {
                new Point_2D(2, 0.00000001),
                new Point_2D(-1, 1.0000000001),
                new Point_2D(-2, 0),
                new Point_2D(-1, -1),
                new Point_2D(1, -1),
                new Point_2D(1, 5)
        };
        Polygon_2D polygon1 = new Polygon_2D(points1);
        Polygon_2D polygon2 = new Polygon_2D(polygon1);
        Polygon_2D polygon3 = new Polygon_2D(points2);
        Polygon_2D polygon4 = new Polygon_2D(points3);
        Polygon_2D polygon5 = new Polygon_2D(points4);
        Polygon_2D polygon6 = new Polygon_2D(points5);

        assertEquals(polygon1, polygon2);
        assertEquals(polygon3, polygon2);
        assertNotEquals(polygon4,polygon3);
        assertNotEquals(polygon5,polygon3);
        assertEquals(polygon5, polygon6);

    }

    @Test
    void contains() {
        Point_2D[] points = {
                new Point_2D(0, 0),
                new Point_2D(0, 4),
                new Point_2D(3, 0)
        };
        Polygon_2D polygon = new Polygon_2D(points);
        assertTrue(polygon.contains(new Point_2D(1, 1)));
        assertFalse(polygon.contains(new Point_2D(5, 5)));
    }

    @Test
    void area() {
        Point_2D[] points = {
                new Point_2D(0, 0),
                new Point_2D(0, 4),
                new Point_2D(3, 0)
        };
        Polygon_2D polygon = new Polygon_2D(points);

        assertEquals(6, polygon.area(), Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        Point_2D[] points = {
                new Point_2D(0, 0),
                new Point_2D(0, 3),
                new Point_2D(4, 0)
        };
        Polygon_2D polygon = new Polygon_2D(points);

        assertEquals(12, polygon.perimeter(), Ex2_Const.EPS);
    }

    @Test
    void translate() {
        Point_2D[] points = {
                new Point_2D(1, 1),
                new Point_2D(2, 2),
                new Point_2D(3, 3)
        };
        Polygon_2D polygon = new Polygon_2D(points);
        polygon.translate(new Point_2D(1, 1));

        Point_2D[] expectedPoints = {
                new Point_2D(2, 2),
                new Point_2D(3, 3),
                new Point_2D(4, 4)
        };
        Polygon_2D expectedPolygon = new Polygon_2D(expectedPoints);

        assertEquals(expectedPolygon, polygon);
    }

    @Test
    void copy() {
        Point_2D[] points = {
                new Point_2D(1, 1),
                new Point_2D(2, 2),
                new Point_2D(3, 3)
        };
        Polygon_2D polygon = new Polygon_2D(points);
        Polygon_2D copiedPolygon = (Polygon_2D) polygon.copy();

        assertEquals(polygon, copiedPolygon);
        assertNotSame(polygon, copiedPolygon);
    }

    @Test
    void scale() {
        Point_2D[] points = {
                new Point_2D(0, 0),
                new Point_2D(0, 2),
                new Point_2D(2, 2)
        };
        Polygon_2D polygon = new Polygon_2D(points);
        polygon.scale(new Point_2D(2.0 / 3, 4.0 / 3), 2);

        Point_2D[] expectedPoints = {
                new Point_2D(-2.0 / 3, -4.0 / 3),
                new Point_2D(-2.0 / 3, 8.0 / 3),
                new Point_2D(10.0 / 3, 8.0 / 3)
        };
        Polygon_2D expectedPolygon = new Polygon_2D(expectedPoints);

        Point_2D[] expectedPoint = polygon.getAllPoints();
        Point_2D[] actualPoints = expectedPolygon.getAllPoints();

        for (int i = 0; i < expectedPoints.length; i++) {
            assertEquals(expectedPoint[i].x(), actualPoints[i].x(), Ex2_Const.EPS);
            assertEquals(expectedPoint[i].y(), actualPoints[i].y(), Ex2_Const.EPS);

        }
    }
    @Test
    public void testEquals() {
        Polygon_2D polygon1 = new Polygon_2D();
        assertTrue(polygon1.equals(polygon1));
        assertFalse(polygon1.equals(null));
        assertFalse(polygon1.equals("This is a string"));
        Polygon_2D polygon2 = new Polygon_2D();
        assertTrue(polygon1.equals(polygon2));
        Polygon_2D polygon3 = new Polygon_2D();
        assertTrue(polygon1.equals(polygon3));
        Polygon_2D polygon4 = new Polygon_2D();
        assertTrue(polygon1.equals(polygon4));
    }

    @Test
    void rotate() {
        Point_2D[] points = {
                new Point_2D(0, 0),
                new Point_2D(0, 2),
                new Point_2D(2, 2)
        };
        Polygon_2D polygon = new Polygon_2D(points);
        polygon.rotate(new Point_2D(2.0 / 3, 4.0 / 3), 180);

        Point_2D[] expectedPoints = {
                new Point_2D(4.0 / 3.0, 8.0 / 3.0),
                new Point_2D(4.0 / 3.0, 2.0 / 3.0),
                new Point_2D(-2.0 / 3.0, 2.0 / 3.0)
        };
        Polygon_2D expectedPolygon = new Polygon_2D(expectedPoints);

        Point_2D[] expectedPoint = polygon.getAllPoints();
        Point_2D[] actualPoints = expectedPolygon.getAllPoints();

        for (int i = 0; i < expectedPoints.length; i++) {
            assertEquals(expectedPoint[i].x(), actualPoints[i].x(), Ex2_Const.EPS);
            assertEquals(expectedPoint[i].y(), actualPoints[i].y(), Ex2_Const.EPS);
        }
    }
    @Test
    public void toString1() {

        String coordinatesString = "1.0,2.0,3.0,4.0,5.0,6.0";
        Point_2D[] expectedPoints = {
                new Point_2D(1.0, 2.0),
                new Point_2D(3.0, 4.0),
                new Point_2D(5.0, 6.0)
        };

        Polygon_2D polygon = new Polygon_2D(coordinatesString);
        Point_2D[] actualPoints = polygon.getAllPoints();
        System.out.println(polygon);
        assertArrayEquals(expectedPoints, actualPoints);
    }

}