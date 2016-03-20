package persistent;
import common.Set;

/**
 * @author loicd_000
 *
 */
public class WishList extends Set{
	private String label;
	
	public WishList(String label){
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
