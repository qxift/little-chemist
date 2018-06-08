import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Element extends JPanel{

	int id;
	String name = "";
	List<Long> ingredients = new ArrayList();
	
	public Element(int n, String str) {
		id = n;
		name = str;
	}
	
	public void addIngredients(List<Long> ingred) {
		ingredients = ingred;
	}
}