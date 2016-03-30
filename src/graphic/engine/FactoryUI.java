package graphic.engine;

import java.util.HashMap;
import java.util.Map;

import graphic.ui.AdvertisementUI;
import graphic.ui.CreateAccountUI;
import graphic.ui.LoginUI;
import graphic.ui.LogoutUI;
import graphic.ui.NavBarUI;
import graphic.ui.account.AccountUI;
import graphic.ui.admin.AdminUI;
import graphic.ui.seller.SellerUI;
import graphic.ui.user.UserUI;
import graphic.ui.user.list.CartUI;
import graphic.ui.user.list.WishListUI;
import graphic.ui.user.list.WishListsUI;
import persistent.Session;

public class FactoryUI {
	@SuppressWarnings("rawtypes")
	Map<String, Class> ui = new HashMap<String, Class>();
	
	public FactoryUI() {
		this.ui.put("login", LoginUI.class);
		this.ui.put("logout", LogoutUI.class);
		this.ui.put("advertisement", AdvertisementUI.class);
		this.ui.put("createAccount", CreateAccountUI.class);
		this.ui.put("navBar", NavBarUI.class);
		this.ui.put("account", AccountUI.class);
		this.ui.put("user", UserUI.class);
		this.ui.put("seller", SellerUI.class);
		this.ui.put("admin", AdminUI.class);
		this.ui.put("wishlist", WishListUI.class);
		this.ui.put("wishlists", WishListsUI.class);
		this.ui.put("cart", CartUI.class);
	}
	
	@SuppressWarnings("unchecked")
	public AbstractUI build(String name, Session session) {
		try {
			if(this.ui.containsKey(name)) {
				return (AbstractUI)this.ui.get(name).getConstructor(Session.class).newInstance(session);
			} else {
				throw new Exception("Unknow ui " + name + " !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*public AbstractUI buildLoginUI() {
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
	}*/
}
