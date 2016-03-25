package persistent;
import java.util.Iterator;

import common.Set;
import common.exception.InvalidPriceException;
import common.exception.InvalidQuantityException;

/**
 * @author loicd_000
 *
 */
public abstract class WishList extends Set<ProductWishList>{
	protected String label;
	protected int ID;
	
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
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
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
	
}
