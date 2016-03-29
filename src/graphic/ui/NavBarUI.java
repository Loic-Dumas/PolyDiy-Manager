package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import persistent.Session;

public class NavBarUI extends AbstractUI{
	private JButton account = new JButton();
	private JButton user = new JButton();
	private JButton seller = new JButton();
	private JButton admin = new JButton();
	private JButton logout = new JButton();
	private JLabel userLabel = new JLabel();
	
	private Session session = null;
	
	public NavBarUI(Session session) {
		this.session = session;
		
//		this.panel.setLayout(null);
		
		this.userLabel.setText("User : " + session.getID());
		this.userLabel.setBounds(2 , 2, 145 , 23);
		this.panel.add(userLabel);

		// account button
		this.account.setText("Account");
		this.account.setBounds(150, 2, 145, 23);
		this.panel.add(account);
		this.account.addActionListener(this);

		// user button
		this.user.setText("User");
		this.user.setBounds(300, 2, 145, 23);
		this.panel.add(user);
		this.user.addActionListener(this);

		// Seller button
		this.seller.setText("Seller");
		this.seller.setBounds(450, 2, 145, 23);
		this.panel.add(seller);
		this.seller.addActionListener(this);

		// Admin button
		this.admin.setText("Admin");
		this.admin.setBounds(600, 2, 145, 23);
		this.panel.add(admin);
		this.admin.addActionListener(this);

		// logout button
		this.logout.setText("Logout");
		this.logout.setBounds(900, 2, 145, 23);
		this.panel.add(logout);
		this.logout.addActionListener(this);

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeSession facade = new FacadeSession();
		String action = "";
		
		if (arg0.getActionCommand().equals("Account")) {
			action = "account";
		} 

		
		else if (arg0.getActionCommand().equals("User")) {
			action = "user";
		} 

		
		else if (arg0.getActionCommand().equals("Seller")) {
			action = "seller";
		} 

		
		else if (arg0.getActionCommand().equals("Admin")) {
			action = "admin";
		} 

		
		else if (arg0.getActionCommand().equals("Logout")) {
			try {
				facade.logout(this.session.getID());
			} catch (Exception e) {
				e.printStackTrace();
			}
			action = "logout";
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