package graphic.engine;

import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;

public abstract class AbstractUI extends Observable implements ActionListener {
	protected JPanel panel = new JPanel();
	protected UIMessage communication = new UIMessage();
	
	public AbstractUI(UIMessage communication) {
		this.communication = communication;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public void notifyObservers(String message) {
		this.communication.setTransition(message);
		this.notifyObservers(this.communication);
	}
}
