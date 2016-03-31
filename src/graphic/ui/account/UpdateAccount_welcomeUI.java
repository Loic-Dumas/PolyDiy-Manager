package graphic.ui.account;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeModifyAccount;

public class UpdateAccount_welcomeUI extends AbstractUI {
	private JButton updateInfo = new JButton();
	private JLabel labelLoginUser = new JLabel();
	
	/**
	 * Create the panel to give the information of the user's account.
	 * @throws Exception 
	 */
	
	public UpdateAccount_welcomeUI(UIMessage communication) throws Exception {
		
		super(communication);
		this.panel.setLayout(null);
		
		//to take the actual account informations
		int ID = (int) this.communication.getElement("id_account");
		FacadeModifyAccount facade = new FacadeModifyAccount();
		String textLogin = facade.getLogin(ID);
		String textLastName = facade.getLastName(ID);
		String textFirstName = facade.getFirstName(ID);
		String textAdressRoad = facade.getAddressRoad(ID); 
		String textAddressCity = facade.getAddressCity(ID); 
		String textAddressPostal =facade.getAddressPostal(ID); 
		
		JLabel labelWelcome = new JLabel("Welcome ");
		labelWelcome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		labelWelcome.setBounds(204, 72, 166, 68);
		this.panel.add(labelWelcome);
		
		labelLoginUser.setText(textLogin);
		labelLoginUser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		labelLoginUser.setBounds(380, 85, 239, 42);
		this.panel.add(labelLoginUser);
		
		JLabel labelIntro = new JLabel("If you want to modify your account informations click on \"update informations\"");
		labelIntro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		labelIntro.setBounds(41, 138, 717, 42);
		this.panel.add(labelIntro);
		
		JLabel labelInfoLogin = new JLabel("Your login : ");
		labelInfoLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelInfoLogin.setBounds(220, 216, 86, 35);
		this.panel.add(labelInfoLogin);
		
		JLabel labelInfoFirstName = new JLabel("Your first name : ");
		labelInfoFirstName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelInfoFirstName.setBounds(182, 268, 124, 35);
		this.panel.add(labelInfoFirstName);
		
		JLabel labelInfoLastName = new JLabel("Your last name : ");
		labelInfoLastName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelInfoLastName.setBounds(182, 324, 124, 35);
		this.panel.add(labelInfoLastName);
		
		JLabel labelInfoAdress = new JLabel("Your address  : ");
		labelInfoAdress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelInfoAdress.setBounds(192, 380, 114, 35);
		this.panel.add(labelInfoAdress);
		
		JLabel lblLoginuser = new JLabel(textLogin);
		lblLoginuser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLoginuser.setBounds(319, 216, 198, 35);
		this.panel.add(lblLoginuser);
		
		JLabel lblFirstnameuser = new JLabel(textFirstName);
		lblFirstnameuser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFirstnameuser.setBounds(316, 268, 201, 35);
		this.panel.add(lblFirstnameuser);
		
		JLabel lblLastnameuser = new JLabel(textLastName);
		lblLastnameuser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLastnameuser.setBounds(316, 324, 201, 35);
		this.panel.add(lblLastnameuser);
		
		JLabel lblAddressRoad = new JLabel(textAdressRoad);
		lblAddressRoad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddressRoad.setBounds(316, 380, 201, 35);
		this.panel.add(lblAddressRoad);
		
		JLabel lblAddressPostal = new JLabel(textAddressPostal);
		lblAddressPostal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddressPostal.setBounds(316, 412, 201, 35);
		this.panel.add(lblAddressPostal);
		
		JLabel lblAddressCity = new JLabel(textAddressCity);
		lblAddressCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddressCity.setBounds(316, 447, 201, 35);
		this.panel.add(lblAddressCity);
		
		//JButton updateInfo = new JButton("update informations"); A NE SURTOUT PAS DELARER COMME CA!!!
		this.updateInfo.setText("update informations");
		this.updateInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		this.updateInfo.setBounds(243, 505, 178, 49);
		this.panel.add(updateInfo);
		this.updateInfo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
			if (arg0.getActionCommand().equals("update informations")) { 
				this.setChanged();
				this.notifyObservers("updateAccount");
			}
		
	}
}