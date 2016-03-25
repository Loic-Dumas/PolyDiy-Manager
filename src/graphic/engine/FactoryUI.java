package graphic.engine;

import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;
import graphic.ui.ModifyIdentityUI_test;

public class FactoryUI {
	
	public AbstractUI buildLoginUI() {
		return new LoginUI();
	}
	public AbstractUI buildLogoutUI(String token) {
		return new LogoutUI(token);
	}
	public AbstractUI buildModifyIdentityUI(String token) {
		return new ModifyIdentityUI_test(token);
	}
}
