package login;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField login = new JTextField();
	private JTextField password = new JTextField();
	private JButton connection = new JButton();
	
	private String token = null;
	
	public LoginUI() {
		this.login.setPreferredSize(new Dimension(150, 30));
		this.password.setPreferredSize(new Dimension(150, 30));
		this.connection.setPreferredSize(new Dimension(150, 30));
		this.connection.setText("Connect");
		
		this.add(login);
		this.add(password);
		this.add(connection);
		
		this.connection.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeAccount account = new FacadeAccount();
		try {
			this.token = account.login(this.login.getText(), this.password.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			this.token = null;
		}
	}
	
	public Boolean isConnected() {
		return this.token == null;
	}
}
