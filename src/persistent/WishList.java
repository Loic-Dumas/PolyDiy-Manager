package persistent;
import common.Set;

/**
 * @author loicd_000
 *
 */
public abstract class WishList extends Set{
	protected String label;
	protected int ID;
	
	public WishList(int ID){
		this.setID(ID);
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
