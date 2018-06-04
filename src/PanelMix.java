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
	private IconGUI drop;
	private DropTarget thing;
	
	public PanelMix(Game panel)
	{
		screen = panel; //right?
		thing = new DropTarget(screen, DnDConstants.ACTION_MOVE, this, true, null);	
		setVisible(true);
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
		// TODO Auto-generated method stub
		 e.acceptDrop(e.getDropAction());
		 e.getTransferable();
		 e.dropComplete(true);
		 setVisible(true);
		
		 //hello testing stuff
		 
		 
//		try {
//	        IconTransferable t = (IconTransferable)(e.getTransferable());
//
//	        if (e.isDataFlavorSupported(DataFlavor.stringFlavor)) {
//	          e.acceptDrop(e.getDropAction());
//
//	          String s;
//	          s = (String) t.getTransferData(DataFlavor.stringFlavor);
//
//	          drop.setText(s);
//
//	          e.dropComplete(true);
//	          
//	        } 
//	        else
//	          e.rejectDrop();
//	}
//	    catch (java.io.IOException e2) {
//	    } 
//	    catch (UnsupportedFlavorException e2) {
//	    }
	    
	    
	}
}
