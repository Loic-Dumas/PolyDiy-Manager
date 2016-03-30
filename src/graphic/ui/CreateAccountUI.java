package graphic.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.facade.FacadeCreateAccount;
import graphic.engine.AbstractUI;
import persistent.Session;

public class CreateAccountUI extends AbstractUI {
	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	JTextField email = new JTextField();
	JTextField firstName = new JTextField();
	JTextField lastName = new JTextField();
	JButton register = new JButton();
	
	public CreateAccountUI(Session session) {
		super();
		
		this.login.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.login);
		
		this.password.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.password);
		
		this.email.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.email);
		
		this.firstName.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.firstName);
		
		this.lastName.setPreferredSize(new Dimension(150, 30));
		this.panel.add(this.lastName);
		
		this.register.setPreferredSize(new Dimension(150, 30));
		this.register.setText("Sign on");
		this.panel.add(this.register);
		this.register.addActionListener(this);
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
