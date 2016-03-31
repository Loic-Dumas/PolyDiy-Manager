package graphic.ui.account;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeCreateAccount;

public class CreateAccountUI extends AbstractUI {
	private JLabel image;
	private JLabel loginLabel = new JLabel("Login : ", JLabel.LEFT);
	private JTextField login = new JTextField(10);
	private JLabel passwordLabel = new JLabel("Password : ", JLabel.LEFT);
	private JPasswordField password = new JPasswordField();
	private JLabel emailLabel = new JLabel("Email : ", JLabel.LEFT);
	private JTextField email = new JTextField(10);
	private JLabel firstNameLabel = new JLabel("First name : ", JLabel.LEFT);
	private JTextField firstName = new JTextField(10);
	private JLabel lastNameLabel = new JLabel("Last name : ", JLabel.LEFT);
	private JTextField lastName = new JTextField(10);
	private JCheckBox userCheck = new JCheckBox("Activate profile User", true);
	private JCheckBox sellerCheck = new JCheckBox("Activate profile Seller");
	private JButton register = new JButton();
	
	public CreateAccountUI(UIMessage communication) {
		super(communication);
		
		this.panel.setLayout(null);
		
		this.image = new JLabel( new ImageIcon( "LogoFinal.PNG"));
		this.image.setBounds(100, 200, 250, 250);
		this.panel.add(image);
		
		this.loginLabel.setBounds(500, 200, 100, 20);
		this.panel.add(this.loginLabel);

		this.login.setBounds(610, 200, 150, 20);
		this.panel.add(this.login);

		this.passwordLabel.setBounds(500, 230, 100, 20);
		this.panel.add(this.passwordLabel);

		this.password.setBounds(610, 230, 150, 20);
		this.panel.add(this.password);
		
		this.emailLabel.setBounds(500, 260, 150, 20);
		this.panel.add(this.emailLabel);

		this.email.setBounds(610, 260, 150, 20);
		this.panel.add(this.email);

		this.firstNameLabel.setBounds(500, 290, 150, 20);
		this.panel.add(this.firstNameLabel);

		this.firstName.setBounds(610, 290, 150, 20);
		this.panel.add(this.firstName);

		this.lastNameLabel.setBounds(500, 320, 150, 20);
		this.panel.add(this.lastNameLabel);

		this.lastName.setBounds(610, 320, 150, 20);
		this.panel.add(this.lastName);

		this.userCheck.setBounds(500, 350, 150, 20);
		this.panel.add(this.userCheck);

		this.sellerCheck.setBounds(500, 380, 150, 20);
		this.panel.add(this.sellerCheck);

		this.register.setBounds(500, 410, 150, 20);
		this.register.setText("Sign on");
		this.panel.add(this.register);
		this.register.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FacadeCreateAccount facade = new FacadeCreateAccount();
		try {
			facade.createAccount(this.login.getText(), String.valueOf(this.password.getPassword()), 
										this.email.getText(), this.firstName.getText(), this.lastName.getText(), 
										this.userCheck.isSelected(), this.sellerCheck.isSelected());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
