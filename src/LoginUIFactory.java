import javax.swing.JPanel;

import login.LoginUI;

/**
 * This factory create panel for the UI login.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class LoginUIFactory extends PanelFactory {

	@Override
	public JPanel build() {
		return new LoginUI();
	}

}
