package persistent.abstractclass;

import common.set.SetWithKey;

/**
 * this is an aggregate of products. 
 * This class can be used without IDSeller, so IDSeller initialize to -1
 * and return all of products. 
 * Else, return only the products of the IDUser in parameter
 * @author loicd_000
 *
 */
public abstract class SetProduct extends SetWithKey<Product> implements InterfaceModel {
	private int IDSeller;

	public SetProduct(int IDSeller) {
		super();
		this.IDSeller = IDSeller;
	}

	public SetProduct() {
		this(-1); 
	}

	public int getIDSeller() {
		return IDSeller;
	}

	public void setIDSeller(int iDSeller) {
		IDSeller = iDSeller;
	}

	
}
