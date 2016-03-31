package graphic.ui.session;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeSession;

public class LogoutUI extends AbstractUI {
	private JButton logout = new JButton();
	private JButton user = new JButton();	
	
	public LogoutUI(UIMessage communication) {
		super(communication);
		
		this.panel.setLayout(null);
		//modify the background colors
		getPanel().setForeground(UIManager.getColor("Tree.selectionBorderColor"));
		getPanel().setBackground(UIManager.getColor("controlHighlight"));

		this.logout.setText("Logout");
		this.logout.setBounds(146, 147, 89, 23);
		this.panel.add(logout);
		
		this.logout.addActionListener(this);
		
		this.user.setText("User");
		this.user.setBounds(146, 180, 89, 23);
		this.panel.add(user);
		this.user.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeSession facade = new FacadeSession();
		
		if (arg0.getActionCommand().equals("User")) {
			try {
				this.setChanged();
				this.notifyObservers("user");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		
		else if (arg0.getActionCommand().equals("Logout")) {
			try {
				facade.logout((int)this.communication.getElement("id_account"));
				this.setChanged();
				this.notifyObservers("logout");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
