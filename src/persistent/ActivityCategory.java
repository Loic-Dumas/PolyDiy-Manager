package persistent;

import common.InterfaceModel;

public abstract class ActivityCategory implements InterfaceModel {
	protected int idActivityCategory = -1;
	protected String label = "";
	protected String shortDescription = "";
	protected String description = "";
	
	public int getIdActivityCategory() {
		return this.idActivityCategory;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setIdActivityCategory(int idActivityCategory) {
		this.idActivityCategory = idActivityCategory;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
