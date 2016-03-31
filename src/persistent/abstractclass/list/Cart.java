package persistent.abstractclass.list;

/**
 * This class is for a cart,
 * extends from WishList who extends from a set to contains all the item_wishlist
 * @author loicd_000
 *
 */
public abstract class Cart extends WishList{
	protected int IDUser; 

	public Cart(int IDWishList) { // posible que ce soit l'idUser des fois.
		super(IDWishList);
		this.IDUser = IDWishList;
	}

	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}

}
