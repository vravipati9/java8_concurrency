package generics;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

	public static void main(String[] args) {
		List<Shape> drawingList = new ArrayList<Shape>();
		drawingList.add(new Circle());drawingList.add(new Rectangle());
		Canvas c = new Canvas();
		c.drawAll(drawingList);
	}
}
