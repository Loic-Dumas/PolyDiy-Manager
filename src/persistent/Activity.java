package persistent;

import common.InterfaceModel;

public abstract class Activity implements InterfaceModel {
	protected int idActivity = -1;
	protected String title = "";
	protected String description = "";
	protected String deadline = "";
	protected int idActivityCategory = -1;
	protected int idUser = -1;
	
	public int getIdActivity() {
		return this.idActivity;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	public String getDeadline() {
		return this.deadline;
	}
	
	public int getIdActivityCategory() {
		return this.idActivityCategory;
	}
	
	public int getIdUser() {
		return this.idUser;
	}
	
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public void setIdActivityCategory(int idActivityCategory) {
		this.idActivityCategory = idActivityCategory;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
