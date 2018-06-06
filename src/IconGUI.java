import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconGUI extends JLabel {

	private Element element;
	ImageIcon icon;
	
	public IconGUI(Element other)
	{
		super(new ImageIcon("../little-chemist/images/" + other.name + ".jpg"));
//		icon = new ImageIcon("../little-chemist/images/" + other.name + ".jpg");
		setMinimumSize(new Dimension(50,50));
		setMaximumSize(new Dimension(100,50));
//		setPreferredSize(new Dimension(50,50));
		element = other;
		//setText(element.name);	
	}
	
	public Element getElement()
	{
		return element;
	}	
}
