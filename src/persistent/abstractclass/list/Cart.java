package persistent.abstractclass.list;

public abstract class Cart extends WishList{
	protected int IDUser; 

	public Cart(int IDWishList) { // posible que ce soit l'idUser des fois.
		super(IDWishList);
		this.IDUser = IDWishList;
	}

	public int getIDUser() {
		return IDUser;
	}

	public void setIDUser(int iDUser) {
		IDUser = iDUser;
	}

}
