package login;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.FacadeAccount;

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
	private static final long serialVersionUID = 1L;

	private JButton connection = new JButton();
	private JTextField login = new JTextField();
	private JTextField password = new JTextField();
	
	private String token = null;
	
	public LoginUI() {
		this.login.setPreferredSize(new Dimension(150,30));
		this.password.setPreferredSize(new Dimension(150,30));
		this.connection.setPreferredSize(new Dimension(150,30));
		this.connection.setText("Connect");
		
		this.add(login);
		this.add(password);
		this.add(connection);
		
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
			this.token = facade.login(this.login.getText(), this.password.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			this.token = null;
		}
	}
	
	public Boolean isConnected() {
		return this.token == null;
	}
}
