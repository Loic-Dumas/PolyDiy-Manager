package graphic.engine;

import graphic.ui.AdvertisementUI;
import graphic.ui.CreateAccountUI;
import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;
import graphic.ui.ModifyIdentityUI_test;
import persistent.Session;

public class FactoryUI {

	public AbstractUI buildLoginUI() {
		return new LoginUI();
	}
	
	public AbstractUI buildLogoutUI(Session session) {
		return new LogoutUI(session);
	}
	
	public AbstractUI buildAdvertisementUI() {
		return new AdvertisementUI();
	}
	
	public AbstractUI buildCreateAccountUI() {
		return new CreateAccountUI();
	}
}
