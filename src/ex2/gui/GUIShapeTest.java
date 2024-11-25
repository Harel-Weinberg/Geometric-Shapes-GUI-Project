package ex2.gui;

import static org.junit.Assert.*;
import org.junit.*;

import java.awt.Color;

import ex2.geo.*;

public class GUIShapeTest {
    private GUIShape guiShape;

    @Before
    public void setUp() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        guiShape = new GUIShape(geoShape, fill, color, tag);
    }

    @Test
    public void testGetShape() {
        assertEquals(guiShape.getShape().getClass(), Circle_2D.class);
    }

    @Test
    public void testSetShape() {
        GeoShape newShape = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1),
                new Point_2D(1, 0), new Point_2D(0, 1));
        guiShape.setShape(newShape);
        assertEquals(guiShape.getShape().getClass(), Rect_2D.class);
    }

    @Test
    public void testIsFilled() {
        assertTrue(guiShape.isFilled());
    }

    @Test
    public void testSetFilled() {
        guiShape.setFilled(false);
        assertFalse(guiShape.isFilled());
    }

    @Test
    public void testGetColor() {
        assertEquals(guiShape.getColor(), Color.RED);
    }

    @Test
    public void testSetColor() {
        Color newColor = Color.BLUE;
        guiShape.setColor(newColor);
        assertEquals(guiShape.getColor(), newColor);
    }

    @Test
    public void testGetTag() {
        assertEquals(guiShape.getTag(), 1);
    }

    @Test
    public void testSetTag() {
        guiShape.setTag(2);
        assertEquals(guiShape.getTag(), 2);
    }

    @Test
    public void testCopy() {
        GUI_Shape copiedShape = guiShape.copy();
        assertEquals(copiedShape.getClass(), GUIShape.class);
    }

    @Test
    public void testToString() {
        String expected = "GUIShape,16711680,true,1,Circle_2D,0.0,0.0, 5.0";
        assertEquals(guiShape.toString(), expected);
    }

    @Test
    public void testIsSelected() {
        assertFalse(guiShape.isSelected());
    }

    @Test
    public void testSetSelected() {
        guiShape.setSelected(true);
        assertTrue(guiShape.isSelected());
    }

    @Test
    public void testEquals() {
        GUIShape copiedShape = new GUIShape(guiShape);
        assertTrue(guiShape.equals(copiedShape));
        copiedShape.setFilled(false);
        assertFalse(guiShape.equals(copiedShape));
    }

}