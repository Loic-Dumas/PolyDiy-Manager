package graphic.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.facade.FacadeModifyAccount;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class UpdateAccountUI extends AbstractUI {
	private JTextField tfLogin;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfAddressRoad;
	private JTextField tfAddressCity;
	private JTextField tfAddressPostalCode;
	private JButton btCancel = new JButton();
	private JButton btValidate = new JButton();
	
	/**
	 * Create the panel ModifyIdentityUI.
	 * Here you can modify your login, last name, first name
	 * and your address.
	 */
	
	public UpdateAccountUI(UIMessage communication) throws Exception {
		
		super(communication);
		this.panel.setLayout(null);
		
		
		int ID = (int) this.communication.getElement("id_account");
		FacadeModifyAccount facade = new FacadeModifyAccount();
		String textLogin = facade.getLogin(ID);
		String textLastName = facade.getLastName(ID);
		String textFirstName = facade.getFirstName(ID);
		/* String textAddressCity = facade.getFirstName(session);
		 * String textAddressRoad = facade.getFirstName(session);
		 * String textFirstName = facade.getFirstName(session);
		 */
		
		
		//Label to inform the user where he is.
		JLabel labelInfo = new JLabel("Here you can modify your acount informations !");
		labelInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		labelInfo.setBounds(151, 74, 489, 33);
		this.panel.add(labelInfo);
		
		
		//Labels for the formular
		JLabel lblNewLogin = new JLabel("New login :");
		lblNewLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewLogin.setBounds(190, 159, 127, 33);
		this.panel.add(lblNewLogin);
		
		JLabel lblNewLastName = new JLabel("New last name :");
		lblNewLastName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewLastName.setBounds(145, 203, 172, 33);
		this.panel.add(lblNewLastName);
		
		JLabel lblNewFistName = new JLabel("New fist name :");
		lblNewFistName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewFistName.setBounds(151, 247, 166, 33);
		this.panel.add(lblNewFistName);
		
		JLabel lblNewAddressRoad = new JLabel("New address (road) :");
		lblNewAddressRoad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewAddressRoad.setBounds(95, 291, 222, 33);
		this.panel.add(lblNewAddressRoad);
		
		JLabel lblNewAddressCity = new JLabel("New address (city) :");
		lblNewAddressCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewAddressCity.setBounds(108, 335, 209, 33);
		this.panel.add(lblNewAddressCity);
		
		JLabel lblNewAddresspostal = new JLabel("New address (postal code) :");
		lblNewAddresspostal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewAddresspostal.setBounds(32, 379, 285, 33);
		this.panel.add(lblNewAddresspostal);
		
		
		//informations to place in each textfield
		tfLogin.setText(textLogin);
		tfLogin.setBounds(327, 159, 313, 35);
		this.panel.add(tfLogin);
		tfLogin.setColumns(10);
		
		tfLastName.setText(textLastName);
		tfLastName.setColumns(10);
		tfLastName.setBounds(327, 203, 313, 35);
		this.panel.add(tfLastName);
		
		tfFirstName.setText(textFirstName);
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(327, 247, 313, 35);
		this.panel.add(tfFirstName);
		
		tfAddressRoad.setText("addressRoadBD"); //A MODIFIER
		tfAddressRoad.setColumns(10);
		tfAddressRoad.setBounds(327, 291, 313, 35);
		this.panel.add(tfAddressRoad);
		
		tfAddressCity.setText("adressCityBD"); //A MODIFIER
		tfAddressCity.setColumns(10);
		tfAddressCity.setBounds(327, 335, 313, 35);
		this.panel.add(tfAddressCity);
		
		tfAddressPostalCode.setText("addressPostalCodeBD"); //A MODIFIER
		tfAddressPostalCode.setColumns(10);
		tfAddressPostalCode.setBounds(327, 379, 313, 35);
		this.panel.add(tfAddressPostalCode);
		
		
		//the buttons to validate the update or to cancel the action
		this.btCancel.setText("Cancel");
		btCancel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btCancel.setBounds(129, 470, 135, 56);
		this.panel.add(btCancel);
		this.btCancel.addActionListener(this);
		
		this.btValidate.setText("Validate");
		btValidate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btValidate.setBounds(542, 470, 135, 56);
		this.panel.add(btValidate);
		this.btValidate.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
