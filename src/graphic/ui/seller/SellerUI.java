package graphic.ui.seller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import common.facade.FacadeEditProfil;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class SellerUI extends AbstractUI {
	FacadeEditProfil facade;
	private JButton account = new JButton();
	private JLabel label = new JLabel();
	private JLabel labNom = new JLabel();
	private JButton edit = new JButton();
	private JButton manage = new JButton();
	
	public SellerUI(UIMessage communication) {
		super(communication);
		facade = new FacadeEditProfil((int)this.communication.getElement("id_account"));
		this.panel.setLayout(null);
		//edit Profil Button
		this.edit.setText("Edit Profil");
		this.edit.setBounds(650, 300, 120, 35);
		this.panel.add(this.edit);
		this.edit.addActionListener(this);
		
		//Manage Shop
		this.manage.setText("Manage Shop");
		this.manage.setBounds(650, 350, 120, 35);
		this.panel.add(this.manage);
		this.manage.addActionListener(this);
		
		// logout button
		this.account.setText("Back to logout");
		this.account.setBounds(2, 2, 150, 23);
		this.panel.add(account);
		this.account.addActionListener(this);
		
		//label nom
		this.labNom.setText("name shop");
		this.labNom.setBounds(200, 200, 300, 23);
		this.panel.add(labNom);

		// text label 
		this.label.setText("Cet view est pour le seller");
		this.label.setBounds(200, 2, 300, 23);
		this.panel.add(label);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = "";
		// edit Profil
		if (arg0.getSource()== edit) {
			try {
				this.notifyObservers("edit");
				this.setChanged();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		//manage Shop
		if (arg0.getSource()== manage) {
				try {
					this.notifyObservers("edit");
					this.setChanged();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
		// back to logout
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
}
}
