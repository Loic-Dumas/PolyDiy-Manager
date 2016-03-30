package graphic.ui.account;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import common.facade.FacadeModifyAccount;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class UpdateAccount_welcomeUI extends AbstractUI {
	private JButton updateInfo = new JButton();
	private String textLogin;
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
		System.out.println(ID);
		FacadeModifyAccount facade = new FacadeModifyAccount();
		textLogin = facade.getLogin(ID);
		String textLastName = facade.getLastName(ID);
		String textFirstName = facade.getFirstName(ID);
		
		JLabel labelWelcome = new JLabel("Welcome ");
		labelWelcome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		labelWelcome.setBounds(204, 72, 166, 68);
		this.panel.add(labelWelcome);
		
		//
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
		
		JLabel lblAddress = new JLabel("address1");
		lblAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddress.setBounds(316, 380, 201, 35);
		this.panel.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("address2");
		lblAddress_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddress_1.setBounds(316, 412, 201, 35);
		this.panel.add(lblAddress_1);
		
		JLabel lblAddress_2 = new JLabel("address3");
		lblAddress_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAddress_2.setBounds(316, 447, 201, 35);
		this.panel.add(lblAddress_2);
		
		//JButton updateInfo = new JButton("update informations"); A NE SURTOUT PAS DELARER COMME CA!!!
		this.updateInfo.setText("update informations");
		this.updateInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		this.updateInfo.setBounds(243, 505, 178, 49);
		this.panel.add(updateInfo);
		this.updateInfo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {				
			if (arg0.getSource() == updateInfo) {
				this.notifyObservers("updateAccount");
				this.setChanged();
			}
		
	}
}