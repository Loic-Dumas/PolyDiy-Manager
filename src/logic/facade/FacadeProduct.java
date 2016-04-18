package logic.facade;

import java.util.Set;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import logic.seller.ProductSellerHandler;
import persistent.abstractclass.Product;
import persistent.abstractclass.SetProduct;



/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

	public class FacadeProduct {
		
		int IDSeller = -1;
		ProductSellerHandler handler= new ProductSellerHandler();
	
		
		public FacadeProduct (int IDSeller){
			this.IDSeller = IDSeller;
		}
	
		
		/**
		 * This method create and return a SetProduct
		 * 
		 * @author nassim vachor
		 * @since 2016-03-30
		 * @return SetProduct
		 */
		public SetProduct createAndGetExistingSetProduct(int ID) {
			return this.handler.createAndGetExistingSetProduct(ID);
			}

		/**
		 * This method return a set of the keys contained in this SetProduct
		 * 
		 * @author nassim vachor
		 * @since 2016-03-30
		 * @return a set of the keys contained in this SetProduct
		 */
		public Set<String> getListID() {
			return this.handler.getListID();
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
			return this.handler.getProductWithID(IDProduct);
		}
		
		
		/**
		 * Return The name of the product 
		 * 
		 * @author nassim vachor
		 * @param IDProduct - String
		 * @return The name of the product
		 */
		public String getNameProduct(String IDProduct) {
			return this.handler.getNameProduct(IDProduct);
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
			
			
			 this.handler.RemoveProduct(IDProduct);
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
			this.handler.UpdateProduct(IDProduct);
		
		}
		/**
		 * add product to set
		 * 
		 * @author nassim vachor
		 * @param IDProduct - String
		 * @return The name of the product
		 * @throws Exception 
		 */
		public void addProduct( String name, String description, float unitPrice,
				int stockQuantity,  int idS, int IDCategory, String categoryName) throws Exception {
			this.handler.addProduct( name, description, unitPrice, stockQuantity, IDSeller, IDCategory, categoryName);
		}
		
		

		
		// create product 
		public void createProduct( String name, String description, float unitPrice,
				int stockQuantity, int ids, int IDCategory, String categoryName) throws ErrorConnectionException, AlertDriver {
			
			this.handler.createProduct( name, description, unitPrice, stockQuantity, IDSeller, IDCategory, categoryName);
		}
		
		public void getProductWithId(int ID, int idS) throws ErrorConnectionException, AlertDriver, UnknownIDProductException {
			
			this.handler.getProductWithId(ID, IDSeller);
		
		}
		
		/*
		public void createProduct(int IDProduct, String name, String description, float unitPrice,
				int stockQuantity, int IDSeller, int IDCategory, String categoryName) throws ErrorConnectionException, AlertDriver {
			
			this.handler.createProduct(IDaccount, name, description, unitPrice, stockQuantity, IDSeller, IDCategory, categoryName);
		}
	
		public void getProductWithId(int ID) throws ErrorConnectionException, AlertDriver, UnknownIDProductException {
			
			this.handler.getProductWithId(IDaccount);
		}
			
		public int getIDProduct() throws ErrorConnectionException, AlertDriver, UnknownIDProductException {
			this.handler.getProductWithId(IDaccount);
			return this.handler.getIDProduct();
		}
		public void setIDProduct(int ID) {
			this.handler.setIDProduct(ID);
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
