package persistent.abstractclass.list;

/**
 * This class contains only informations about the wishList.
 * She don't contains products.
 * 
 * @author loicd_000
 *
 */
public class WishListInfo {
	protected int IDWishList;
	protected int IDUser;
	protected String labelWishList;
	
	public WishListInfo(int IDWishList, int IDUser, String labelWishList) {
		super();
		this.IDWishList = IDWishList;
		this.IDUser = IDUser;
		this.labelWishList = labelWishList;
	}
	
	
	public int getIDWishList() {
		return IDWishList;
	}
	public void setIDWishList(int iDWishList) {
		IDWishList = iDWishList;
	}
	public int getIDUser() {
		return IDUser;
	}
	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}
	public String getLabelWishList() {
		return labelWishList;
	}
	public void setLabelWishList(String labelWishList) {
		this.labelWishList = labelWishList;
	}

}
