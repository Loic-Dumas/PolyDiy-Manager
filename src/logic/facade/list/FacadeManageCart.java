package logic.facade.list;

import java.util.Set;

import logic.user.list.CartHandler;
import persistent.abstractclass.list.Cart;
import persistent.abstractclass.list.ProductWishList;

/**
 * This is the facade to manage all interactions with cart.
 * @author loicd_000
 *
 */
public class FacadeManageCart {
	CartHandler cartHandler = new CartHandler();
	
	
	/**
	 * This method create and return the cart with the IDUser in parameter. 
	 * If the instance has already a cart, return the cart.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDCart
	 */
	public Cart createAndGetCart(int IDUser) {
		return this.cartHandler.createAndGetCart(IDUser);
	}

	
	/**
	 * This method return a set of the keys contained in this cart
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this Cart
	 */
	public Set<String> getListIDCart() {
		return this.cartHandler.getListIDCart(); 
	}
	
	
	/**
	 * This method return the product (with ID) from the cart of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct
	 * @return The ProductWishList if the cart contain a ProductWishList with this ID. Or null.
	 */
	public ProductWishList getProductWithIDInCart(int IDProduct) {
		return this.cartHandler.getProductWithIDInCart(IDProduct);
	}
	
	
	/**
	 * This method add a product to the cart of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct, int quantity, float unitPrice
	 * @return true if the product is added to Cart. False if an error occur.
	 */
	public boolean addProductToCart(int IDProduct, int quantity, float unitPrice) {
		return this.cartHandler.addProductToCart(IDProduct, quantity, unitPrice);
	}

	
	/**
	 * This method remove the product of ID in parameter of the cart of the instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct - int
	 */
	public void removeProductToWishList(int IDProduct) {
		this.cartHandler.removeProductToWishList(IDProduct);
	}
	

	/**
	 * This method update the unitPrice of the product (with ID in parameter) of the cart of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct
	 * @param unitPrice
	 */
	public void updatePriceProductToCart( int IDProduct, float unitPrice) {
		this.cartHandler.updatePriceProductToCart(IDProduct, unitPrice);
	}
	

	/**
	 * This method update the quantity of the product (with ID in parameter) of the cart of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 */
	public void updateQuantityProductToCart( int IDProduct, int quantity) {
		this.cartHandler.updateQuantityProductToCart(IDProduct, quantity);
	}

	/**
	 * Return The name of the cart 
	 * 
	 * @author loicd_000
	 * @return The name of the wishList
	 */
	public String getNameCart() {
		return this.cartHandler.getNameCart();
	}

	
	/**
	 * Return the total price of the cart
	 * 
	 * @author loicd_000
	 * @return The total price of the wishList
	 */
	public float getTotalPriceCart() {
		return this.cartHandler.getTotalPriceCart();
	}
	
	
	/**
	 * This method add the order all item of the cart. And delete this item from the current WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct
	 */
	public void orderCart() {
		this.cartHandler.orderCart();
	}
	

}
