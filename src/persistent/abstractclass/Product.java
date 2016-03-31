package persistent.abstractclass;

/**
 * A product contains ID, name, description, unitPrice and stockQuantity.
 * A product is created with his ID.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
public abstract class Product implements InterfaceModel {
	protected int IDProduct;
	protected String name;
	protected String description;
	protected float unitPrice;
	protected int stockQuantity;
	protected int IDSeller;
	protected int IDCategory;
	protected String categoryName;
	
	protected Boolean hasChanged = false;
	
	// the product is created from is ID
	public Product(int ID) {
		this.IDProduct = ID;
		this.hasChanged = true;
	}
	public Product (int ID, int IDSeller){
		this.IDProduct= ID;
		this.IDSeller = IDSeller;
		this.hasChanged = true;
	}

	public int getIDProduct() {
		return this.IDProduct;
	}
	public void setIDProduct(int ID) {
		this.IDProduct = ID;
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
	public int getIDSeller() {
		return IDSeller;
	}

	public void setIDSeller(int iDSeller) {
		IDSeller = iDSeller;
	}

	public int getIDCategory() {
		return IDCategory;
	}

	public void setIDCategory(int iDCategory) {
		IDCategory = iDCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
