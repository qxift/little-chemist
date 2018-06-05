import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Game extends JFrame implements DragGestureListener{

	private JScrollPane scroll;
	private JPanel pnlElement;
	private PanelMix pnlMix;
	private int w;
	private int h;
	private List<IconGUI> icons;
	private List<Element> elements;
	
	public Game()
	{
		icons = new ArrayList<IconGUI>();
		elements = DataParsing.parseJson("../little-chemist/res/Rules.json");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		w=screenSize.width;
		h=screenSize.height;
		setSize(w,h);

		pnlMix = new PanelMix(this);
		pnlElement = new JPanel();
		for(int i = 0; i<4; i++)
		{
			IconGUI icon = new IconGUI(elements.get(i));
			icons.add(icon);
			
			DragSource ds = new DragSource();
			ds.createDefaultDragGestureRecognizer(icon, DnDConstants.ACTION_COPY, this);
			
			pnlElement.add(icon);
		}
		
		pnlElement.setBackground(new Color(42,64,105));
		pnlElement.setPreferredSize(new Dimension((int)(100+50), h)); //fire.getMaximumSize().width
		pnlElement.setLocation((int)(w*0.8),0);
		pnlElement.setLayout(new BoxLayout(pnlElement,BoxLayout.Y_AXIS));
		
		pnlMix.setBackground(new Color(19,35,73));
		pnlMix.setSize((int)(w*0.8), h);
		pnlMix.setLocation(0,0);
		
		
		scroll = new JScrollPane(pnlElement, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setSize(new Dimension((int)(w*0.2), h));
		scroll.setLocation((int)(w*0.8),0);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		
		this.add(pnlMix, BorderLayout.CENTER); 
		this.add(scroll, BorderLayout.EAST);
	
	}
	
	public JPanel getMixingSpace()
	{
		return pnlMix;
	}
	public void setMixingSpace(Color c)
	{
		pnlMix.setBackground(c);
	}
	public static void main(String[] args)
	{
		Game gr = new Game();
		gr.setVisible(true);
		gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent e) {
		// TODO Auto-generated method stub
		
		e.startDrag(null, new IconTransferable((IconGUI)(e.getComponent())));
		
	}
}
