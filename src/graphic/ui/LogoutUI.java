package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import persistent.Session;

public class LogoutUI extends AbstractUI {
	private JButton yourAccount = new JButton();
	private JButton logout = new JButton();
	private Session session = null;
	
	public LogoutUI(Session session) {
		this.session = session;
		
		this.panel.setLayout(null);
		//modify the background colors
		getPanel().setForeground(UIManager.getColor("Tree.selectionBorderColor"));
		getPanel().setBackground(UIManager.getColor("controlHighlight"));
		
		// connection
		//this.connection.setPreferredSize(new Dimension(150,30));
		//this.connection.setText("Connect");
		this.logout.setText("Logout");
		this.logout.setBounds(146, 147, 89, 23);
		this.panel.add(logout);
		this.yourAccount.setText("Update your account");
		this.yourAccount.setBounds(230, 147, 89, 23);
		this.panel.add(yourAccount);
		
		this.logout.addActionListener(this);
		this.yourAccount.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeSession facade = new FacadeSession();
		try {
				if(arg0.getSource() == logout){
				facade.logout(this.session.getID());
				this.setChanged();
				this.notifyObservers("logout");
			}
			if(arg0.getSource() == yourAccount){
				this.setChanged();
				this.notifyObservers("yourAccount");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
