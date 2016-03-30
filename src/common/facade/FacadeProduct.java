package common.facade;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.exception.UnknownIDSellerException;
import logic.ProductHandler;


/**
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

	public class FacadeProduct {
		
		int IDaccount = -1;
		ProductHandler handler = new ProductHandler();
		public FacadeProduct (int IDaccount){
			this.IDaccount = IDaccount;
		}
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
				

}
