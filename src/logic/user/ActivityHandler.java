package logic.user;

import java.util.Collection;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ActivityFactory;
import common.factory.CategoryFactory;
import common.factory.jdbcFactory.JDBCActivityFactory;
import common.factory.jdbcFactory.JDBCCategoryFactory;
import persistent.Activity;
import persistent.ActivityCategory;
import persistent.list.SetActivity;

public class ActivityHandler {
	private SetActivity activities = null;
	private Activity activity = null;
	
	public ActivityHandler() {
	}
	
	public void loadActivities(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.activities = factory.buildListActivitiesFromUser(idUser);
	}
	
	public void loadActivity(int idActivity) throws ErrorConnectionException, AlertDriver, Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.activity = factory.buildActivityFromId(idActivity);
	}
	
	public int getNumberOfActivities() {
		return this.activities.count();
	}
	
	public Collection<Activity> getActivities() {
		return activities.getAllElements();
	}
	
	public Activity getActivity() {
		return this.activity;
	}

	public ActivityCategory getActivityCategory() throws Exception {
		CategoryFactory factory = new JDBCCategoryFactory();
		return factory.buildActivityCategoryById(this.activity.getIdActivityCategory());
	}

	public void updateActivity(String title, String description, String deadline, int idActivityCategory,
								int idUser) throws Exception {
		this.activity.setTitle(title);
		this.activity.setDescription(description);
		this.activity.setDeadline(deadline);
		this.activity.setIdActivityCategory(idActivityCategory);
		this.activity.setIdUser(idUser);
		if(this.activity.getIdActivity() == -1) {
			this.activity.insert();
		} else {
			this.activity.update();
		}
		
	}

	public void deleteActivity() throws Exception {
		if(this.activity.getIdActivity() != -1) {
			this.activity.delete();
		}
	}
}
