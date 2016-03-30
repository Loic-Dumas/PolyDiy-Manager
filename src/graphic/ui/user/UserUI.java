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
import graphic.engine.UIMessage;

public class UserUI extends AbstractUI {
	private JButton myList = new JButton();
	private JButton shop = new JButton();
    private JPanel journalPanel = new JPanel(); 
	
	public UserUI(UIMessage communication) {
		super(communication);
		
		this.panel.setLayout(null);


		// wish list button
		this.myList.setText("My lists");
		this.myList.setBounds(2 , 2, 150, 23);
		this.panel.add(myList);
		this.myList.addActionListener(this);
		
		// shop button
		this.shop.setText("PolyDIY - Shop");
		this.shop.setBounds(160 , 2, 150, 23);
		this.panel.add(shop);
		this.shop.addActionListener(this);
		
		//Journal
		JLabel journal = new JLabel();
		journal.setText("Le journal de l'utilisateur " );
		journal.setBounds(10 , 30, 200, 23);
		this.panel.add(journal);
	    this.journalPanel.setBounds(2, 60, 700, 500);
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
		
	}
}
