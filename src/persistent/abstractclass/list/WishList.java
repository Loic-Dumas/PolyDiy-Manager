package persistent.abstractclass.list;

import java.util.Iterator;

import common.set.SetWithKey;
import persistent.abstractclass.InterfaceModel;

/**
 * this class is for a wishlist, extends from SetWithKey<ProductWishList>
 * to contains ProductWishist
 * @author loicd_000
 *
 */
public abstract class WishList extends SetWithKey<ProductWishList> implements InterfaceModel {
	protected String label;
	protected int IDWishList;
	protected int IDUser;

	public WishList(int IDWishList) {
		this.setID(IDWishList);
	}

	public WishList(int IDUser, String label) {
		this.setIDUser(IDUser);
		this.setLabel(label);
	}

	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getID() {
		return IDWishList;
	}

	public void setID(int iD) {
		IDWishList = iD;
	}

	/**
	 * @return - int : the number of products in the wishlist
	 */
	public int getNumberOfProductInWishList() {
		int count = 0;

		for (Iterator<String> i = this.getAllKeys().iterator(); i.hasNext();) {
			String key = i.next();
			count += this.getElementByKey(key).getQuantity();
		}

		return count;
	}

	/**
	 * @return - float : the total price of the wishList
	 */
	public float getTotalPriceWishList() {
		float totalPrice = 0;

		for (Iterator<String> i = this.getAllKeys().iterator(); i.hasNext();) {
			String key = i.next();
			totalPrice += this.getElementByKey(key).getUnitPrice() * this.getElementByKey(key).getQuantity();
		}

		return totalPrice;
	}
}
