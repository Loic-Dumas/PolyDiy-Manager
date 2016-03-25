package logic;

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
import persistent.ProductWishList;
import persistent.WishList;

/**
 * To handle user interactions with a wishlist.
 * @author loicd_000
 * @since 2016-03-21
 */
public class WishListHandler {
	private ListFactory listFactory = new JDBCListFactory();
	private ProductFactory productFactory = new JDBCProductFactory();
	private WishList wishList = null;
	
	/**
	 * This method create and return the WishList with the ID in parameter. 
	 * If the instance has already a wish list, return the wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDWishList
	 * @return return the WishList. 
	 */
	public WishList createWishList(int IDWishList) throws DifferentWishListException {
		if (this.wishList == null) { // if there's no wishList
			try {
				this.wishList = listFactory.buildWishList(IDWishList);
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the WishList");
				e.printStackTrace();
			}
		}

		return this.wishList;
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
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
		return this.wishList.getProductWithIDProduct(IDProduct);
	}
	
	
	/**
	 * This method add a product to the WishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct, int quantity, float unitPrice
	 * @return true if the product is added to WwishList. False if an error occur.
	 * @throws NoWishListException 
	 * @throws InvalidQuantityException 
	 * @throws InvalidPriceException 
	 * @throws UnknownIDProductException 
	 */
	public boolean addProductToWishList(int IDProduct, int quantity, float unitPrice) 
			throws NoWishListException, InvalidQuantityException, InvalidPriceException, UnknownIDProductException  {
		
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
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
	 * This method remove the product of ID in parameter of the WishList of the instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param int IDProduct,
	 * @return void
	 * @throws NoWishListException 
	 */
	public void removeProductToWishList(int IDProduct) 
			throws NoWishListException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
		this.wishList.removeProductWithIDProduct(IDProduct);
	}
	

	/**
	 * This method update the unitPrice of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param  int IDProduct, float unitPrice
	 * @return void
	 * @throws NoWishListException 
	 * @throws InvalidPriceException 
	 */
	public void updatePriceProductToWishList( int IDProduct, float unitPrice) 
			throws NoWishListException, InvalidPriceException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}

		this.wishList.updateNewUnitPriceProductWithIDProduct(IDProduct, unitPrice);
	}
	

	/**
	 * This method update the quantity of the product (with ID in parameter) of the WishList of this instance.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct, int quantity
	 * @return void
	 * @throws NoWishListException 
	 * @throws InvalidQuantityException 
	 */
	public void updateProductToWishList( int IDProduct, int quantity) 
			throws NoWishListException, InvalidQuantityException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}

		this.wishList.updateNewQuantityProductWithIDProduct(IDProduct, quantity);
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
	public void renameWishList(String newName) throws NoWishListException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
		this.wishList.setLabel(newName);
	}
	
	
	/**
	 * This method add the item to the cart. And delete this item from the current WishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param int IDProduct
	 * @return void
	 * @throws NoWishListException 
	 */
	public void addProductToCart(int IdProduct) throws NoWishListException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
		// TODO Implement addProductToCart.
	}
	

	/**
	 * This method add all products of the wishList in parameter to the cart.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param IDWishList
	 */
	public void addProductAllProducrsToCart(int IDWishList) {
		
		// TODO Implement addProductAllProducrsToCart
	}
	
	
	/**
	 * This method save in the database all modifications in the database.
	 * 
	 * @author loicd_000
	 * @since 2016-03-23
	 * @param 
	 * @return void
	 * @throws NoWishListException 
	 */
	public void saveWishList() throws NoWishListException {
		if (this.wishList == null) {
			throw new NoWishListException();
		}
		
		// TODO Implement saveWishList. Register all informations to the database.
	}
	
	
}
