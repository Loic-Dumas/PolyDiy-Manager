package persistent.abstractclass.list;

import common.set.SetWithKey;
import persistent.abstractclass.InterfaceModel;

/**
 * This Class extends from SetWithKey<WishList> 
 * and contains all the wishlist of an IDUser
 * @author loicd_000
 *
 */
public abstract class SetWishList extends SetWithKey<WishList> implements InterfaceModel {
	protected int IDUser;

	public SetWishList(int iDUser) { // may have some problems with IDUser vs IDWishlist
		super();
		this.IDUser = iDUser;
	}

	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}

}
