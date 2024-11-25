package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {
    private Segment_2D s1 = new Segment_2D(Point_2D.ORIGIN,new Point_2D(0,1));
    private Point_2D p1 = new Point_2D(1,0);
    private Point_2D p3 = new Point_2D(0,0.5);

    private Point_2D p2 = new Point_2D(5,3);
    @org.junit.jupiter.api.Test
    void translate() {
        s1.translate(p1);
        assertEquals(new Point_2D(1, 0), s1.get_p1());
        assertEquals(new Point_2D(1, 1), s1.get_p2());
    }

    @org.junit.jupiter.api.Test
    void copy() {
        Segment_2D s2 = (Segment_2D) s1.copy();
        assertEquals(s1.get_p1(), s2.get_p1());
        assertEquals(s1.get_p2(), s2.get_p2());
    }

    @org.junit.jupiter.api.Test
    void scale() {
        s1.scale(p3, 2);
        assertEquals(new Point_2D(0, -0.5), s1.get_p1());
        assertEquals(new Point_2D(0, 1.5), s1.get_p2());
    }

    @org.junit.jupiter.api.Test
    void rotate() {
        Point_2D pp = new Point_2D(0.5, 0.5);
        Point_2D pp1 = new Point_2D(-0.5, 0.5);
        Segment_2D t1 = new Segment_2D(pp, pp1);

        Point_2D center1 = new Point_2D(0, 0.5);
        double angleDegrees1 = 90;
        s1.rotate(center1, angleDegrees1);
        assertEquals(t1.get_p1().x(),s1.get_p1().x(),Ex2_Const.EPS);
    }

    @Test
    public void testEquals() {
        Segment_2D segment1 = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Segment_2D segment2 = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        assertTrue(segment1.equals(segment2));
        Segment_2D segment3 = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Segment_2D segment4 = new Segment_2D(new Point_2D(1, 1), new Point_2D(0, 0));
        assertTrue(segment3.equals(segment4));
        Segment_2D segment5 = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Segment_2D segment6 = new Segment_2D(new Point_2D(0, 0), new Point_2D(2, 2));
        assertFalse(segment5.equals(segment6));
        Segment_2D segment7 = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        Segment_2D segment8 = new Segment_2D(new Point_2D(2, 2), new Point_2D(0, 0));
        assertFalse(segment7.equals(segment8));
    }

    @Test
    void get_p1() {
        assertEquals(new Point_2D(0, 0), s1.get_p1());
    }

    @Test
    void get_p2() {
        assertEquals(new Point_2D(0, 1), s1.get_p2());
    }

    @Test
    void contains() {
        assertTrue(s1.contains(new Point_2D(0, 0.5)));
        assertFalse(s1.contains(new Point_2D(1, 1)));
    }

    @Test
    void area() {
        assertEquals(0, s1.area());
    }

    @Test
    void perimeter() {
        double p = s1.perimeter();
        assertEquals(p,2, Ex2_Const.EPS);
        Segment_2DTest s2;
    }

    @Test
    void testTranslate() {
        Segment_2D s2 = new Segment_2D(Point_2D.ORIGIN, new Point_2D(0, 2));
        s2.translate(new Point_2D(1, 1));
        assertEquals(new Point_2D(1, 1), s2.get_p1());
        assertEquals(new Point_2D(1, 3), s2.get_p2());
    }

    @Test
    void testCopy() {
        Segment_2D s2 = (Segment_2D) s1.copy();
        assertEquals(s1.get_p1(), s2.get_p1());
        assertEquals(s1.get_p2(), s2.get_p2());
    }

    @Test
    void testScale() {
        Segment_2D s2 = new Segment_2D(new Point_2D(1, 1), new Point_2D(1, 3));
        s2.scale(new Point_2D(0, 0), 2);
        assertEquals(new Point_2D(2, 2), s2.get_p1());
        assertEquals(new Point_2D(2, 6), s2.get_p2());
    }

    @Test
    public void testToString() {
        Segment_2D segment = new Segment_2D(new Point_2D(0, 0), new Point_2D(1, 1));
        String expected = "0.0,0.0,1.0,1.0";
        assertEquals(expected, segment.toString());
    }

    @Test
    void testRotate() {
        Point_2D pp = new Point_2D(0.5, 0.5);
        Point_2D pp1 = new Point_2D(-0.5, 0.5);
        Segment_2D t1 = new Segment_2D(pp, pp1);

        Point_2D center1 = new Point_2D(0, 0.5);
        double angleDegrees1 = 90;
        s1.rotate(center1, angleDegrees1);
        assertEquals(t1.get_p1().x(),s1.get_p1().x(),Ex2_Const.EPS);
    }
}