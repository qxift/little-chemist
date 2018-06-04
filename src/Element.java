import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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