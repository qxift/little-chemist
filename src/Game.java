import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Game extends JFrame {

	private List<Element> elements;
	
	public Game()
	{
		elements = DataParsing.parseJson("../little-chemist/res/Atoms.json");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w=screenSize.width;
		int h=screenSize.height;
		setSize(w,h);

		PanelMix pnlMix = new PanelMix(this);
		pnlMix.setBackground(new Color(19,35,73));
		pnlMix.setLayout(null);
		
		PanelElement pnlElement = new PanelElement(this,elements);
		JScrollPane scroll = new JScrollPane(pnlElement, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setPreferredSize(new Dimension((int)(w*0.15), h));

		this.add(pnlMix, BorderLayout.CENTER); 
		this.add(scroll, BorderLayout.EAST);
	}
	
	public Element getElement(int id) {
		return elements.get(id);
	}

	public static void main(String[] args)
	{
		Game gr = new Game();
		gr.setVisible(true);
		gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
