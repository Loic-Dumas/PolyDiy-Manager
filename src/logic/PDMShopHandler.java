package logic;

import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import persistent.Product;
import persistent.SetProduct;

public class PDMShopHandler {
	protected SetProduct setProduct = null;
	ListFactory listFactory = new JDBCListFactory();

	

	/**
	 * This method create and return a SetProduct
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public SetProduct createAndGetExistingWishList() {
		if (this.setProduct == null) { // if there's no wishList
			try {
				try {
					this.setProduct = listFactory.buildSetProduct();
				} catch (AlertDriver e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the setProduct");
				e.printStackTrace();
			}
		}

		return this.setProduct;
	}
	

	/**
	 * This method return a set of the keys contained in this SetProduct
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return a set of the keys contained in this SetProduct
	 */
	public Set<String> getListID() {
		if (this.setProduct== null) {
			System.err.println("No setProduct initialized.");
		} 
		return this.setProduct.getAllKeys() ; 
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
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		return this.setProduct.getElementByKey(IDProduct);
	}
	

	
	
	/**
	 * Return The name of the product 
	 * 
	 * @author loicd_000
	 * @param IDProduct - String
	 * @return The name of the product
	 */
	public String getNameProduct(String IDProduct) {
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		return this.setProduct.getElementByKey(IDProduct).getName();
	}
	
}
