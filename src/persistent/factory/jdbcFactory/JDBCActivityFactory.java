package persistent.factory.jdbcFactory;

import java.util.Arrays;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.abstractclass.Activity;
import persistent.abstractclass.Objective;
import persistent.abstractclass.Task;
import persistent.abstractclass.list.SetActivity;
import persistent.abstractclass.list.SetObjective;
import persistent.abstractclass.list.SetTask;
import persistent.factory.ActivityFactory;
import persistent.jdbc.JDBCActivity;
import persistent.jdbc.JDBCObjective;
import persistent.jdbc.JDBCTask;
import persistent.jdbc.list.JDBCSetActivity;
import persistent.jdbc.list.JDBCSetObjective;
import persistent.jdbc.list.JDBCSetTask;

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
	public Activity buildActivityFromId(int idActivity) throws Exception {
		Activity activity = new JDBCActivity();
		if(idActivity != -1) {
			activity.loadFromKeys(Arrays.asList("id_activity"), Arrays.asList(Integer.toString(idActivity)));
		}
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
	public Task buildTaskFromId(int idTask) throws Exception {
		Task task = new JDBCTask();
		if(idTask != -1) {
			task.loadFromKeys(Arrays.asList("id_task"), Arrays.asList(Integer.toString(idTask)));
		}
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

	@Override
	public Objective buildObjectiveFromId(int idObjective) throws Exception {
		Objective objective = new JDBCObjective();
		if(idObjective != -1) {
			objective.loadFromKeys(Arrays.asList("id_objective"), Arrays.asList(Integer.toString(idObjective)));
		}
		return objective;
	}

}
