package graphic.ui.seller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDSellerException;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeEditProfil;

public class SellerUI extends AbstractUI {
	FacadeEditProfil facade;
	private JButton account = new JButton();
	private JLabel label = new JLabel();
	private JLabel labNom = new JLabel();
	private JLabel labDesc = new JLabel();
	private JLabel labSiret = new JLabel();
	private JLabel labSite = new JLabel();
	private JButton edit = new JButton();
	private JButton manage = new JButton();
	
	public SellerUI(UIMessage communication) throws UnknownIDSellerException, ErrorConnectionException, AlertDriver {
		super(communication);
		facade = new FacadeEditProfil((int)this.communication.getElement("id_account"));
		this.panel.setLayout(null);
		//edit Profil Button
		this.edit.setText("Edit Profil");
		this.edit.setBounds(650, 200, 120, 35);
		this.panel.add(this.edit);
		this.edit.addActionListener(this);
		
		//Manage Shop
		this.manage.setText("Manage Shop");
		this.manage.setBounds(650, 250, 120, 35);
		this.panel.add(this.manage);
		this.manage.addActionListener(this);
		
		// logout button
		this.account.setText("Back to logout");
		this.account.setBounds(2, 2, 150, 23);
		this.panel.add(account);
		this.account.addActionListener(this);
		
		//label nameShop
		this.labNom.setText("Name of Shop : " + (facade.getNameShop()));
		this.labNom.setBounds(200, 200, 300, 23);
		this.panel.add(labNom);
		// description
		this.labDesc.setText("Description of Shop : " + (facade.getDescription()));
		this.labDesc.setBounds(200, 250, 300, 23);
		this.panel.add(labDesc);
		// Siret
		this.labSiret.setText("Siret : " + (facade.getSiret()));
		this.labSiret.setBounds(200, 300, 300, 23);
		this.panel.add(labSiret);
		// website
		this.labSite.setText("Website : " + (facade.getWebsite()));
		this.labSite.setBounds(200, 350, 300, 23);
		this.panel.add(labSite);
		
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
		}
		//manage Shop
		if (arg0.getActionCommand()== "Manage Shop") {
			try {
				this.setChanged();
				this.notifyObservers("manage");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
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
