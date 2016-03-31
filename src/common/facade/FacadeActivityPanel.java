package common.facade;

import java.util.Collection;

import logic.user.ActivityHandler;
import logic.user.ObjectiveHandler;
import logic.user.TaskHandler;
import persistent.Activity;
import persistent.Objective;
import persistent.Task;

public class FacadeActivityPanel {
	private ActivityHandler activityHandler = new ActivityHandler();
	private TaskHandler taskHandler = new TaskHandler();
	private ObjectiveHandler objectiveHandler = new ObjectiveHandler();
	
	public FacadeActivityPanel() {
	}
	
	public void loadActivities(int nbUser) throws Exception {
		this.activityHandler.loadActivities(nbUser);
	}
	
	public int getNumberOfActivites() {
		return this.activityHandler.getNumberOfActivities();
	}
	
	public Collection<Activity> getActivities() {
		return this.activityHandler.getActivities();
	}
	
	public void loadTasks(int nbUser) throws Exception {
		this.taskHandler.loadTasks(nbUser);
	}
	
	public int getNumberOfTasks() {
		return this.taskHandler.getNumberOfTasks();
	}
	
	public Collection<Task> getTasks() {
		return this.taskHandler.getTasks();
	}
	
	public void loadObjectives(int nbUser) throws Exception {
		this.objectiveHandler.loadObjectives(nbUser);
	}
	
	public int getNumberOfObjectives() {
		return this.objectiveHandler.getNumberOfObjectives();
	}
	
	public Collection<Objective> getObjectives() {
		return this.objectiveHandler.getObjectives();
	}
}
