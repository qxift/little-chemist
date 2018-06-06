import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconGUI extends JLabel implements ActionListener{

	private Element element;
	
	public IconGUI(Element other)
	{
		super();
		setMinimumSize(new Dimension(50,50));
		setMaximumSize(new Dimension(100,50));
		element = other;
		setText(element.name);
		
	}
	
	public Element getElement()
	{
		return element;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
