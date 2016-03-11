package graphic.engine;

import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;

public class FactoryUI {
	public AbstractUI buildLoginUI() {
		return new LoginUI();
	}
	
	public AbstractUI buildLogoutUI(String token) {
		return new LogoutUI(token);
	}
}
