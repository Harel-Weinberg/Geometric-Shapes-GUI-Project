package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {

    @Test
    void x() {
        double a=1,b=2.53;
        Point_2D p1 = new Point_2D(a,b);
        assertEquals(1,p1.x());
    }

    @Test
    void y() {
        Point_2D p1 = new Point_2D(1,2);
        assertEquals(2,p1.y());
    }

    @Test
    void ix() {
        Point_2D p1 = new Point_2D(1.3, 2);
        assertEquals(1,p1.ix());
    }

    @Test
    void iy() {
        Point_2D p1 = new Point_2D(1, 1.4);
        assertEquals(1,p1.iy());
    }

    @Test
    void add() {
        Point_2D p1 = new Point_2D(1,2);
        Point_2D p2 = new Point_2D(3,3);
        Point_2D ret =  p1.add(p2);
        Point_2D shouldBe = new Point_2D(4,5);

        assertTrue(ret.equals(shouldBe));
    }

    @Test
    void testToString() {
        Point_2D p1 = new Point_2D(1, 2);
        assertEquals(1.0+","+2.0,p1.toString());
    }

    @Test
    void distance() {
        Point_2D p1 = new Point_2D(3, 4);
        assertEquals(5.0,p1.distance());
    }

    @Test
    void testDistance() {
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        assertEquals(5, p1.distance(p2));
    }

    @Test
    void testEquals() {
        Point_2D p1 = new Point_2D(3, 4);
        Point_2D p2 = new Point_2D(3, 4);
        Point_2D p3 = new Point_2D(5, 6);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }

    @Test
    void close2equals() {
        Point_2D p1 = new Point_2D(1,2);
        Point_2D p2 = new Point_2D(1,2.000000002);
        assertFalse(p1.equals(p2));
        assertTrue(p1.close2equals(p2, Ex2_Const.EPS));
    }

    @Test
    void vector() {
        Point_2D p1 = new Point_2D(1,2);
        Point_2D p2 = new Point_2D(3,3);
        Point_2D p3 = p1.vector(p2);
        Point_2D shouldBe = new Point_2D(2,1);
        assertTrue(p3.equals(shouldBe));
    }

    @Test
    void move() {
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(1,1);
        p1.move(p2);
        System.out.println(p1);

    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(1,2);
        p2.scale(p1,2);
        System.out.println(p2);
        assertTrue(p2.close2equals(new Point_2D(-1,0),Ex2_Const.EPS));
    }

    @Test
    void rotate() {

        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(1,2);
        p2.rotate(p1,90);
        System.out.println(p2);
        assertTrue(p2.close2equals(new Point_2D(5,2),Ex2_Const.EPS));
    }
}