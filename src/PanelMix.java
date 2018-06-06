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

import javax.swing.JPanel;

public class PanelMix extends JPanel implements DropTargetListener{

	private Game screen;
	
	public PanelMix(Game panel)
	{
		screen = panel;
		new DropTarget(screen, DnDConstants.ACTION_MOVE, this, true, null);	
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
	public void drop(DropTargetDropEvent e) {
		try {
			DropTarget target = (DropTarget) e.getSource();
			Component component = (Component) target.getComponent();
			Point location = (Point) component.getMousePosition();
			Transferable t = e.getTransferable();

			if (e.isDataFlavorSupported(DataFlavor.stringFlavor)) {

				String id = (String) t.getTransferData(DataFlavor.stringFlavor);

				if (id != null) {
					e.dropComplete(true);
					int idNum = Integer.valueOf(id);
					addToMixPanel(location, idNum);
					
				}
			} else {
				e.rejectDrop();
			}
		} catch (java.io.IOException e2) {
		} catch (UnsupportedFlavorException e2) {
		}
	}
	
	public void addToMixPanel(Point loc, int id) {
		Element el = screen.getElement(id);
		IconGUI iconGUI = new IconGUI(el);
		
		add(iconGUI);
		iconGUI.setLocation(loc);
		iconGUI.setSize(iconGUI.getPreferredSize());
		repaint();
	}
}
