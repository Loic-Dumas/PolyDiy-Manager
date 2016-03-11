package graphic.engine;

import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;

public abstract class AbstractUI extends Observable implements ActionListener {
	protected JPanel panel = new JPanel();
	
	public JPanel getPanel() {
		return this.panel;
	}
}
