package logic;

import java.util.Iterator;
import java.util.Set;

import common.exception.AlertDriver;
import common.exception.DifferentWishListException;
import common.exception.ErrorConnectionException;
import common.exception.InvalidPriceException;
import common.exception.InvalidQuantityException;
import common.exception.NoWishListException;
import common.exception.UnknownIDProductException;
import common.factory.ListFactory;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import persistent.list.ProductWishList;
import persistent.list.WishList;

/**
 * To handle user interactions with a wish list.
 * @author loicd_000
 * @since 2016-03-21
 */
public class WishListHandler {
	ListFactory listFactory = new JDBCListFactory();
	ProductFactory productFactory = new JDBCProductFactory();
	WishList wishList = null;
	
	/**
	 * This method create and return the WishList with the ID in parameter. 
	 * If the instance has already a wish list, return the wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDWishList
	 */
	public WishList createAndGetExistingWishList(int IDWishList) {
		if (this.wishList == null) { // if there's no wishList
			try {
				try {
					this.wishList = listFactory.buildWishList(IDWishList);
				} catch (AlertDriver e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the WishList");
				e.printStackTrace();
			}
		}

		return this.wishList;
	}

	
	/**
	 * This method return a set of the keys contained in this WishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this WishList
	 */
	public Set<String> getListID() {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		} 
		return this.wishList.getAllKeys() ; 
	}
	
	
	/**
	 * This method return the product (with ID) from the WishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct
	 * @return The ProductWishList if the WishList contain a ProductWishList with this ID. Or null.
	 */
	public ProductWishList getProductWithIDInWishList(int IDProduct) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		return this.wishList.getElementByKey(String.valueOf(IDProduct));
	}
	
	
	/**
	 * This method add a product to the WishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct, int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 */
	public boolean addProductToWishList(int IDProduct, int quantity, float unitPrice) {
		Boolean result = false;
		
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		try {
			if (quantity <= 0) {
				System.err.println("Error : The quantity should be > 0.");
			} else if (unitPrice < 0 ) {
				System.err.println("Error : The price should be >= 0.");
			}
			
			try {
				this.wishList.addElement(String.valueOf(IDProduct), 
						this.productFactory.buildProductWishList(IDProduct, this.wishList.getID(),  quantity, unitPrice));
				result = true;
			} catch (AlertDriver e1) {
				e1.printStackTrace();
			}
			
			try {
				this.wishList.update();
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
	 * This method remove the product of ID in parameter of the WishList of the instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct - int
	 */
	public void removeProductToWishList(int IDProduct) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		String stringIDProduct = String.valueOf(IDProduct);
		
		//first we remove the product in the persistent layer.
		try {
			this.wishList.getElementByKey(stringIDProduct).delete();
		} catch (Exception e1) {
			// TODO gerer les exceptions de ce remove
			e1.printStackTrace();
		}
		
		this.wishList.removeElementByKey(stringIDProduct);
		
		//now we update the wishList
		try {
			this.wishList.update();
		} catch (Exception e) {
			// TODO gerer les exceptions de ce remove
			e.printStackTrace();
		}
	}
	

	/**
	 * This method update the unitPrice of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDProduct
	 * @param unitPrice
	 * @return void
	 */
	public void updatePriceProductToWishList( int IDProduct, float unitPrice) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}

		this.wishList.getElementByKey(String.valueOf(IDProduct)).setUnitPrice(unitPrice);
		
		try {
			this.wishList.getElementByKey(String.valueOf(IDProduct)).update();
		} catch (Exception e) {
			// TODO gerer cette exception en détail.
			e.printStackTrace();
		}
	}
	

	/**
	 * This method update the quantity of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 * @return void
	 */
	public void updateQuantityProductToWishList( int IDProduct, int quantity) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}

		this.wishList.getElementByKey(String.valueOf(IDProduct)).setQuantity(quantity);
		
		
		try {
			this.wishList.getElementByKey(String.valueOf(IDProduct)).update();
		} catch (Exception e) {
			// TODO gerer cette exception en détail.
			e.printStackTrace();
		}
	}
	

	/**
	 * This method set the name of the WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param String newName
	 * @return void
	 * @throws NoWishListException 
	 */
	public void setNameWishList(String newName) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		
		this.wishList.setLabel(newName);
		try {
			this.wishList.update();
		} catch (Exception e) {
			// TODO gerer cette exception en detail.
			e.printStackTrace();
		}
	}
	

	/**
	 * Return The name of the wishList
	 * 
	 * @author loicd_000
	 * @return The name of the wishList
	 * @throws NoWishListException 
	 */
	public String getNameWishList() {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		return this.wishList.getLabel();
	}

	
	/**
	 * Return the total price of the wishList
	 * 
	 * @author loicd_000
	 * @return The total price of the wishList
	 */
	public float getTotalPriceWishList() {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		float totalPrice = 0;
		
		for(Iterator<String> i = this.wishList.getAllKeys().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    totalPrice += this.wishList.getElementByKey(key).getUnitPrice() * this.wishList.getElementByKey(key).getQuantity() ;
		}
		
		return totalPrice;
	}
	
	
	/**
	 * This method add the item to the cart. And delete this item from the current WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct
	 * @return void
	 */
	public void addProductToCart(int IdProduct) {
		if (this.wishList == null) {
			System.err.println("No wishlist initialized.");
		}
		
		// TODO WishListHandler Implement addProductToCart.
	}
	

	/**
	 * This method add all products of the wishList in parameter to the cart.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param IDWishList
	 */
	public void addProductAllProducrsToCart(int IDWishList) {
		
		// TODO WishListHandler Implement addProductAllProducrsToCart
	}
	
}
