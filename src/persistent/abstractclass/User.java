package persistent.abstractclass;

public abstract class User implements InterfaceModel {
	protected int ID = -1;
	protected int IDaccount = -1;
	
	public User() {
	}
	
	public int getID() {
		return this.ID;
	}
	
	public int getIDaccount() {
		return this.IDaccount;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setIDaccount(int IDaccount) {
		this.IDaccount = IDaccount;
	}
}
