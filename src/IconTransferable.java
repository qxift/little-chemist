//import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

//import javax.swing.JPanel;

public class IconTransferable implements Transferable{

	  protected static DataFlavor iconFlavor = new DataFlavor(IconGUI.class, "An IconGUI Object");
	  protected static DataFlavor[] supportedFlavors = { iconFlavor };
	  IconGUI icon;
	 
	public IconTransferable(IconGUI e)
	   {
		icon = new IconGUI(e.getElement());
		icon.setVisible(true);
	   }

	public IconGUI getIcon()
	{
		return icon;
	}
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		 if (flavor.equals(iconFlavor) || flavor.equals(DataFlavor.stringFlavor))
		      return true;
		    return false;
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		   if (flavor.equals(iconFlavor))
			      return icon;
			    else if (flavor.equals(DataFlavor.stringFlavor))
			      return icon.toString();
			    else
			      throw new UnsupportedFlavorException(flavor);
	}

}
