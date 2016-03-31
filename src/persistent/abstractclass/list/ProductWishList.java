package persistent.abstractclass.list;

import persistent.abstractclass.Product;

/**
 * This is a product for a list, like wish list.
 * This product have a price and his own quantity.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
public abstract class ProductWishList extends Product{
	protected int quantity;
	protected int IDWishList;

	public int getIDWishList() {
		return IDWishList;
	}

	public void setIDWishList(int iDWishList) {
		IDWishList = iDWishList;
	}

	public ProductWishList(int ID, int IDWishList) {
		super(ID);
		this.IDWishList = IDWishList;
	}

	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
