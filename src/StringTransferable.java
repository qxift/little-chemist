import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class StringTransferable implements Transferable {

	private String id = "";

	public StringTransferable(String elementName) 
	{
	  id = elementName;
	}

	public DataFlavor[] getTransferDataFlavors() 
	{
      return new DataFlavor[]{DataFlavor.stringFlavor};
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) 
    {

      if (!isDataFlavorSupported(flavor)) 
      {
        return false;
      }
      return true;
    }

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException 
    {
      return id;
    }
}
