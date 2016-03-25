package graphic.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.facade.FacadeSession;
import graphic.engine.AbstractUI;

/**
 * This panel is the UI for the login.
 * Displays two textfields for the login and the password. 
 * And a button to valid
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class LoginUI extends AbstractUI{
	private JButton connection = new JButton();
	private JTextField login = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JLabel lblWelcome = new JLabel();
	
	private String token = null;
	
	public LoginUI() {
		this.panel.setLayout(null);
		// label welcome
		this.lblWelcome.setText("PolyDIY Manager");
		this.lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblWelcome.setBounds(0, 31, 1000, 30);
		this.panel.add(lblWelcome);
		
		// login
		//this.login.setPreferredSize(new Dimension(150,30));
		this.login.setBounds(356, 92, 105, 20);
		this.panel.add(login);
		this.login.setColumns(10);
		
		// password 
		//this.password.setPreferredSize(new Dimension(150,30));
		this.password.setBounds(531, 92, 105, 20);
		this.panel.add(password);
		
		// connection
		//this.connection.setPreferredSize(new Dimension(150,30));
		//this.connection.setText("Connect");
		this.connection.setText("Connect");
		this.connection.setBounds(450, 147, 89, 23);
		this.panel.add(connection);
		
		/*this.add(login);
		this.add(password);
		this.add(connection);
		*/
		this.connection.addActionListener(this);
		this.panel.setVisible(true);
	}
	
	/**
	 * The ActionPerformed execute the connection.
	 * And create the token.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeSession facade = new FacadeSession();
		try {
			this.token = facade.login(this.login.getText(), String.valueOf(this.password.getPassword()));
			this.setChanged();
			if(this.token != null) {
				//on appelle le update de l'observeur
				this.notifyObservers("login");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			this.token = null;
		}
	}
	
	public Boolean isConnected() {
		return this.token != null;
	}
	
	public String getToken() {
		return this.token;
	}
}
