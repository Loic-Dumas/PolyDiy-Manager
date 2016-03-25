package common.facade;

import common.exception.DifferentWishListException;
import common.exception.InvalidPriceException;
import common.exception.InvalidQuantityException;
import common.exception.NoWishListException;
import common.exception.UnknownIDProductException;
import logic.WishListHandler;
import persistent.ProductWishList;
import persistent.WishList;

/**
 * This is the facade to manage all interactions with lists.
 * @author loicd_000
 *
 */
public class FacadeManageList {
	WishListHandler wishListHandler = new WishListHandler();

	/**
	 * This method create and return the WishList with the ID in parameter. 
	 * If the instance has already a wish list, return the wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDWishList
	 * @return return the WishList. 
	 * @throws DifferentWishListException 
	 */
	public WishList createWishList(int IDWishList) throws DifferentWishListException{
		return this.wishListHandler.createWishList(IDWishList);
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
	public ProductWishList getProductWithIDInWishList(int IDProduct) 
			throws NoWishListException {
		return this.wishListHandler.getProductWithIDInWishList(IDProduct);
	}
	

	/**
	 * This method add a product to the WishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct, int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 * @throws UnknownIDProductException 
	 * @throws InvalidPriceException 
	 * @throws InvalidQuantityException 
	 * @throws NoWishListException 
	 */
	public boolean addProductToWishList(int IDProduct, int quantity, float unitPrice) 
			throws NoWishListException, InvalidQuantityException, InvalidPriceException, UnknownIDProductException  {
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
	 * @throws NoWishListException 
	 */
	public void removeProductToWishList(int IDProduct) throws NoWishListException {
		this.wishListHandler.removeProductToWishList(IDProduct);
	}
	

	/**
	 * This method update the unitPrice of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param  int IDProduct, float unitPrice
	 * @throws InvalidPriceException 
	 * @throws NoWishListException 
	 */
	public void updatePriceProductToWishList( int IDProduct, float unitPrice) 
			throws NoWishListException, InvalidPriceException {

		this.wishListHandler.updatePriceProductToWishList(IDProduct, unitPrice);
	}


	/**
	 * This method update the quantity of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 * @throws InvalidQuantityException 
	 * @throws NoWishListException 
	 */
	public void updateProductToWishList( int IDProduct, int quantity) 
			throws NoWishListException, InvalidQuantityException{
		this.wishListHandler.updateProductToWishList(IDProduct, quantity);
	}

	
	/**
	 * This method set the name of the WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param String newName
	 * @throws NoWishListException 
	 */
	public void renameWishList(String newName) throws NoWishListException{
		this.wishListHandler.renameWishList(newName);
	}
	
	// TODO Continue to implements all methods for this facade.
		

	

}
