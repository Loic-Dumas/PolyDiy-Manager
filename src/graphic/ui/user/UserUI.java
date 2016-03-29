package graphic.ui.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import graphic.engine.AbstractUI;
import persistent.Session;

public class UserUI extends AbstractUI {
	private JButton logout = new JButton();
	private JButton myList = new JButton();
	private JButton shop = new JButton();
	private JLabel userLabel = new JLabel();
    private JPanel journalPanel = new JPanel(); 
	
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
		
		// shop button
		this.shop.setText("PolyDIY - Shop");
		this.shop.setBounds(160 , 30, 150, 23);
		this.panel.add(shop);
		this.shop.addActionListener(this);
		
		//Journal
		JLabel journal = new JLabel();
		journal.setText("Le journal de l'utilisateur " );
		journal.setBounds(10 , 100, 200, 23);
		this.panel.add(journal);
	    this.journalPanel.setBounds(2, 90, 500, 400);
	    this.journalPanel.setLayout(new BorderLayout());
	    this.journalPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black,1),BorderFactory.createLineBorder(Color.black,3)));
	    //prepare the JTable
		journalPanel.add(new JScrollPane(), BorderLayout.CENTER);
		this.panel.add(this.journalPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//FacadeSession facade = new FacadeSession();
		
		if (arg0.getActionCommand().equals("My lists")) {
			try {
				this.setChanged();
				this.notifyObservers("wishLists");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		
		else if (arg0.getActionCommand().equals("Back to logout")) {
			try {
				this.setChanged();
				this.notifyObservers("back to logout");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			System.err.println("Button action not catch.");
		}
	}
}
