package logic.facade;

import java.util.Collection;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import logic.user.ActivityHandler;
import logic.user.ObjectiveHandler;
import logic.user.TaskHandler;
import persistent.abstractclass.Activity;
import persistent.abstractclass.ActivityCategory;
import persistent.abstractclass.Category;
import persistent.abstractclass.Objective;
import persistent.abstractclass.Task;

public class FacadeActivityPanel {
	private ActivityHandler activityHandler = new ActivityHandler();
	private TaskHandler taskHandler = new TaskHandler();
	private ObjectiveHandler objectiveHandler = new ObjectiveHandler();
	
	public FacadeActivityPanel() {
	}
	
	public void loadActivities(int idUser) throws Exception {
		this.activityHandler.loadActivities(idUser);
	}
	
	public void loadActivity(int idActivity) throws ErrorConnectionException, AlertDriver, Exception {
		this.activityHandler.loadActivity(idActivity);
	}
	
	public void updateActivity(String title, String description, String deadline, int idActivityCategory,
							int idUser) throws Exception {
		this.activityHandler.updateActivity(title, description, deadline, idActivityCategory, idUser);
	}
	
	public void deleteActivity() throws Exception {
		this.activityHandler.deleteActivity();
	}
	
	public int getNumberOfActivites() {
		return this.activityHandler.getNumberOfActivities();
	}
	
	public Collection<Activity> getActivities() {
		return this.activityHandler.getActivities();
	}
	
	public Activity getActivity() {
		return this.activityHandler.getActivity();
	}
	
	public ActivityCategory getActivityCategory() throws Exception {
		return this.activityHandler.getActivityCategory();
	}
	
	public void loadTasks(int idUser) throws Exception {
		this.taskHandler.loadTasks(idUser);
	}
	
	public void updateTask() throws Exception {
		this.taskHandler.updateTask();
	}
	
	public void deleteTask() throws Exception {
		this.taskHandler.deleteTask();
	}
	
	public void loadTask(int idTask) throws Exception {
		this.taskHandler.loadTask(idTask);
	}
	
	public int getNumberOfTasks() {
		return this.taskHandler.getNumberOfTasks();
	}
	
	public Collection<Task> getTasks() {
		return this.taskHandler.getTasks();
	}
	
	public Task getTask() {
		return this.taskHandler.getTask();
	}
	
	public Category getTaskCategory() throws Exception {
		return this.taskHandler.getTaskCategory();
	}
	
	public void loadObjectives(int idUser) throws Exception {
		this.objectiveHandler.loadObjectives(idUser);
	}
	
	public void loadObjective(int idObjective) throws Exception {
		this.objectiveHandler.loadObjective(idObjective);
	}
	
	public void updateObjective() throws Exception {
		this.objectiveHandler.updateObjective();
	}
	
	public void deleteObjective() throws Exception {
		this.objectiveHandler.deleteObjective();
	}
	
	public int getNumberOfObjectives() {
		return this.objectiveHandler.getNumberOfObjectives();
	}
	
	public Collection<Objective> getObjectives() {
		return this.objectiveHandler.getObjectives();
	}
	
	public Objective getObjective() {
		return this.objectiveHandler.getObjective();
	}
	
	public Category getObjectiveCategory() throws Exception {
		return this.objectiveHandler.getObjectiveCategory();
	}
}
