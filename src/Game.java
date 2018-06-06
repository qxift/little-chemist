import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Game extends JFrame {

	private List<Element> elements;
	private PanelMix pnlMix;
	private PanelElement pnlElement;
	
	public Game()
	{
		elements = DataParsing.parseJson("../little-chemist/res/Atoms.json");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w=screenSize.width;
		int h=screenSize.height;
		setSize(w,h);

		pnlMix = new PanelMix(this);
		this.add(pnlMix, BorderLayout.CENTER);
		
		pnlElement = new PanelElement(this,elements);
		JScrollPane scroll = new JScrollPane(pnlElement, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setPreferredSize(new Dimension((int)(w*0.15), h));
		this.add(scroll, BorderLayout.EAST);
	}
	
	public Element getElement(int id) {
		return elements.get(id);
	}
	
	public Element mix (Element element1, Element element2)
	{
		for(Element el: elements)
		{
			List<Long> ingredients = el.ingredients;
			if (ingredients!=null && ingredients.size()==2)
			{
				if ((ingredients.get(0) ==element1.id && ingredients.get(1)==element2.id) 
						|| (ingredients.get(0)==element2.id && ingredients.get(1)==element1.id))
				{
					pnlElement.addIcon(el.id);
					setVisible(true);
					return el;
				}	
			}
			
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		Game gr = new Game();
		gr.setVisible(true);
		gr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
