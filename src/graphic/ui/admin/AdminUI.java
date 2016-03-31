package graphic.ui.admin;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

/**
 * @author loicd_000
 *
 */
public class AdminUI extends AbstractUI {
	private JLabel label = new JLabel();
	
	
	/**
	 * create an AdminView
	 * @param communication
	 */
	public AdminUI(UIMessage communication) {
		super(communication);
		
		this.panel.setLayout(null);
		
		
		// text label lambda
		this.label.setText("Cet view est pour l'admin");
		this.label.setBounds(200, 2, 300, 23);
		this.panel.add(label);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = "";
		
		if (arg0.getActionCommand().equals("Back to logout")) {
			action = "back to logout";
		} 
		
		
		// we have an action, so we notify observers.
		if (!action.equals("")) {
			try {
				this.setChanged();
				this.notifyObservers(action);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			System.err.println("Button action not catch.");
		}
	}

}
