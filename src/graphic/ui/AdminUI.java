package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import graphic.engine.AbstractUI;
import persistent.Session;

public class AdminUI extends AbstractUI {
	private JButton account = new JButton();
	private JLabel label = new JLabel();

	private Session session = null;
	
	
	public AdminUI(Session session) {
		this.session = session;
		
		this.panel.setLayout(null);

		// logout button
		this.account.setText("Back to logout");
		this.account.setBounds(2, 2, 150, 23);
		this.panel.add(account);
		this.account.addActionListener(this);
		
		
		// text label lambda
		this.label.setText("Cet view est pour l'admin");
		this.label.setBounds(200, 2, 300, 23);
		this.panel.add(label);
	}

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
