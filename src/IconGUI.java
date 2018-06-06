import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconGUI extends JLabel {

	private Element element;
	ImageIcon icon;
	
	public IconGUI(Element other)
	{
		super(new ImageIcon("../little-chemist/images/" + other.name + ".jpg"));
		element = other;
	}
	
	public Element getElement()
	{
		return element;
	}	
}
