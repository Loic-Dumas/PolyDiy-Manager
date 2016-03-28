package persistent.list;
import common.InterfaceModel;
import common.SetWithKey;

/**
 * @author loicd_000
 *
 */
public abstract class WishList extends SetWithKey<ProductWishList> implements InterfaceModel {
	protected String label;
	protected int IDWishList;
	
	public WishList(int ID){
		this.setID(ID);
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
	
	/*
	Different methods when WishList where extending from Set
	 
	public ProductWishList getProductWithIDProduct(int IDProduct) {
		Iterator<ProductWishList> iterator = this.set.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			if (iterator.next().getID() == IDProduct) {
				return iterator.next();
			}
		}
		
		return null;
	}
	
	public void removeProductWithIDProduct(int IDProduct) {
		Iterator<ProductWishList> iterator = this.set.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			if (iterator.next().getID() == IDProduct) {
				iterator.remove();
				found = true;
			}
		}
	}

	public void updateNewUnitPriceProductWithIDProduct(int IDProduct, float newPrice) throws InvalidPriceException {
		if (newPrice < 0 ) {
			throw new InvalidPriceException(newPrice);
		} 
		
		Iterator<ProductWishList> iterator = this.set.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			if (iterator.next().getID() == IDProduct) {
				iterator.next().setUnitPrice(newPrice);
				found = true;
			}
		}
	}
	
	public void updateNewQuantityProductWithIDProduct(int IDProduct, int quantity) throws InvalidQuantityException {
		if (quantity <=0 ) {
			throw new InvalidQuantityException(quantity);
		} 
		
		Iterator<ProductWishList> iterator = this.set.iterator();
		boolean found = false;
		while (!found && iterator.hasNext()) {
			if (iterator.next().getID() == IDProduct) {
				iterator.next().setUnitPrice(quantity);
				found = true;
			}
		}
	}
	*/
}
