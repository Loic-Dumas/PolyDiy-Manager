package persistent.list;

import common.InterfaceModel;
import common.SetWithKey;

public abstract class SetWishList extends SetWithKey<WishList> implements InterfaceModel {
	protected int IDUser;

	public SetWishList(int iDUser) {
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
