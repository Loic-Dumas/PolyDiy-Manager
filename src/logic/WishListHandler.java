package logic;

import common.exception.ErrorConnectionException;
import common.exception.InvalidPriceException;
import common.exception.InvalidQuantityException;
import common.exception.UnknownIDProductException;
import common.factory.ListFactory;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import persistent.WishList;

/**
 * @author loicd_000
 * @since 2016-03-21
 */
public class WishListHandler {
	ListFactory listFactory = new JDBCListFactory();
	ProductFactory productFactory = new JDBCProductFactory();
	
	/**
	 * This method return the WishList with the ID in parameter.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int ID (of the product to add), int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 */
	public WishList getWishListSet(int ID) {	
		try {
			return listFactory.buildWishList(ID);
		} catch (ErrorConnectionException e) {
			System.err.println("Impossible to return the WishList");
			e.printStackTrace();
		}	
		return null;
	}
	
	
	/**
	 * This method add a product to the WishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int ID (of the product to add), int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 */
	public boolean addProductToWishList(int ID,int quantity, float unitPrice) 
			throws UnknownIDProductException, InvalidQuantityException, InvalidPriceException {
		try {
			if (quantity <= 0) {
				throw new InvalidQuantityException(quantity);
			} else if (unitPrice < 0 ) {
				throw new InvalidPriceException(unitPrice);
			}
			
			this.productFactory.buildProductWishList(ID, quantity, unitPrice);
			return true ;
		} catch (UnknownIDProductException e) {
			System.err.println(e);
			e.printStackTrace();
			throw new UnknownIDProductException(ID);	
		} catch (ErrorConnectionException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	/**
	 * This method remove the product of ID in parameter of the WishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int ID (of the product to remove)
	 * @return void
	 */
	public void removeProductToWishList(int ID) {
		
	}
	
}
