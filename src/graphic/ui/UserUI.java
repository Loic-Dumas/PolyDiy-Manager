package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import graphic.engine.AbstractUI;
import persistent.Session;

public class UserUI extends AbstractUI{
	private JButton logout = new JButton();
	private JButton myList = new JButton();
	private JLabel userLabel = new JLabel();
	private Session session = null;
	
	public UserUI(Session session) {
		this.session = session;
		
		this.panel.setLayout(null);

		// logout button
		this.logout.setText("Back to logout");
		this.logout.setBounds(2, 2, 150, 23);
		this.panel.add(logout);
		this.logout.addActionListener(this);

		//User label 
		this.userLabel.setText("User : " + session.getID());
		this.userLabel.setBounds(160 , 2, 89, 23);
		this.panel.add(userLabel);

		// wish list button
		this.myList.setText("My lists");
		this.myList.setBounds(2 , 30, 150, 23);
		this.panel.add(myList);
		this.myList.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//FacadeSession facade = new FacadeSession();
		
		if (arg0.getActionCommand().equals("My lists")) {
			//System.out.println("UserUI - actionPerformed - case user");
			try {
				this.setChanged();
				this.notifyObservers("wishLists");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		
		else if (arg0.getActionCommand().equals("Back to logout")) {
			//System.out.println("logoutUI - actionPerformed - case logout");
			try {
				this.setChanged();
				this.notifyObservers("back to logout");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
