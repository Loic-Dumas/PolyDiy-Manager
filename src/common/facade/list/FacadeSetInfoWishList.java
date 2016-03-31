package common.facade.list;

import java.util.Set;

import logic.user.list.SetInfoWishListHandler;
import persistent.list.SetInfoWishList;

public class FacadeSetInfoWishList {
	private SetInfoWishListHandler setInfoWishListHandler = new SetInfoWishListHandler();

	/**
	 * This method create and return the SetInfoWishList with the IDUser in parameter. 
	 * If the instance has already a set info wish list, return this existing infowishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDUser - int
	 * @return SetWishList
	 */
	public SetInfoWishList createAndGetExistingWishList(int IDUser) {
		return this.setInfoWishListHandler.createAndGetExistingWishList(IDUser);
	}
	
	

	/**
	 * This method return a set of the keys contained in this SetInfoWishList
	 * Corresponding to the name of each wishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this InfoSetWishList
	 */
	public Set<String> getListID() {
		return this.setInfoWishListHandler.getListID() ; 
	}
	
	
	/**
	 * Return the ID of the wishList 
	 * 
	 * @author loicd_000
	 * @param labelWishList - String
	 * @return The id of the wishList
	 */
	public int getIDWishList(String labelWishList) {
		return this.setInfoWishListHandler.getIDWishList(labelWishList);
	}
	
	
	/**
	 * Return the ID of the wishList 
	 * 
	 * @author loicd_000
	 * @param labelWishList - String
	 * @return The id of the wishList
	 */
	public int getIDUser(String labelWishList) {
		return this.setInfoWishListHandler.getIDUser(labelWishList);
	}
	
}
