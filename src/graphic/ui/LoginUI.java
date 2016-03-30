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
import graphic.engine.UIMessage;
import persistent.Session;

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
	
	private Session session = null;
	
	public LoginUI(UIMessage communication) {
		super(communication);
		this.panel.setLayout(null);
		// label welcome
		this.lblWelcome.setText("PolyDIY Manager");
		this.lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblWelcome.setBounds(0, 31, 400, 30);
		this.panel.add(lblWelcome);
		
		this.login.setBounds(56, 92, 105, 20);
		this.panel.add(login);
		this.login.setColumns(10);
		
		this.password.setBounds(231, 92, 105, 20);
		this.panel.add(password);
		
		this.connection.setText("Connect");
		this.connection.setBounds(146, 147, 89, 23);
		this.panel.add(connection);
		
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
		if(arg0.getActionCommand().equals("Connect")) {
			FacadeSession facade = new FacadeSession();
			try {
				this.session = facade.login(this.login.getText(), String.valueOf(this.password.getPassword()));
				if(this.session != null) {
					this.communication.shareElement("id_account", this.session.getID());
					if(this.session.getIDUser() != -1) {
						this.communication.shareElement("id_user", this.session.getIDUser());
					}
					if(this.session.getIDSeller() != -1) {
						this.communication.shareElement("id_seller", this.session.getIDSeller());
					}
					if(this.session.getIDAdmin() != -1) {
						this.communication.shareElement("id_admin", this.session.getIDAdmin());
					}
					this.setChanged();
					this.notifyObservers("login");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				this.session = null;
			}
		}
	}
	
	public Boolean isConnected() {
		return this.session != null;
	}
	
	/*public Session getSession() {
		return this.session;
	}*/
}
