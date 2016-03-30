package common.facade.shop;

import logic.user.ProductInShopHandler;
import persistent.Product;

public class FacadeProductInShop {
	ProductInShopHandler productHandler = new ProductInShopHandler();
	/**
	 * This method return a product
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public Product createAndGetProduct(int IDProduct) {
		return this.productHandler.createAndGetProduct(IDProduct);
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
