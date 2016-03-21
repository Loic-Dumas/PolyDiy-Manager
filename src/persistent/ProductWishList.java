package persistent;
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

	public ProductWishList(int ID) {
		super(ID);
	}

	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
