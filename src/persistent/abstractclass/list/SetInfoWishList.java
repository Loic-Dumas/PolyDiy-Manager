package persistent.abstractclass.list;

import common.set.SetWithKey;

/**
 * an aggregation of WishListInfo accessible by keys.
 * @author loicd_000
 *
 */
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
