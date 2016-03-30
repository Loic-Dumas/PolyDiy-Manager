package common.facade.list;

import java.util.Set;

import common.exception.NoWishListException;
import common.exception.wishListAlreadyExistException;
import logic.user.SetWishListHandler;
import persistent.list.SetWishList;
import persistent.list.WishList;

public class FacadeManageSetWishList {
	SetWishListHandler setWishListHandler = new SetWishListHandler();
	

	/**
	 * This method create and return the SetWishList with the IDUser in parameter. 
	 * If the instance has already a set wish list, return this existing wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDUser - int
	 * @return SetWishList
	 */
	public SetWishList createAndGetSetWishList(int IDUser) {
		return this.setWishListHandler.createAndGetExistingWishList(IDUser);
	}
	
	/**
	 * 
	 * 
	 * @author loicd_000
	 * @param IDUser
	 * @param label
	 * @throws wishListAlreadyExistException 
	 */
	public void  createWishList(int IDUser, String label) throws wishListAlreadyExistException {
		this.setWishListHandler.createWishList(IDUser, label);
	}
	

	/**
	 * This method return a set of the keys contained in this SetWishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this SetWishList
	 */
	public Set<String> getListIDWishList() {
		return this.setWishListHandler.getListID() ; 
	}
	

	/**
	 * This method return the wishList (with ID) from the SetWishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDWishList - String
	 * @return The wishList (with ID) from the SetWishList of this instance of class. Or null.
	 */
	public WishList getWishListWithIDInSetWishList(String IDWishList) {
		return this.setWishListHandler.getWishListWithIDInSetWishList(IDWishList);
	}
	
	//public boolean addProductToWishList(int IDProduct, int quantity, float unitPrice)  (addWishList)
	//update name
	
	/**
	 * Return The name of the wishList 
	 * 
	 * @author loicd_000
	 * @param IDWishList - String
	 * @return The name of the wishList
	 * @throws NoWishListException 
	 */
	public String getNameWishList(String IDWishList) {
		return this.setWishListHandler.getNameWishList(IDWishList);
	}

	/**
	 * Delete all elements of the IDwishlist in parameter
	 * @param iDWishList - the wishliste to delete
	 * @throws Exception 
	 */
	public void deleteWishList(int iDWishList) throws Exception {
		this.setWishListHandler.deleteWishList(iDWishList);
	}
	
	
	/**
	 * the number of products in the wishlist
	 * @param IDWishList
	 * @return the number of products in the wishlist
	 */
	public int getNumberOfProductsInWishList(int IDWishList) {
		return this.setWishListHandler.getNumberOfProductsInWishList(IDWishList);
	}
	
	

}
