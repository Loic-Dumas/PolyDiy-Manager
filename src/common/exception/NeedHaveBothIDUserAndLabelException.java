package common.exception;


/**
 * This exception is thrown when we check if a wish list exists the IDUser or the label 
 * but one ore more is unset.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class NeedHaveBothIDUserAndLabelException extends Exception {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "The IDUser or the label of the wishList is unset";
	}
}
