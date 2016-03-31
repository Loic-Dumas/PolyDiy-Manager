package persistent.abstractclass;

import common.set.SetWithKey;

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
