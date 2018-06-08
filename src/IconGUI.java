import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconGUI extends JLabel {

	private Element element;
	ImageIcon icon;
	
	public IconGUI(Element other)
	{
		super(new ImageIcon("../little-chemist/images/" + other.name + ".jpg"));
		element = other;
		this.setForeground(Color.WHITE);
		setText(element.name);
	}
	
	public Element getElement()
	{
		return element;
	}	
}
