package persistent;

import common.InterfaceModel;

public abstract class Objective implements InterfaceModel {
	protected int idObjective = -1;
	protected String title = "";
	protected String description = "";
	protected String deadline = "";
	protected int facultativIdActivity = -1;
	protected int idCategory = -1;
	protected int idUser = -1;
	
	public int getIdObjective() {
		return this.idObjective;
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
	
	public int getFacultativIdActivity() {
		return this.facultativIdActivity;
	}
	
	public int getIdCategory() {
		return this.idCategory;
	}
	
	public int getIdUser() {
		return this.idUser;
	}
	
	public void setIdObjective(int idOjective) {
		this.idObjective = idOjective;
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
	
	public void setFacultativIdActivity(int facultativIdActivity) {
		this.facultativIdActivity = facultativIdActivity;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
