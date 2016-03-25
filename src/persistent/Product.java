package persistent;

/**
 * A product contains ID, name, description, unitPrice and stockQuantity.
 * A product is created with his ID.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
public abstract class Product {
	protected int ID;
	protected String name;
	protected String description;
	protected float unitPrice;
	protected int stockQuantity;
	
	// the product is created from is ID
	public Product(int ID) {
		this.ID = ID;
		
	}

	public int getID() {
		return this.ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
}
