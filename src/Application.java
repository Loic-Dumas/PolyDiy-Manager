import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
// TODO add Javadoc
/**
 * 
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class Application extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Map<String, JPanel> panels = new HashMap<String, JPanel>();
	
	public Application()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
	}
	
	public void addUI(String ui)
	{
		PanelFactory factory = null;
		switch(ui) {
		case "login":
			factory = new LoginUIFactory();
			this.panels.put(ui, factory.build());
			this.setContentPane(this.panels.get(ui));
			break;
		default:
			break;
		}
		this.setVisible(true);
	}
}
