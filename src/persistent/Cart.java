package persistent;

public abstract class Cart extends WishList{
	
	public Cart(String label) {
		super(label);
		// TODO faudra voir si on fait un singleton?
	}

	public abstract void order();

}
