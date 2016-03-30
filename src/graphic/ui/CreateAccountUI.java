package graphic.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.facade.FacadeCreateAccount;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class CreateAccountUI extends AbstractUI {
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
		
		this.panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0;
		constraints.weighty = 0;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.loginLabel.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.loginLabel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.panel.add(this.login, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.passwordLabel.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.passwordLabel, constraints);

		constraints.gridx = 1;
		constraints.gridy = 1;
		this.panel.add(this.password, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.emailLabel.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.emailLabel, constraints);

		constraints.gridx = 1;
		constraints.gridy = 2;
		this.panel.add(this.email, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		this.firstNameLabel.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.firstNameLabel, constraints);

		constraints.gridx = 1;
		constraints.gridy = 3;
		this.panel.add(this.firstName, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		this.lastNameLabel.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.lastNameLabel, constraints);

		constraints.gridx = 1;
		constraints.gridy = 4;
		this.panel.add(this.lastName, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 5;
		this.panel.add(this.userCheck, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 6;
		this.panel.add(this.sellerCheck, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 7;
		this.register.setPreferredSize(new Dimension(150, 30));
		this.register.setText("Sign on");
		this.panel.add(this.register, constraints);
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
