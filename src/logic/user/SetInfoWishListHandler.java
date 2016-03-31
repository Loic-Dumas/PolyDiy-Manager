package logic.user;

import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ListFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import persistent.list.SetInfoWishList;

public class SetInfoWishListHandler {

	ListFactory listFactory = new JDBCListFactory();
	protected SetInfoWishList setWishList = null;
	

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
		if (this.setWishList == null) { // if there's no wishList
			try {
				try {
					this.setWishList = listFactory.buildSetInfoWishList(IDUser);
				} catch (AlertDriver e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the WishList");
				e.printStackTrace();
			}
		}

		return this.setWishList;
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
		if (this.setWishList == null) {
			System.err.println("No SetWishlist initialized.");
		} 
		return this.setWishList.getAllKeys() ; 
	}
	
	
	/**
	 * Return the ID of the wishList 
	 * 
	 * @author loicd_000
	 * @param IDWishList - String
	 * @return The id of the wishList
	 */
	public int getIDWishList(String IDWishList) {
		if (this.setWishList == null) {
			System.err.println("No SetInfoWishlist initialized.");
		} 
		return this.setWishList.getElementByKey(IDWishList).getIDWishList();
	}
	
	
	/**
	 * Return the ID of the wishList 
	 * 
	 * @author loicd_000
	 * @param IDWishList - String
	 * @return The id of the wishList
	 */
	public int getIDUser(String IDWishList) {
		if (this.setWishList == null) {
			System.err.println("No SetInfoWishlist initialized.");
		} 
		return this.setWishList.getElementByKey(IDWishList).getIDUser();
	}
	
}
