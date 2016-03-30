package graphic.ui.account;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import common.facade.FacadeModifyAccount;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class UpdateAccountUI extends AbstractUI {
	private JTextField tfLogin = new JTextField();
	private JTextField tfLastName= new JTextField();
	private JTextField tfFirstName= new JTextField();
	private JTextField tfAddressRoad= new JTextField();
	private JTextField tfAddressCity= new JTextField();
	private JTextField tfAddressPostalCode= new JTextField();
	private JButton btCancel = new JButton();
	private JButton btValidate = new JButton();
	private JLabel labelInfo = new JLabel();
	private JLabel lblNewLogin = new JLabel();
	private JLabel lblNewLastName = new JLabel();
	private JLabel lblNewFirstName = new JLabel();
	private JLabel lblNewAddressCity = new JLabel();
	private JLabel lblNewAddressRoad = new JLabel();
	private JLabel lblNewAddresspostal = new JLabel();
	
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
		//A FAIRE POUR LES ADRESSES
		
		
		//Label to inform the user where he is.
		this.labelInfo.setText("Here you can modify your acount informations !");
		this.labelInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.labelInfo.setBounds(151, 74, 489, 33);
		this.panel.add(labelInfo);
		
		
		//Labels for the formular
		this.lblNewLogin.setText("New login :");
		this.lblNewLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.lblNewLogin.setBounds(190, 159, 127, 33);
		this.panel.add(lblNewLogin);
		
		this.lblNewLastName.setText("New last name :");
		lblNewLastName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		lblNewLastName.setBounds(145, 203, 172, 33);
		this.panel.add(lblNewLastName);
		
		this.lblNewFirstName.setText("New fist name :");
		this.lblNewFirstName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.lblNewFirstName.setBounds(151, 247, 166, 33);
		this.panel.add(lblNewFirstName);
		
		this.lblNewAddressRoad.setText("New address (road) :");
		this.lblNewAddressRoad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.lblNewAddressRoad.setBounds(95, 291, 222, 33);
		this.panel.add(lblNewAddressRoad);
		
		this.lblNewAddressCity.setText("New address (city) :");
		this.lblNewAddressCity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.lblNewAddressCity.setBounds(108, 335, 209, 33);
		this.panel.add(lblNewAddressCity);
		
		this.lblNewAddresspostal.setText("New address (postal code) :");
		this.lblNewAddresspostal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		this.lblNewAddresspostal.setBounds(32, 379, 285, 33);
		this.panel.add(lblNewAddresspostal);
		
		
		//informations to place in each textfield
		this.tfLogin.setText(textLogin);
		this.tfLogin.setBounds(327, 159, 313, 35);
		this.tfLogin.setColumns(10);
		this.panel.add(tfLogin);
		
		this.tfLastName.setText(textLastName);
		this.tfLastName.setColumns(10);
		this.tfLastName.setBounds(327, 203, 313, 35);
		this.panel.add(tfLastName);
		
		this.tfFirstName.setText(textFirstName);
		this.tfFirstName.setColumns(10);
		this.tfFirstName.setBounds(327, 247, 313, 35);
		this.panel.add(tfFirstName);
		
		this.tfAddressRoad.setText("addressRoadBD"); //A MODIFIER
		this.tfAddressRoad.setColumns(10);
		this.tfAddressRoad.setBounds(327, 291, 313, 35);
		this.panel.add(tfAddressRoad);
		
		this.tfAddressCity.setText("adressCityBD"); //A MODIFIER
		this.tfAddressCity.setColumns(10);
		this.tfAddressCity.setBounds(327, 335, 313, 35);
		this.panel.add(tfAddressCity);
		
		this.tfAddressPostalCode.setText("addressPostalCodeBD"); //A MODIFIER
		this.tfAddressPostalCode.setColumns(10);
		this.tfAddressPostalCode.setBounds(327, 379, 313, 35);
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
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Cancel")) { //arg0.getSource() == updateInfo
			this.setChanged();
			this.notifyObservers("account");
		} else if (arg0.getActionCommand().equals("Validate")) {
			//modifier les infos
		}
	} //end Override

}
