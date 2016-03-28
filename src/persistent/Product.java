package persistent;

import common.InterfaceModel;

/**
 * A product contains ID, name, description, unitPrice and stockQuantity.
 * A product is created with his ID.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
public abstract class Product implements InterfaceModel {
	protected int ID;
	protected String name;
	protected String description;
	protected float unitPrice;
	protected int stockQuantity;
	
	protected Boolean hasChanged = false;
	
	// the product is created from is ID
	public Product(int ID) {
		this.ID = ID;
		this.hasChanged = true;
	}

	public int getID() {
		return this.ID;
	}
	public void setID(int ID) {
		this.ID = ID;
		this.hasChanged = true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.hasChanged = true;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		this.hasChanged = true;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
		this.hasChanged = true;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
		this.hasChanged = true;
	}
	
}
