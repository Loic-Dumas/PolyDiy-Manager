package logic;
import java.util.Set;

/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-30
 */
import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.factory.ListFactory;
import common.factory.ProductFactory;
import common.factory.jdbcFactory.JDBCListFactory;
import common.factory.jdbcFactory.JDBCProductFactory;
import persistent.Product;
import persistent.SetProduct;

public class ProductSellerHandler {
	private Product product = null;
	ProductFactory productFactory = new JDBCProductFactory(); 
	protected SetProduct setProduct = null;
	ListFactory listFactory = new JDBCListFactory();
	
	/**
	 * This method create and return a SetProduct
	 * 
	 * @author nassim vachor
	 * @since 2016-03-30
	 * @return SetProduct
	 */
	public SetProduct createAndGetExistingSetProduct(int IDSeller) {
		if (this.setProduct == null) { 
			try {
				try {
					this.setProduct = listFactory.buildSetProduct(IDSeller);
				} catch (AlertDriver e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the setProduct");
				e.printStackTrace();
			}
		}

		return this.setProduct;
	}
	/**
	 * This method return a set of the keys contained in this SetProduct
	 * 
	 * @author nassim vachor
	 * @since 2016-03-30
	 * @return a set of the keys contained in this SetProduct
	 */
	public Set<String> getListID() {
		if (this.setProduct== null) {
			System.err.println("No setProduct initialized.");
		} 
		return this.setProduct.getAllKeys() ; 
	}
	

	/**
	 * This method return the product (with ID) from the SetProduct of this instance of class.
	 * 
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param IDProduct - String
	 * @return The product (with ID) from the SetProduct of this instance of class. Or null.
	 */
	public Product getProductWithID(String IDProduct) {
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		return this.setProduct.getElementByKey(IDProduct);
	}
	
	
	/**
	 * Return The name of the product 
	 * 
	 * @author nassim vachor
	 * @param IDProduct - String
	 * @return The name of the product
	 */
	public String getNameProduct(String IDProduct) {
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (!this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		return this.setProduct.getElementByKey(IDProduct).getName();
	}
	
	/**
	 * Remove product from setProduct with with key
	 * 
	 * @author nassim vachor
	 * @param IDProduct - String
	 * @return The name of the product
	 * @throws Exception 
	 */
	public void RemoveProduct(String IDProduct) throws Exception {
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (!this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		 this.setProduct.removeElementByKey(IDProduct);
	}
	/**
	 * update product with with key
	 * 
	 * @author nassim vachor
	 * @param IDProduct - String
	 * @return The name of the product
	 * @throws Exception 
	 */
	public void UpdateProduct(String IDProduct) throws Exception {
		if (this.setProduct == null) {
			System.err.println("No setProduct initialized.");
		}  else if (!this.setProduct.containsKey(IDProduct) ) {
			System.err.println("The SetProduct don't have any product with ID : " + IDProduct);
		}
		
		 this.setProduct.getElementByKey(IDProduct).update();
	
	}
	/**
	 * add product to set
	 * 
	 * @author nassim vachor
	 * @param IDProduct - String
	 * @return The name of the product
	 * @throws Exception 
	 */
	public void addProduct(int IDProduct, String name, String description, float unitPrice,
			int stockQuantity, int IDSeller, int IDCategory, String categoryName) throws Exception {
		// if the product exist in this setProduct
		 if (this.setProduct.containsKey(String.valueOf(IDProduct)) ) {
			 System.err.println("this product is already exist in this se");
			 		}
		 else {
			// if product does not exist in the set but it exists in the databas, so we load it and after we add
			 if ( this.product.isExisting()){
				 this.product = productFactory.buildProduct(IDProduct, IDSeller);
				 this.setProduct.addElement(String.valueOf(IDProduct),product);
			 }
			 //if the product exist nowhere, so we should build it and after add it 
			 else{
				 this.product = productFactory.buildProduct(IDProduct,name, description, unitPrice, stockQuantity, IDSeller, IDCategory, categoryName);
				 this.setProduct.addElement(String.valueOf(product.getIDProduct()),product);
			 }
		 
		 }
	}
	
	

	
	// create product 
	public void createProduct(int idP, String name, String description, float unitPrice,
			int stockQuantity, int IDSeller, int IDCategory, String categoryName) throws ErrorConnectionException, AlertDriver {
		
		this.product = productFactory.buildProduct(idP, name, description, unitPrice, stockQuantity, IDSeller, IDCategory, categoryName);
	}
	
	public void getProductWithId(int ID, int IDSeller) throws ErrorConnectionException, AlertDriver, UnknownIDProductException {
		
		this.product = productFactory.buildProduct(ID, IDSeller);
	}
	/*	
	public int getIDProduct() {
		return this.product.getIDProduct();
	}
	public void setIDProduct(int ID) {
		this.product.setIDProduct(ID);
	}
	public String getName() {
		return this.product.getName();
	}
	public void setName(String name) {
		this.product.setName(name);
	}
	public String getDescription() {
		return this.product.getDescription();
	}
	public void setDescription(String description) {
		this.product.setDescription(description);
	}
	public float getUnitPrice() {
		return this.product.getUnitPrice();
	}
	public void setUnitPrice(float unitPrice) {
		this.product.setUnitPrice(unitPrice);
	}
	public int getStockQuantity() {
		return this.product.getStockQuantity();
	}
	public void setStockQuantity(int stockQuantity) {
		this.product.setStockQuantity(stockQuantity);
	}
	public int getIDSeller() {
		return this.product.getIDSeller();
	}

	public void setIDSeller(int iDSeller) {
		this.product.setIDSeller(iDSeller);
	}

	public int getIDCategory() {
		return this.product.getIDCategory();
	}

	public void setIDCategory(int iDCategory) {
		this.product.setIDCategory(iDCategory);
	}

	public String getCategoryName() {
		return this.product.getCategoryName();
	}

	public void setCategoryName(String categoryName) {
		this.product.setCategoryName(categoryName);
	}
		
	public void RemoveProduct() throws Exception{
		if (product != null){
		this.product.delete();
		}
	}
		
	public void UpdateProduct() throws Exception{
		if (product != null){
		this.product.update();
		}
	}
	public void AddProduct() throws Exception{
		if (product != null){
		this.product.insert();
		}
	}
	*/		
		
}
	
	
	

