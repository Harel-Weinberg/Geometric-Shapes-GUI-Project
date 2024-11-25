package ex2.geo;

import ex2.ex2.ShapeCollection;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCompTest {

    private Segment_2D s = new  Segment_2D(new Point_2D(1,1),new Point_2D(0,0));
    private GUI_Shape guiShapeSegment= new GUIShape(s,true, Color.BLACK,1);

    private Rect_2D r = new  Rect_2D(new Point_2D(0,0),new Point_2D(2,2));
    private GUI_Shape guiShapeRect= new GUIShape(r,true, Color.BLACK,1);
    private ShapeComp shapeComp=new ShapeComp(2);


    @Test
    void compare() {
        shapeComp=new ShapeComp(4);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==1);
        shapeComp=new ShapeComp(5);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==-1);

        shapeComp=new ShapeComp(0);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==0);

        shapeComp=new ShapeComp(1);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==0);

        shapeComp=new ShapeComp(3);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeRect)==0);

        shapeComp=new ShapeComp(3);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==-1);
        shapeComp=new ShapeComp(2);
        assertTrue(shapeComp.compare(guiShapeRect,guiShapeSegment)==1);
    }
}