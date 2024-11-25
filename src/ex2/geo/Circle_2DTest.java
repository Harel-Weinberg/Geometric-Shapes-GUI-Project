package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {
    private Point_2D p1;
    private double radius;
    private Circle_2D s1;
    @BeforeEach
    void setUp() {
        p1 = new Point_2D(0, 0);
        radius = 2;
        s1 = new Circle_2D(p1,radius);
    }

    @Test
    void getRadius() {
        double r = 3.3;
        assertEquals(3.3,r);
    }

    @Test
    void getCenter() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,3);
        assertTrue(p1.equals(circle.getCenter()));
    }

    @Test
     void toString1() {
        String st1 = s1.toString();
        Circle_2D s11 = new Circle_2D(st1);
        assertEquals(s1, s11);
        assertEquals(s1.toString(),st1);
    }

    @Test
    public void testEquals() {
        Circle_2D circle1 = new Circle_2D(new Point_2D(0, 0), 5);
        assertTrue(circle1.equals(circle1));
        assertFalse(circle1.equals(null));
        assertFalse(circle1.equals("This is a string"));
        Circle_2D circle2 = new Circle_2D(new Point_2D(0, 0), 5);
        assertTrue(circle1.equals(circle2));
        Circle_2D circle3 = new Circle_2D(new Point_2D(0, 0), 10);
        assertFalse(circle1.equals(circle3));
        Circle_2D circle4 = new Circle_2D(new Point_2D(1, 1), 5);
        assertFalse(circle1.equals(circle4));
    }

    @Test
    void testToString() {
        Point_2D p1 = new Point_2D(1, 2);
        assertEquals(1.0+","+2.0,p1.toString());
    }

    @Test
    void contains() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,2);
        Point_2D in = new Point_2D(1,1);
        Point_2D out = new Point_2D(3,3);
        assertFalse(circle.contains(out));
        assertTrue(circle.contains(in));
    }

    @Test
    void area() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,2);
        assertEquals(Math.PI*4,circle.area(),Ex2_Const.EPS);
    }

    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,2);
        assertEquals(Math.PI*2*2,circle.perimeter(),Ex2_Const.EPS);
    }

    @Test
    void translate() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,2);
        Point_2D p2 = new Point_2D(2, 1);
        circle.translate(p2);
        System.out.println(circle);
    }

    @Test
    void copy() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1,2);
        Circle_2D copy = (Circle_2D)circle.copy();
        assertTrue(circle.getCenter().equals(copy.getCenter()));
        assertEquals(circle.getRadius(),copy.getRadius());
    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(1, 1);
        Circle_2D circle = new Circle_2D(p1,2);
        double ratio =3;
        circle.scale(p1,ratio);
        Circle_2D newCircle = new Circle_2D(p1,2 * ratio);
        assertTrue(newCircle.getCenter().equals(circle.getCenter()));
        assertEquals(newCircle.getRadius(),circle.getRadius(),Ex2_Const.EPS);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(1, 1);
        Circle_2D circle = new Circle_2D(p1,2);
        Point_2D p2 = new Point_2D(0,0);
        circle.rotate(p2,90);

        Circle_2D cir = new Circle_2D(new Point_2D(-1,1),2);


        assertTrue(circle.getCenter().close2equals(cir.getCenter(),Ex2_Const.EPS));
        assertEquals(2,cir.getRadius(),Ex2_Const.EPS);

    }
}