package common.factory.jdbcFactory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import common.factory.ActivityFactory;
import persistent.Activity;
import persistent.Objective;
import persistent.Task;
import persistent.jdbc.JDBCActivity;
import persistent.jdbc.JDBCObjective;
import persistent.jdbc.JDBCTask;
import persistent.jdbc.list.JDBCSetActivity;
import persistent.jdbc.list.JDBCSetObjective;
import persistent.jdbc.list.JDBCSetTask;
import persistent.list.SetActivity;
import persistent.list.SetObjective;
import persistent.list.SetTask;

public class JDBCActivityFactory extends ActivityFactory {

	@Override
	public SetActivity buildListActivitiesFromUser(int idUser) throws Exception {
		SetActivity activities = new JDBCSetActivity(idUser);
		
		return activities;
	}

	@Override
	public Activity buildActivity(int idActivity, String title, String description, String deadline,
								int idActivityCategory, int idUser) throws ErrorConnectionException, AlertDriver {
		Activity activity = new JDBCActivity();
		activity.setIdActivity(idActivity);
		activity.setTitle(title);
		activity.setDescription(description);
		activity.setDeadline(deadline);
		activity.setIdActivityCategory(idActivityCategory);
		activity.setIdUser(idUser);
		return activity;
	}

	@Override
	public SetTask buildListTasksFromUser(int idUser) throws Exception {
		SetTask tasks = new JDBCSetTask(idUser);
		
		return tasks;
	}

	@Override
	public Task buildTask(int idTask, String title, int idActivity, int idCategory, int idUser)
			throws ErrorConnectionException, AlertDriver {
		Task task = new JDBCTask();
		task.setIdTask(idTask);
		task.setTitle(title);
		task.setIdActivity(idActivity);
		task.setIdCategory(idCategory);
		task.setIdUser(idUser);
		return task;
	}

	@Override
	public SetObjective buildListObjectivesFromUser(int idUser) throws Exception {
		SetObjective objectives = new JDBCSetObjective(idUser);
		
		return objectives;
	}

	@Override
	public Objective buildObjective(int idObjective, String title, String description, String deadline,
			int facultativIdActivity, int idCategory, int idUser) throws ErrorConnectionException, AlertDriver {
		Objective objective = new JDBCObjective();
		objective.setIdObjective(idObjective);
		objective.setTitle(title);
		objective.setDescription(description);
		objective.setDeadline(deadline);
		objective.setFacultativIdActivity(facultativIdActivity);
		objective.setIdCategory(idCategory);
		objective.setIdUser(idUser);
		return objective;
	}

}
