package persistent.abstractclass.list;

import common.set.SetWithKey;
import persistent.abstractclass.InterfaceModel;

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
