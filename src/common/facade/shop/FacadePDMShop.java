package common.facade.shop;

import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import logic.user.PDMShopHandler;
import persistent.Product;
import persistent.SetProduct;

public class FacadePDMShop {
	private PDMShopHandler pdmShopHandler = new PDMShopHandler();
	
	/**
	 * This method create and return a SetProduct
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public SetProduct createAndGetExistingSetProduct() {
		return this.pdmShopHandler.createAndGetExistingSetProduct();
	}
	

	/**
	 * This method return a set of the keys contained in this SetProduct
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return a set of the keys contained in this SetProduct
	 */
	public Set<String> getListID() {
		return this.pdmShopHandler.getListID(); 
	}
	

	/**
	 * This method return the product (with ID) from the SetProduct of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct - String
	 * @return The product (with ID) from the SetProduct of this instance of class. Or null.
	 */
	public Product getProductWithID(String IDProduct) {
		return this.pdmShopHandler.getProductWithID(IDProduct);
	}
	

	/**
	 * Return The name of the product 
	 * 
	 * @author loicd_000
	 * @param IDProduct - String
	 * @return The name of the product
	 */
	public String getNameProduct(String IDProduct) {
		return this.pdmShopHandler.getNameProduct(IDProduct);
	}
	
}
