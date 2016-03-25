package graphic.ui;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.facade.FacadeModifyAccount;
import common.facade.FacadeSession;
import graphic.engine.AbstractUI;

public class ModifyIdentityUI_test extends AbstractUI{
	
	//on déclare les textfields et bouttons
	private JTextField login;
	private JTextField lastName;
	private JTextField firstName;
	private String token = null;
	private JButton btReturn = new JButton();
	private JButton btValidate = new JButton();


	/**
	 * Create the panel.
	 */
	public ModifyIdentityUI_test(String token) {
		FacadeModifyAccount facade = new FacadeModifyAccount();
		String textLogin = facade.getLogin(accountID);
		
		
		this.token = token;
		this.panel.setLayout(null);
		//modify the background colors
		this.panel.setForeground(UIManager.getColor("Tree.selectionBorderColor"));
		this.panel.setBackground(UIManager.getColor("controlHighlight"));
		
		//le label et textfield pour login
		JLabel lblogin = new JLabel("Your loggin");
		login = new JTextField();
		login.setColumns(10);
		
		// le label et textfield pour le lastName
		JLabel lblastName = new JLabel("Your last name");
		lastName = new JTextField();
		lastName.setColumns(10);
		
		// le label et textfield pour le firstName
		JLabel lbfirstName = new JLabel("Your first name");	
		firstName = new JTextField();
		firstName.setColumns(10);
		
		//les boutons return et validate
		JButton btReturn = new JButton("Return");
		JButton btValidate = new JButton("Validate");
		
		//informations we have in the DB
		JLabel dblastName =new JLabel ("YourlastName");
		JLabel dbfirstName =new JLabel ("YourfirstName");
		JLabel dblogin =new JLabel ("Yourlogin");
				
		//on créé le groupLayout
		GroupLayout groupLayout = new GroupLayout(this.panel);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		//le groupe Horizontal
		groupLayout.setHorizontalGroup(
				groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblogin)
							.addComponent(lblastName)
							.addComponent(lbfirstName)
							.addComponent(btReturn))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(login)
							.addComponent(lastName)
							.addComponent(firstName)
							.addComponent(btValidate))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(dblogin)
							.addComponent(dblastName)
							.addComponent(dbfirstName))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblogin)
							.addComponent(login)
							.addComponent(dblogin)
					)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblastName)
							.addComponent(lastName)
							.addComponent(dblastName)
					)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbfirstName)
							.addComponent(firstName)
							.addComponent(dbfirstName)
					)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btReturn)
							.addComponent(btValidate)
					)
		);
		this.panel.setLayout(groupLayout);
		this.btReturn.addActionListener(this);
		this.btValidate.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeModifyAccount facade = new FacadeModifyAccount();
		//int accountID = session.getID(); l'id du compte à modifier		
		try {
			if(arg0.getSource() == btValidate){
				//A MODIFIER 
				int accountID=1; 
				facade.updateAccount(accountID, this.login.getText(), this.firstName.getText(), this.lastName.getText());
				this.setChanged();
				this.notifyObservers("Validate");
			}
			if(arg0.getSource() == btReturn){
				
				this.setChanged();
				this.notifyObservers("btReturn");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		//this.setChanged();
	}
}
