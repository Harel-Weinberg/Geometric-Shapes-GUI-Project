package ex2.ex2;

import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */

/**
 * This class represents a collection of GUI_Shape objects.
 * It implements the GUI_Shape_Collection interface.
 * It provides methods for managing and manipulating the collection, including adding, removing,
 * sorting, copying, saving to a file, and comparing elements within the collection.
 * Custom equality comparison logic is provided through the equals() method override.
 *
 * @author: Harel Weinberg
 * ID: 322351883
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;


	/**
	 * Constructs a new ShapeCollection with an empty list of shapes.
	 */
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}


	/**
	 * Retrieves the GUI_Shape at the specified index in this collection.
	 * @param i The index of the GUI_Shape to retrieve.
	 * @return The GUI_Shape at the specified index.
	 */
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}


	/**
	 * Returns the number of GUI_Shape elements in this collection.
	 * @return The number of GUI_Shape elements in this collection.
	 */
	@Override
	public int size() {
		return _shapes.size();
	}


	/**
	 * Removes the GUI_Shape element at the specified index from this collection.
	 * @param i The index of the GUI_Shape element to remove.
	 * @return The GUI_Shape element removed from the collection.
	 */
	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
	}


	/**
	 * Inserts a GUI_Shape element at the specified index in this collection.
	 * @param s The GUI_Shape element to insert.
	 * @param i The index at which to insert the GUI_Shape element.
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {
		if(s!=null && s.getShape()!=null)
			_shapes.add(i,s);
	}


	/**
	 * Adds a GUI_Shape element to this collection.
	 * @param s The GUI_Shape element to add.
	 */
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}


	/**
	 * Creates a copy of this GUI_Shape_Collection.
	 * @return A copy of this GUI_Shape_Collection.
	 */
	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection copyOfShapeCollection = new ShapeCollection();
		for (GUI_Shape originalShape: _shapes)
		{
			GUI_Shape copyShape = originalShape.copy();
			copyOfShapeCollection.add(copyShape);
		}
		return copyOfShapeCollection;
	}


	/**
	 * Sorts the GUI_Shape elements in this collection using the specified comparator.
	 * @param comp The comparator to use for sorting.
	 */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}


	/**
	 * Removes all GUI_Shape elements from this collection.
	 */
	@Override
	public void removeAll() {
		_shapes.clear();
	}


	/**
	 * Saves the contents of this ShapeCollection to a file.
	 * @param file The name of the file to save to.
	 */
	@Override
	public void save(String file) {
		try {
			FileWriter myWriter = new FileWriter(file);
			for (int i = 0; i < size(); i++) {
				System.out.println(get(i).toString());
				myWriter.write(get(i).toString()+"\n");
			}
			myWriter.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * Loads the contents of a file into this ShapeCollection.
	 * @param file The name of the file to load from.
	 */
	@Override
		public void load (String file){
			_shapes.clear();
			try  {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					GUIShape guiShape = new GUIShape(line);
					_shapes.add(guiShape);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


	/**
	 * Returns a string representation of this ShapeCollection.
	 * @return A string representing this ShapeCollection.
	 */
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i)+"\n";
		}
		return ans;
	}


	/**
	 * Compares this GUI_Shape with another GUI_Shape for equality.
	 * @param o The GUI_Shape to compare with.
	 * @return True if the GUI_Shape objects are equal, false otherwise.
	 */
	public boolean comperToSheps(GUI_Shape o,GUI_Shape o1){
		if(o.equals(o1))return true;
		if(o.getShape().equals(o1.getShape()))return true;
		else return false;
	}


	/**
	 * Checks if this ShapeCollection is equal to another object.
	 * @param o The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		ShapeCollection colection = (ShapeCollection) o;
		if (_shapes.size()!=colection._shapes.size() )return false;
		int chek=0;
		boolean _ecwols=false;
		for (int j = 0; j <_shapes.size() ; j++) {
			for (int k = 0; k <colection._shapes.size() ; k++) {
				if(comperToSheps(_shapes.get(j),colection._shapes.get(k)))chek=1;
				if(chek==1){
					for (int i = 0; i < _shapes.size() ; i++) {
						if(comperToSheps(_shapes.get(j+i),colection._shapes.get(k+i))){_ecwols=true;}
					}
				}
				if(_ecwols==true){return true;}
				else return false;
			}
		}
		if(this.size()==colection.size()&&colection.size()==0)return true;
		return false;
	}

}
