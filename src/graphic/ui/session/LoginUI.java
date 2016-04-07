package graphic.ui.session;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeSession;
import persistent.abstractclass.Session;

/**
 * This panel is the UI for the login. Displays two textfields for the login and
 * the password. And a button to valid
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class LoginUI extends AbstractUI {
	private JButton connection = new JButton();
	private JLabel loginLabel = new JLabel("Login :");
	private JTextField login = new JTextField();
	private JLabel passwordLabel = new JLabel("Password :");
	private JPasswordField password = new JPasswordField();
	private JLabel lblWelcome = new JLabel();
	private KeyListener keyListener;

	private Session session = null;

	public LoginUI(UIMessage communication) {
		super(communication);

		// label welcome
		this.lblWelcome.setText("PolyDIY Manager");
		this.lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		this.panel.add(lblWelcome);

		this.panel.add(loginLabel);

		this.panel.add(login);
		this.login.setColumns(10);

		this.panel.add(passwordLabel);

		this.panel.add(password);
		this.password.setColumns(10);

		this.connection.setText("Connect");
		this.panel.add(connection);

		this.connection.addActionListener(this);
		this.panel.setVisible(true);

		// add the key listener
		this.keyListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					tryConnect();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		};

		this.password.addKeyListener(keyListener);
		this.login.addKeyListener(keyListener);

	}
	
	/**
	 * The ActionPerformed execute the connection. And create the token.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Connect")) {
			this.tryConnect();
		}
	}

	public Boolean isConnected() {
		return this.session != null;
	}

	/**
	 * this method try to log the user with the login and the account
	 * If it's possible (login and password match) log the user, create a session 
	 * and a communication element (used to communicate between the UI)
	 * else display an error in a dialog box 
	 */
	private void tryConnect() {
		FacadeSession facade = new FacadeSession();
		try {
			this.session = facade.login(this.login.getText(), String.valueOf(this.password.getPassword()));
			if (this.session != null) {
				this.communication.shareElement("id_account", this.session.getID());
				this.communication.shareElement("login", this.session.getLogin());
				if (this.session.getIDUser() != -1) {
					this.communication.shareElement("id_user", this.session.getIDUser());
				}
				if (this.session.getIDSeller() != -1) {
					this.communication.shareElement("id_seller", this.session.getIDSeller());
				}
				if (this.session.getIDAdmin() != -1) {
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
