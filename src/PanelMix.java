import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelMix extends JPanel implements DropTargetListener, MouseListener, MouseMotionListener{

	private Game screen;
	private IconGUI selected;
	private int xPressed, yPressed;
	
	public PanelMix(Game panel)
	{
		screen = panel;
		new DropTarget(screen, DnDConstants.ACTION_MOVE, this, true, null);	
		
		setBackground(new Color(19,35,73));
		setLayout(null);		
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub

	}


	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent e) 
	{
		try 
		{
			DropTarget target = (DropTarget) e.getSource();
			Component component = (Component) target.getComponent();
			Point location = (Point) component.getMousePosition();
			Transferable t = e.getTransferable();

			if (e.isDataFlavorSupported(DataFlavor.stringFlavor)) 
			{

				String id = (String) t.getTransferData(DataFlavor.stringFlavor);

				if (id != null) 
				{
					e.dropComplete(true);
					int idNum = Integer.valueOf(id);
					addToMixPanel(location, idNum);					
				}
			} 
			else 
			{
				e.rejectDrop();
			}
		} 
		catch (java.io.IOException e2) 
		{
		} 
		catch (UnsupportedFlavorException e2) 
		{
		}
	}
	
	public void addToMixPanel(Point loc, int id) 
	{
		Element el = screen.getElement(id);
		
		IconGUI iconGUI = new IconGUI(el);
		iconGUI.addMouseListener(this);
		iconGUI.addMouseMotionListener(this);
		add(iconGUI);
		loc.setLocation(loc.getX()-50, loc.getY()-75);
		iconGUI.setLocation(loc);
		iconGUI.setSize(iconGUI.getPreferredSize());
		
		repaint();		
	}
	
	public void removeFromMixPanel(IconGUI iconGUI) 
	{	
		if(iconGUI!=null)
		{
			iconGUI.removeMouseListener(this);
			iconGUI.removeMouseMotionListener(this);
			
			remove(iconGUI);
			repaint();
		}	
	}


	@Override
	public void mouseDragged(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
		if (selected!=null)
		{
			int savedX = selected.getX();
			int savedY = selected.getY();			
			selected.setLocation(savedX+e.getX()-xPressed,savedY+e.getY()-yPressed);
			
			IconGUI test = collision(selected);
			if(test!=null)
			{
				combine(selected,test);
			}
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
		selected = (IconGUI) e.getSource();	
		xPressed = e.getX();
		yPressed = e.getY();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
		selected = null;		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public IconGUI collision(IconGUI icon)
	{
		Component[] arr = this.getComponents();		
		for(Component icoon: arr)
		{
			if(icon!=icoon && icon.getBounds().intersects(icoon.getBounds()))
			{
				return (IconGUI)icoon;
			}
		}
		return null;
	}
	
	public void combine (IconGUI icon1, IconGUI icon2)
	{
		Element result = screen.mix(icon1.getElement(), icon2.getElement());
		if(result!=null)
		{
			addToMixPanel(icon1.getLocation(),result.id);
			selected = null;
			removeFromMixPanel(icon1);
			removeFromMixPanel(icon2);
			
//			screen.getPnlElement().addIcon(result.id);
		}
	}
}
