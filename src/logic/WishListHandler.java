package logic;

import common.exception.DifferentWishListException;
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
	WishList wishList = null;
	
	/**
	 * This method return the WishList with the ID in parameter.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int ID (of the product to add), int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 */
	public WishList createWishList(int ID) {	
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
	 * @param int IDWishList, int IDProduct (of the product to add), int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 * @throws DifferentWishListException 
	 */
	public boolean addProductToWishList(int IDWishList, int IDProduct, int quantity, float unitPrice) 
			throws UnknownIDProductException, InvalidQuantityException, InvalidPriceException, DifferentWishListException {
		// first we create the WishList.
		if (wishList == null) {
			try {
				this.wishList = listFactory.buildWishList(IDWishList);
			} catch (ErrorConnectionException e) {
				e.printStackTrace();
			}
		}
		if (this.wishList.getID() == IDWishList) {
			throw new DifferentWishListException(IDWishList, this.wishList.getID() );
		}
		
		// now we add the product.
		try {
			if (quantity <= 0) { 
				throw new InvalidQuantityException(quantity);
			} else if (unitPrice < 0 ) {
				throw new InvalidPriceException(unitPrice);
			}
			
			this.wishList.addElement(this.productFactory.buildProductWishList(IDProduct, quantity, unitPrice));
			return true ;
		} catch (UnknownIDProductException e) {
			System.err.println(e);
			e.printStackTrace();
			throw new UnknownIDProductException(IDProduct);	
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
	 * @param int IDWishList, int IDProduct,
	 * @return void
	 * @throws DifferentWishListException 
	 */
	public void removeProductToWishList(int IDWishList, int IDProduct) throws DifferentWishListException {
		// first we create the WishList.
		
		if (this.wishList.getID() == IDWishList) {
			throw new DifferentWishListException(IDWishList, this.wishList.getID() );
		}
		
		// TODO we remove the element
		this.wishList.removeProductWithIDProduct(IDProduct);
	}
	
	/**
	 * This method check if the wishList exists. If the wishList don't exist. Create it.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDWishList, int IDProduct,
	 * @return void
	 */
	private void wishListExist(int IDWishList) {
		if (wishList == null) {
			try {
				this.wishList = listFactory.buildWishList(IDWishList);
			} catch (ErrorConnectionException e) {
				e.printStackTrace();
			}
		}
	}
	
}
