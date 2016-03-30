package graphic.engine;

import graphic.ui.AdvertisementUI;
import graphic.ui.CreateAccountUI;
import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;
import graphic.ui.ModifyIdentityUI_test;
import graphic.ui.ModifyIdentityUI_welcome;
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

	public AbstractUI buildModifyIdentityUI(Session session) throws Exception {
		return new ModifyIdentityUI_test(session);
	}
	
	public AbstractUI buildModifyIdentityUI_welcome(Session session) throws Exception {
		return new ModifyIdentityUI_welcome(session);
	}
}
