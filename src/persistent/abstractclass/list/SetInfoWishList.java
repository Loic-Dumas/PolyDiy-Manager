package persistent.abstractclass.list;

import common.set.SetWithKey;

public class SetInfoWishList extends SetWithKey<WishListInfo> {
	protected int IDUser;

	public SetInfoWishList(int IDUser) {
		this.IDUser = IDUser;	}

	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int IDUser) {
		this.IDUser = IDUser;
	}
	

}
