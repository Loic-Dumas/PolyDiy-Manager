package logic.user;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import persistent.Product;

public class ProductInShopHandler {
	Product product = null;
	ProductFactory productFactory = new JDBCProductFactory();
	/**
	 * This method return a product
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public Product createAndGetProduct(int IDProduct) {
		if (this.product == null) { 
			try {
				try {
					this.product = productFactory.buildProduct(IDProduct);
				} catch (AlertDriver e) {
					e.printStackTrace();
				} catch (UnknownIDProductException e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the Product");
				e.printStackTrace();
			}
		}
		return this.product;
	}
	
	/**
	 * This method add the current product to the cart of thisUser
	 * 
	 * @param IDProduct
	 * @param unitPrice
	 * @param quantity
	 * @param IDUser
	 * @param IDWishList
	 */
	public void addToCart(int IDProduct, float unitPrice, int quantity, int IDUser) {
		
	}
	
	/**
	 * This method add the current product to the wishList of the User
	 * 
	 * @param IDProduct
	 * @param unitPrice
	 * @param quantity
	 * @param IDWishList
	 * @param IDWishList
	 */
	public void addToWishList(int IDProduct, float unitPrice, int quantity, int IDWishList) {
		
	}
	

}
