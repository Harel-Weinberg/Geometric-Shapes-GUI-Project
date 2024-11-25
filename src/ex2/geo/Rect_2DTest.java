package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {

    @Test
    void contains() {
        Point_2D a = new Point_2D(0, 0);
        Point_2D b = new Point_2D(4, 4);
        Rect_2D rect = new Rect_2D(a, b);
        Point_2D p = new Point_2D(6, 6);
        assertFalse(rect.contains(p));
    }

    @Test
    void area() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D area = new Rect_2D(a,b);
        System.out.println(area.area());
        double ecpected = 16.0;
        assertEquals(ecpected,area.area(), Ex2_Const.EPS);
    }

    @Test
    public void testEquals() {
        Rect_2D rect1 = new Rect_2D("0,0,1,0,1,1,0,1");
        Rect_2D rect2 = new Rect_2D("0,0,1,0,1,1,0,1");
        assertTrue(rect1.equals(rect2));
        Rect_2D rect3 = new Rect_2D("1,0,1,1,0,1,0,0");
        assertTrue(rect1.equals(rect3));
    }

    @Test
    void perimeter() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D peri = new Rect_2D(a,b);
        System.out.println(peri.perimeter());
        double ecpected = 16;
        assertEquals(ecpected, peri.perimeter(),Ex2_Const.EPS);
        assertEquals(16,16);
    }

    @Test
    void translate() {
        Point_2D a = new Point_2D(0, 0);
        Point_2D b = new Point_2D(4, 4);
        Rect_2D rect = new Rect_2D(a, b);
        Point_2D p = new Point_2D(2, 2);
        rect.translate(p);
        Point_2D a2 = new Point_2D(2, 2);
        Point_2D b2 = new Point_2D(6, 6);
        assertEquals(new Point_2D(2, 2), a2);
        assertEquals(new Point_2D(6, 6), b2);
    }

    @Test
    void copy() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D rec = new Rect_2D(a,b);
        Rect_2D copy = (Rect_2D) rec.copy();
        Point_2D a2 = new Point_2D(0,0);
        Point_2D b2 = new Point_2D(4,4);
        assertEquals(a, a2);
        assertEquals(b, b2);
    }

    @Test
    void scale() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D rec = new Rect_2D(a,b);
        Point_2D center = new Point_2D(2,2);
        double ratio = 2;
        rec.scale(center,ratio);
        Point_2D a2 = new Point_2D(-4, -4);
        Point_2D b2 = new Point_2D(8, 8);
        assertEquals(new Point_2D(-4, -4), a2);
        assertEquals(new Point_2D(8, 8), b2);

    }

    @Test
    void rotate() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D rec = new Rect_2D(a,b);
        Point_2D center = new Point_2D(2,2);
        double angle = 90;
        rec.rotate(center,angle);
        Point_2D a2 = new Point_2D(2, -2);
        Point_2D b2 = new Point_2D(6,2);
        assertEquals(new Point_2D(2, -2), a2);
        assertEquals(new Point_2D(6, 2), b2);

    }

    @Test
    void testToString(){
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(4,4);
        Rect_2D rec = new Rect_2D(a,b);
        System.out.println(rec);
    }

}