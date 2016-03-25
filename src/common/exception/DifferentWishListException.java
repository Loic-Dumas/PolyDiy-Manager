package common.exception;
/**
 * This exception is thrown when you try to modify a list different of the current list.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-21
 */
public class DifferentWishListException extends Exception{	
	private static final long serialVersionUID = 1L;
	private int IDWishList;
	private int realIDWishList;
	
	public DifferentWishListException(int IDWishList, int realIDWishList){
		this.IDWishList = IDWishList;
		this.realIDWishList = realIDWishList;
	}
	
	@Override
	public String getMessage() {
		return "The WishList with this ID : " + this.IDWishList + " is invalid. Should be " + this.realIDWishList + ".";
	}
}


