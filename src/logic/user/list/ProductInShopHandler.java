package logic.user.list;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.NoCartException;
import common.exception.UnknownIDProductException;
import common.factory.ListFactory;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import persistent.Product;
import persistent.list.Cart;
import persistent.list.ProductWishList;
import persistent.list.WishList;

public class ProductInShopHandler {
	Product product = null;
	Cart cart = null;
	WishList wishList = null;
	ProductFactory productFactory = new JDBCProductFactory();
	ListFactory listFactory = new JDBCListFactory();

	/**
	 * This method return a product
	 * 
	 * @author loicd_000
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public Product createAndGetProduct(int IDProduct) {
		if (this.product == null) {
			try {
				try {
					this.product = productFactory.buildProduct(IDProduct);
				} catch (AlertDriver e) {
					e.printStackTrace();
				} catch (UnknownIDProductException e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the Product");
				e.printStackTrace();
			}
		}
		return this.product;
	}

	/**
	 * This method add the current product to the cart of thisUser
	 * 
	 * @param IDProduct
	 * @param unitPrice
	 * @param quantity
	 * @param IDUser
	 * @param IDWishList
	 */
	public void addToCart(int IDProduct, float unitPrice, int quantity, int IDUser) {
		try {
//			if (!existCart(IDUser)) {
//				// create cart
//			}
			
			// we create the cart
			try {
				this.cart = this.listFactory.buildCart(IDUser);
			} catch (NoCartException e1) {
				System.err.println("Il n'y a pas de Cart !");
				//e1.printStackTrace();
			}
			
			//if the cart already have the product, we increment the quantity of this product.
			if (cart.containsKey(String.valueOf(IDProduct))) {
				ProductWishList product = cart.getElementByKey(String.valueOf(IDProduct));
				product.setQuantity(quantity + product.getQuantity());
				
				try {
					cart.getElementByKey(String.valueOf(IDProduct)).update();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				cart.addElement(String.valueOf(IDProduct),
						this.productFactory.buildProductWishList(IDProduct, cart.getID(), quantity, unitPrice));
				try {
					cart.getElementByKey(String.valueOf(IDProduct)).insert();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ErrorConnectionException e) {
			e.printStackTrace();
		} catch (UnknownIDProductException e) {
			e.printStackTrace();
		} catch (AlertDriver e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method add the current product to the wishList of the User
	 * 
	 * @param IDProduct
	 * @param unitPrice
	 * @param quantity
	 * @param IDWishList
	 * @param IDWishList
	 */
	public void addToWishList(int IDProduct, float unitPrice, int quantity, int IDWishList) {
		try {
			
			
			this.wishList = this.listFactory.buildWishList(IDWishList);
			
			if (wishList.containsKey(String.valueOf(IDProduct))) {
				ProductWishList product = wishList.getElementByKey(String.valueOf(IDProduct));
				product.setQuantity(quantity + product.getQuantity());
				
				try {
					wishList.getElementByKey(String.valueOf(IDProduct)).update();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				wishList.addElement(String.valueOf(IDProduct),
						this.productFactory.buildProductWishList(IDProduct, this.wishList.getID(), quantity, unitPrice));
				try {
					wishList.getElementByKey(String.valueOf(IDProduct)).insert();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (ErrorConnectionException e) {
			e.printStackTrace();
		} catch (AlertDriver e) {
			e.printStackTrace();
		} catch (UnknownIDProductException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Return true if a Cart for this user exist, if not, false.
	 * 
	 * @param IDUser
	 * @return true if a Cart for this user exist, if not, false.
	 */
	public Boolean existCart(int IDUser) {
		Boolean exist = false;

		return exist;
	}

}
