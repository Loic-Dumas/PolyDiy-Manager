package common.facade.list;

import java.util.Set;

import common.exception.NoWishListException;
import logic.user.list.WishListHandler;
import persistent.list.ProductWishList;
import persistent.list.WishList;

/**
 * This is a facade to manage all interactions with a wish list.
 * @author loicd_000
 *
 */
public class FacadeManageWishList {
	WishListHandler wishListHandler = new WishListHandler();
	/**
	 * This method create and return the WishList with the ID in parameter. 
	 * If the instance has already a wish list, return the wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDWishList
	 * @return return the WishList. 
	 */
	public WishList createAndGetWishList(int IDWishList){
		return this.wishListHandler.createAndGetExistingWishList(IDWishList);
	}
	
	
	/**
	 * This method return a set of the keys contained in this WishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this WishList
	 */
	public Set<String> getListIDProduct() { 
		return this.wishListHandler.getListID() ; 
	}
	
	
	/**
	 * This method return the product (with ID) from the WishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct
	 * @return The ProductWishList if the WishList contain a ProductWishList with this ID. Or null.
	 * @throws NoWishListException 
	 */
	public ProductWishList getProductWithIDInWishList(int IDProduct) {
		return this.wishListHandler.getProductWithIDInWishList(IDProduct);
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
		return this.wishListHandler.addProductToWishList(IDProduct, quantity, unitPrice)
		;
	}

	
	/**
	 * This method remove the product of ID in parameter of the WishList of the instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct,
	 * @return void
	 */
	public void removeProductToWishList(int IDProduct) {
		this.wishListHandler.removeProductToWishList(IDProduct);
	}
	

	/**
	 * This method update the unitPrice of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param  int IDProduct, float unitPrice
	 */
	public void updatePriceProductToWishList( int IDProduct, float unitPrice) {
		this.wishListHandler.updatePriceProductToWishList(IDProduct, unitPrice);
	}


	/**
	 * This method update the quantity of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 */
	public void updateProductToWishList( int IDProduct, int quantity) {
		this.wishListHandler.updateQuantityProductToWishList(IDProduct, quantity);
	}

	
	/**
	 * This method set the name of the WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param String newName
	 */
	public void renameWishList(String newName) {
		this.wishListHandler.setNameWishList(newName);
	}
	

	/**
	 * Return The name of the wishList
	 * 
	 * @author loicd_000
	 * @return The name of the wishList
	 */
	public String getNameWishList()  {	
		return this.wishListHandler.getNameWishList();
	}
	

	/**
	 * Return The ID of the wishList
	 * 
	 * @author loicd_000
	 * @return The ID of the wishList
	 */
	public int getIDWishList()  {	
		return this.wishListHandler.getIDWishList();
	}

	
	/**
	 * Return the total price of the wishList
	 * 
	 * @author loicd_000
	 * @return The total price of the wishList
	 */
	public float getTotalPriceWishList() {
		return this.wishListHandler.getTotalPriceWishList();
	}
	
	

}
