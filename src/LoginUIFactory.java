import javax.swing.JPanel;

import login.LoginUI;

public class LoginUIFactory implements PanelFactory {

	@Override
	public JPanel build() {
		return new LoginUI();
	}

}
