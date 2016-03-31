package graphic.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class NavBarUI extends AbstractUI{
	private JButton account = new JButton();
	private JButton user = new JButton();
	private JButton seller = new JButton();
	private JButton admin = new JButton();
	private JButton logout = new JButton();
	private JLabel userLabel = new JLabel();
	
	public NavBarUI(UIMessage communication) {
		super(communication);
		
//		this.panel.setLayout(null);
		
		this.userLabel.setText("Welcome " + this.communication.getElement("login"));
		this.panel.add(userLabel);

		// account button
		this.account.setText("Account");
		this.panel.add(account);
		this.account.addActionListener(this);

		// user button
		if (this.communication.isExisting("id_user")) {
			this.user.setText("User");
			this.panel.add(user);
			this.user.addActionListener(this);
		}

		// Seller button
		if (this.communication.isExisting("id_seller")) {
			this.seller.setText("Seller");
			this.panel.add(seller);
			this.seller.addActionListener(this);
		}

		// Admin button
		if (this.communication.isExisting("id_admin")) {
			this.admin.setText("Admin");
			this.panel.add(admin);
			this.admin.addActionListener(this);
		}

		// logout button
		this.logout.setText("Logout");
		this.panel.add(logout);
		this.logout.addActionListener(this);
		
		this.panel.setBackground(Color.GRAY);

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
				facade.logout((int)this.communication.getElement("id_account"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
		} else {
			System.err.println("Button action not catch.");
		}
	}
}