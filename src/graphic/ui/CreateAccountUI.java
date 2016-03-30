package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.facade.FacadeCreateAccount;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class CreateAccountUI extends AbstractUI {
	private JLabel loginLabel = new JLabel("Login : ", JLabel.CENTER);
	private JTextField login = new JTextField();
	private JLabel passwordLabel = new JLabel("Password : ", JLabel.CENTER);
	private JPasswordField password = new JPasswordField();
	private JLabel emailLabel = new JLabel("Email : ", JLabel.CENTER);
	private JTextField email = new JTextField();
	private JLabel firstNameLabel = new JLabel("First name : ", JLabel.CENTER);
	private JTextField firstName = new JTextField();
	private JLabel lastNameLabel = new JLabel("Last name : ", JLabel.CENTER);
	private JTextField lastName = new JTextField();
	private JButton register = new JButton();
	
	public CreateAccountUI(UIMessage communication) {
		super(communication);
		
		//this.panel.setLayout(new SpringLayout());
		
		//this.panel.setSize(600, 100);
		
		this.loginLabel.setBounds(0, 50, 150, 30);
		this.panel.add(this.loginLabel);
		this.login.setColumns(10);
		this.login.setBounds(160, 50, 150, 30);
		this.panel.add(this.login);

		this.passwordLabel.setBounds(0, 90, 150, 30);
		this.panel.add(this.passwordLabel);
		this.password.setColumns(10);
		this.login.setBounds(160, 120, 150, 120);
		this.panel.add(this.password);
		
		/*this.panel.add(this.emailLabel);
		this.email.setColumns(10);
		this.panel.add(this.email);
		
		this.panel.add(this.firstNameLabel);
		this.firstName.setColumns(10);
		this.panel.add(this.firstName);
		
		this.panel.add(this.lastNameLabel);
		this.lastName.setColumns(10);
		this.panel.add(this.lastName);
		
		this.register.setPreferredSize(new Dimension(150, 30));
		this.register.setText("Sign on");
		this.panel.add(this.register);
		this.register.addActionListener(this);*/
		
		this.panel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FacadeCreateAccount facade = new FacadeCreateAccount();
		try {
			facade.createAccount(this.login.getText(), String.valueOf(this.password.getPassword()), 
										this.email.getText(), this.firstName.getText(), this.lastName.getText());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
