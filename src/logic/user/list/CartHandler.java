package logic.user.list;

import java.util.Iterator;
import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.NoCartException;
import common.exception.UnknownIDProductException;
import persistent.abstractclass.list.Cart;
import persistent.abstractclass.list.ProductWishList;
import persistent.factory.ListFactory;
import persistent.factory.ProductFactory;
import persistent.factory.jdbcFactory.JDBCListFactory;
import persistent.factory.jdbcFactory.JDBCProductFactory;

public class CartHandler {
	ListFactory listFactory = new JDBCListFactory();
	ProductFactory productFactory = new JDBCProductFactory();
	Cart cart = null;
	
	/**
	 * This method create and return the cart with the IDUser in parameter. 
	 * If the instance has already a cart, return the cart.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDCart
	 */
	public Cart createAndGetCart(int IDUser) {
		if (this.cart == null) { // if there's no cart
			try {
				try {
					this.cart = listFactory.buildCart(IDUser);
				} catch (AlertDriver e) {
					e.printStackTrace();
				} catch (NoCartException e) {
					
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the cart.");
				e.printStackTrace();
			}
		}

		return this.cart;
	}

	
	/**
	 * This method return a set of the keys contained in this cart
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this Cart
	 */
	public Set<String> getListIDCart() {
		if (this.cart == null) {
			System.err.println("No wishlist initialized.");
		} 
		return this.cart.getAllKeys() ; 
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
		if (this.cart == null) {
			System.err.println("No wishlist initialized.");
		}
		return this.cart.getElementByKey(String.valueOf(IDProduct));
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
		Boolean result = false;
		
		if (this.cart == null) {
			System.err.println("No cart initialized.");
		}
		try {
			if (quantity <= 0) {
				System.err.println("Error : The quantity should be > 0.");
			} else if (unitPrice < 0 ) {
				System.err.println("Error : The price should be >= 0.");
			}
			
			try {
				this.cart.addElement(String.valueOf(IDProduct), 
						this.productFactory.buildProductWishList(IDProduct, this.cart.getID(),  quantity, unitPrice));
				result = true;
			} catch (AlertDriver e1) {
				e1.printStackTrace();
			}
			
			try {
				this.cart.update();
			} catch (Exception e) {
				// TODO gerer les exceptions de cet update
				e.printStackTrace();
			}
			
			return true ;
		} catch (UnknownIDProductException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (ErrorConnectionException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	/**
	 * This method remove the product of ID in parameter of the cart of the instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct - int
	 */
	public void removeProductToWishList(int IDProduct) {
		if (this.cart == null) {
			System.err.println("No wishlist initialized.");
		}
		String stringIDProduct = String.valueOf(IDProduct);
		
		//first we remove the product in the persistent layer.
		try {
			this.cart.getElementByKey(stringIDProduct).delete();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
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
		if (this.cart == null) {
			System.err.println("No cart initialized.");
		}

		this.cart.getElementByKey(String.valueOf(IDProduct)).setUnitPrice(unitPrice);
		
		try {
			this.cart.getElementByKey(String.valueOf(IDProduct)).update();
		} catch (Exception e) {
			// TODO gerer cette exception en détail.
			e.printStackTrace();
		}
	}
	

	/**
	 * This method update the quantity of the product (with ID in parameter) of the cart of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 */
	public void updateQuantityProductToCart( int IDProduct, int quantity) {
		if (this.cart == null) {
			System.err.println("No cart initialized.");
		}

		this.cart.getElementByKey(String.valueOf(IDProduct)).setQuantity(quantity);
		
		
		try {
			this.cart.getElementByKey(String.valueOf(IDProduct)).update();
		} catch (Exception e) {
			// TODO gerer cette exception en détail.
			e.printStackTrace();
		}
	}

	/**
	 * Return The name of the cart 
	 * 
	 * @author loicd_000
	 * @return The name of the wishList
	 */
	public String getNameCart() {
		return "Cart";
	}

	
	/**
	 * Return the total price of the cart
	 * 
	 * @author loicd_000
	 * @return The total price of the wishList
	 */
	public float getTotalPriceCart() {
		if (this.cart == null) {
			System.err.println("No cart initialized.");
		}
		float totalPrice = 0;
		
		for(Iterator<String> i = this.cart.getAllKeys().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    totalPrice += this.cart.getElementByKey(key).getUnitPrice() * this.cart.getElementByKey(key).getQuantity() ;
		}
		
		return totalPrice;
	}
	
	
	/**
	 * This method add the order all item of the cart. And delete this item from the current WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 */
	public void orderCart() {
		if (this.cart == null) {
			System.err.println("Impossible to order an empty Cart.");
		}
		
		// TODO WishListHandler Implement orderCart.
	}
	

}
