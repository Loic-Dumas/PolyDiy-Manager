package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;

public class LogoutUI extends AbstractUI {
	private JButton logout = new JButton();
	private String token = null;
	
	public LogoutUI(String token) {
		this.token = token;
		
		this.panel.setLayout(null);
		
		// connection
		//this.connection.setPreferredSize(new Dimension(150,30));
		//this.connection.setText("Connect");
		this.logout.setText("Logout");
		this.logout.setBounds(146, 147, 89, 23);
		this.panel.add(logout);
		
		this.logout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeSession facade = new FacadeSession();
		try {
			facade.logout(this.token);
			this.setChanged();
			this.notifyObservers("logout");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
