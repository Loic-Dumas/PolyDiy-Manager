package graphic.engine;

import graphic.ui.AccountUI;
import graphic.ui.AdminUI;
import graphic.ui.AdvertisementUI;
import graphic.ui.CreateAccountUI;
import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;
import graphic.ui.UpdateUI;
import graphic.ui.NavBarUI;
import graphic.ui.SellerUI;
import graphic.ui.UserUI;
import graphic.ui.list.CartUI;
import graphic.ui.list.WishListUI;
import graphic.ui.list.WishListsUI;
import graphic.ui.EditProfilUI;
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

	public AbstractUI buildEditProfilUI(Session session) {
		return new EditProfilUI(session);
	}
	public AbstractUI buildUpdateUI(Session session){
		
		return new UpdateUI(session);
	}
	
	public AbstractUI buildNavBarUI(Session session) {
		return new NavBarUI(session);
	}

	public AbstractUI buildAccountUI(Session session) {
		return new AccountUI(session);
	}

	public AbstractUI buildUserUI(Session session) {
		return new UserUI(session);
	}

	public AbstractUI buildSellerUI(Session session) {
		return new SellerUI(session);
	}

	public AbstractUI buildAdminUI(Session session) {
		return new AdminUI(session);
	}

	public AbstractUI buildWishListUI(Session session, int idWishList) {
		return new WishListUI(session, idWishList);
	}

	public AbstractUI buildWishListsUI(Session session, int idWishList) {
		return new WishListsUI(session, idWishList);
	}

	public AbstractUI buildCartUI(Session session, int i) {
		return new CartUI(session, i); 
	}
}
