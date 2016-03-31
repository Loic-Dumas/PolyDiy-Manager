package logic.user;

import java.util.Collection;

import common.factory.ActivityFactory;
import common.factory.jdbcFactory.JDBCActivityFactory;
import persistent.Activity;
import persistent.list.SetActivity;

public class ActivityHandler {
	public SetActivity activities = null;
	
	public ActivityHandler() {
	}
	
	public void loadActivities(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.activities = factory.buildListActivitiesFromUser(idUser);
	}
	
	public int getNumberOfActivities() {
		return this.activities.count();
	}
	
	public Collection<Activity> getActivities() {
		return activities.getAllElements();
	}
}
