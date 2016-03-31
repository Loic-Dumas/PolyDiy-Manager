package persistent;

import common.InterfaceModel;

public abstract class Category implements InterfaceModel {
	protected int idCategory = -1;
	protected String title = "";
	protected String description = "";
	
	public int getIdCategory() {
		return this.idCategory;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
