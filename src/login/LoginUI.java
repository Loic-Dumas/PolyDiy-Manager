package login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This panel is the UI for the login.
 * Displays two textfields for the login and the password. 
 * And a button to valid
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class LoginUI extends JPanel implements ActionListener{

	private JButton connection = new JButton();
	private JTextField login = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JLabel lblWelcome = new JLabel();
	
	private String token = null;
	
	public LoginUI() {
		this.setLayout(null);
		// label welcome
		this.lblWelcome.setText("PolyDIY Manager");
		this.lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblWelcome.setBounds(0, 31, 400, 30);
		this.add(lblWelcome);
		
		// login
		//this.login.setPreferredSize(new Dimension(150,30));
		this.login.setBounds(56, 92, 105, 20);
		this.add(login);
		this.login.setColumns(10);
		
		// password 
		//this.password.setPreferredSize(new Dimension(150,30));
		this.password.setBounds(231, 92, 105, 20);
		this.add(password);
		
		// connection
		//this.connection.setPreferredSize(new Dimension(150,30));
		//this.connection.setText("Connect");
		this.connection.setText("Connect");
		this.connection.setBounds(146, 147, 89, 23);
		this.add(connection);
		
		/*this.add(login);
		this.add(password);
		this.add(connection);
		*/
		this.connection.addActionListener(this);
		this.setVisible(true);
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
		FacadeAccount facade = new FacadeAccount();
		try {
			this.token = facade.login(this.login.getText(), this.password.getPassword().toString());
			//TODO Voir le getPassword. S'il y a un truc plus propore à faire.
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			this.token = null;
		}
	}
	
	public Boolean isConnected() {
		return this.token == null;
	}
}
