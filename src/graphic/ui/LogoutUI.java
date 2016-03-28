package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import persistent.Session;

public class LogoutUI extends AbstractUI {
	private JButton logout = new JButton();
	private JButton user = new JButton();
	private Session session = null;
	
	
	public LogoutUI(Session session) {
		this.session = session;
		
		this.panel.setLayout(null);
		
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
			//System.out.println("logoutUI - actionPerformed - case user");
			try {
				this.setChanged();
				this.notifyObservers("user");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		
		else if (arg0.getActionCommand().equals("Logout")) {
			//System.out.println("logoutUI - actionPerformed - case logout");
			try {
				facade.logout(this.session.getID());
				this.setChanged();
				this.notifyObservers("logout");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
