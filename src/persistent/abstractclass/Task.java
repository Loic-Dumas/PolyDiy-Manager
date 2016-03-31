package persistent.abstractclass;

public abstract class Task implements InterfaceModel {
	protected int idTask = -1;
	protected String title = "";
	protected int idActivity = -1;
	protected int idCategory = -1;
	protected int idUser = -1;
	
	public int getIdTask() {
		return this.idTask;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getIdActivity() {
		return this.idActivity;
	}
	
	public int getIdCategory() {
		return this.idCategory;
	}
	
	public int getIdUser() {
		return this.idUser;
	}
	
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
