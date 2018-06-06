import java.awt.Color;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelElement extends JPanel implements DragGestureListener{

	private Game game;
	private List<IconGUI> icons;
	
	public PanelElement(Game panel, List<Element> elements)
	{
		super();
		game = panel;
		
		icons = new ArrayList<IconGUI>();
		
		for(int i = 0; i<6; i++)
		{
			addIcon(i);
		}		
		setBackground(new Color(42,64,105));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
	public IconGUI addIcon(int id)
	{
		IconGUI icon = new IconGUI(game.getElement(id));
		
		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(icon, DnDConstants.ACTION_COPY, this);
		
		for(int i = 0; i<icons.size(); i++)
		{
			if(icons.get(i).getElement().id==icon.getElement().id)
			{
				return icon;
			}
		}
		add(icon);
		icons.add(icon);
		return icon;
	}
	
	@Override
	public void dragGestureRecognized(DragGestureEvent e) 
	{
		IconGUI icon = (IconGUI)(e.getComponent());
		int id = icon.getElement().id;
		Transferable transferable = new StringTransferable(String.valueOf(id));
		//new IconTransferable((IconGUI)(e.getComponent()));
		e.startDrag(null, transferable);		
	}
}
