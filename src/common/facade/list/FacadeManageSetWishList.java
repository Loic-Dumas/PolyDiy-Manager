package common.facade.list;

import java.util.Set;

import common.exception.NoWishListException;
import logic.SetWishListHandler;
import persistent.list.SetWishList;
import persistent.list.WishList;

public class FacadeManageSetWishList {
	SetWishListHandler setWishListHandler = new SetWishListHandler();
	

	
	/***********************************************************************************************
	  SetWishListHandler
	***********************************************************************************************/


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
	
	
	

}
