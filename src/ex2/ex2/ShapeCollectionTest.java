package ex2.ex2;

import static org.junit.Assert.*;

import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import org.junit.*;

import java.awt.Color;
import java.io.*;
import java.util.Comparator;

import ex2.geo.*;
import ex2.gui.*;

public class ShapeCollectionTest {
    private ShapeCollection shapeCollection;
    private final String TEST_FILE_PATH = "test_shapes.txt";

    @Before
    public void setUp() {
        shapeCollection = new ShapeCollection();
    }

    @After
    public void tearDown() {
        new File(TEST_FILE_PATH).delete();
    }

    @Test
    public void testGet() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        assertEquals(shapeCollection.get(0), guiShape);
    }

    @Test
    public void testSize() {
        assertEquals(shapeCollection.size(), 0);
        shapeCollection.add(new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1));
        shapeCollection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1), new Point_2D(1, 0), new Point_2D(0, 1)), false, Color.BLUE, 2));
        assertEquals(shapeCollection.size(), 2);
    }

    @Test
    public void testRemoveElementAt() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        shapeCollection.removeElementAt(0);
        assertEquals(shapeCollection.size(), 0);
    }

    @Test
    public void testAddAt() {
        GeoShape geoShape1 = new Circle_2D(new Point_2D(0, 0), 5);
        GeoShape geoShape2 = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1), new Point_2D(1, 0), new Point_2D(0, 1));
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape1 = new GUIShape(geoShape1, fill, color, tag);
        GUIShape guiShape2 = new GUIShape(geoShape2, fill, color, tag);
        shapeCollection.add(guiShape1);
        shapeCollection.addAt(guiShape2, 0);
        assertEquals(shapeCollection.get(0), guiShape2);
    }

    @Test
    public void testAdd() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        assertEquals(shapeCollection.get(0), guiShape);
    }

    @Test
    public void testCopy() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        GUI_Shape_Collection copiedCollection = shapeCollection.copy();
        assertEquals(copiedCollection.get(0), guiShape);
    }

    @Test
    public void testSort() {
        Comparator<GUI_Shape> comparator = Comparator.comparingInt(GUI_Shape::getTag);
        GeoShape geoShape1 = new Circle_2D(new Point_2D(0, 0), 5);
        GeoShape geoShape2 = new Circle_2D(new Point_2D(0, 0), 10);
        boolean fill = true;
        Color color = Color.RED;
        int tag1 = 2;
        int tag2 = 1;
        GUIShape guiShape1 = new GUIShape(geoShape1, fill, color, tag1);
        GUIShape guiShape2 = new GUIShape(geoShape2, fill, color, tag2);
        shapeCollection.add(guiShape1);
        shapeCollection.add(guiShape2);
        shapeCollection.sort(comparator);
        assertEquals(shapeCollection.get(0), guiShape2);
    }

    @Test
    public void testRemoveAll() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        shapeCollection.removeAll();
        assertEquals(shapeCollection.size(), 0);
    }

    @Test
    public void testSave() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        shapeCollection.save(TEST_FILE_PATH);
        File file = new File(TEST_FILE_PATH);
        assertTrue(file.exists());
    }

    @Test
    public void testLoad() {
        GeoShape geoShape = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape = new GUIShape(geoShape, fill, color, tag);
        shapeCollection.add(guiShape);
        shapeCollection.save(TEST_FILE_PATH);
        ShapeCollection loadedCollection = new ShapeCollection();
        loadedCollection.load(TEST_FILE_PATH);
        assertEquals(shapeCollection, loadedCollection);
    }

    @Test
    public void testToString() {
        GeoShape geoShape1 = new Circle_2D(new Point_2D(0, 0), 5);
        GeoShape geoShape2 = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1), new Point_2D(1, 0), new Point_2D(0, 1));
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape1 = new GUIShape(geoShape1, fill, color, tag);
        GUIShape guiShape2 = new GUIShape(geoShape2, fill, color, tag);
        shapeCollection.add(guiShape1);
        shapeCollection.add(guiShape2);
        String expectedString = guiShape1.toString() +"\n"+ guiShape2.toString();
        assertEquals(shapeCollection.toString().trim(), expectedString);
    }

    @Test
    public void testComperToSheps() {
        GeoShape geoShape1 = new Circle_2D(new Point_2D(0, 0), 5);
        GeoShape geoShape2 = new Circle_2D(new Point_2D(0, 0), 5);
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape1 = new GUIShape(geoShape1, fill, color, tag);
        GUIShape guiShape2 = new GUIShape(geoShape2, fill, color, tag);
        assertTrue(shapeCollection.comperToSheps(guiShape1, guiShape2));
    }

    @Test
    public void testEquals() {
        GeoShape geoShape1 = new Circle_2D(new Point_2D(0, 0), 5);
        GeoShape geoShape2 = new Rect_2D(new Point_2D(0, 0), new Point_2D(1, 1), new Point_2D(1, 0), new Point_2D(0, 1));
        boolean fill = true;
        Color color = Color.RED;
        int tag = 1;
        GUIShape guiShape1 = new GUIShape(geoShape1, fill, color, tag);
        GUIShape guiShape2 = new GUIShape(geoShape2, fill, color, tag);
        shapeCollection.add(guiShape1);
        shapeCollection.add(guiShape2);
        ShapeCollection otherCollection = new ShapeCollection();
        otherCollection.add(guiShape1);
        otherCollection.add(guiShape2);
        assertEquals(shapeCollection, otherCollection);
    }

}