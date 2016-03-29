package logic;

import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.NoWishListException;
import common.factory.ListFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import persistent.list.SetWishList;
import persistent.list.WishList;

public class SetWishListHandler {
	ListFactory listFactory = new JDBCListFactory();
	protected SetWishList setWishList = null;
	

	/**
	 * This method create and return the SetWishList with the IDUser in parameter. 
	 * If the instance has already a set wish list, return this existing wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDUser - int
	 * @return SetWishList
	 */
	public SetWishList createAndGetExistingWishList(int IDUser) {
		if (this.setWishList == null) { // if there's no wishList
			try {
				try {
					this.setWishList = listFactory.buildSetWishList(IDUser);
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
	 * This method return a set of the keys contained in this SetWishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this SetWishList
	 */
	public Set<String> getListID() {
		if (this.setWishList == null) {
			System.err.println("No SetWishlist initialized.");
		} 
		return this.setWishList.getAllKeys() ; 
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
		if (this.setWishList == null) {
			System.err.println("No ishlist initialized.");
		}  else if (this.setWishList.containsKey(IDWishList) ) {
			System.err.println("The SetWishList don't have any wishList with ID : " + IDWishList);
		}
		
		return this.setWishList.getElementByKey(IDWishList);
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
		if (this.setWishList == null) {
			System.err.println("No SetWishlist initialized.");
		} else if (this.setWishList.containsKey(IDWishList) ) {
			System.err.println("The SetWishList don't have any wishList with ID : " + IDWishList);
		}
		
		return this.setWishList.getElementByKey(IDWishList).getLabel();
	}
	

}
