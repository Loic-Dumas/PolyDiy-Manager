package graphic.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.facade.FacadeModifyAccount;
import graphic.engine.AbstractUI;
import persistent.Session;

/**
 * ModifyIdentityUI class is used to modify 
 * all the personnal account informations.
 * 
 * 
 * @author Geoffray Faustine
 * @version 1.0
 * @since 2016-21-03
 */

public class ModifyIdentityUI extends AbstractUI{
	//the UI objects are :
	private JLabel lbmodifyAccount = new JLabel();
	private JTextField login = new JTextField();
	private JLabel lblogin = new JLabel();
	private JTextField lastName = new JTextField();
	private JLabel lblastName = new JLabel();
	private JTextField firstName = new JTextField();
	private JLabel lbfirstName = new JLabel();
	private JButton validate = new JButton();
	private Session session;

	//to place the UI objects
	public ModifyIdentityUI(Session session) {
		this.session = session;
		this.panel.setLayout(null);
		
		//label modifyAccount
		this.lbmodifyAccount.setText("Modify Account Panel");
		this.lbmodifyAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lbmodifyAccount.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbmodifyAccount.setBounds(0, 31, 1000, 30);
		this.panel.add(lbmodifyAccount);

		//label login
		this.lblogin.setText("new login");
		this.lblogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblogin.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblogin.setBounds(0, 31, 1000, 30);
		this.panel.add(lblogin);

		//textfield login
		this.login.setBounds(356, 92, 105, 20);
		this.panel.add(login);
		this.login.setColumns(10);

		//label lastName
		this.lblastName.setText("new lastName");
		this.lblastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblastName.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblastName.setBounds(0, 31, 1000, 30);
		this.panel.add(lblastName);
		
		//textfield lastName				
		this.lastName.setBounds(356, 115, 105, 20);
		this.panel.add(lastName);
		this.lastName.setColumns(10);
		
		//label firstName
		this.lbfirstName.setText("new firstName");
		this.lbfirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lbfirstName.setHorizontalAlignment(SwingConstants.LEFT);
		this.lbfirstName.setBounds(0, 31, 1000, 30);
		this.panel.add(lbfirstName);
		
		//textfield firstName				
		this.firstName.setBounds(356, 115, 105, 20);
		this.panel.add(firstName);
		this.firstName.setColumns(10);
		
		this.validate.addActionListener(this);
		this.panel.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		FacadeModifyAccount facade = new FacadeModifyAccount();
		
		String updateLogin = this.login.getText(); //le login modifié
		String updatefirstName = this.firstName.getText(); //le firstName modifié
		String updatelastName = this.lastName.getText(); //le lastName modifié
		int accountID = session.getID(); //l'id du compte à modifier
		
		try {
			facade.updateAccount(accountID, updateLogin, updatefirstName, updatelastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setChanged();
	}

}
