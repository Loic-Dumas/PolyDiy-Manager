package persistent.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.abstractclass.Activity;
import persistent.abstractclass.Objective;
import persistent.abstractclass.Task;
import persistent.abstractclass.list.SetActivity;
import persistent.abstractclass.list.SetObjective;
import persistent.abstractclass.list.SetTask;

public abstract class ActivityFactory {
	public abstract SetActivity buildListActivitiesFromUser(int idUser) throws Exception;
	
	public abstract Activity buildActivity(int idActivity, String title, String description, String deadline,
											int idActivityCategory, int idUser) throws ErrorConnectionException, AlertDriver;
	public abstract Activity buildActivityFromId(int idActivity) throws ErrorConnectionException, AlertDriver, Exception;

	public abstract SetTask buildListTasksFromUser(int idUser) throws Exception;
	
	public abstract Task buildTask(int idTask, String title, int idActivity, int idCategory, int idUser) 
			throws ErrorConnectionException, AlertDriver;
	public abstract Task buildTaskFromId(int idTask) throws Exception;

	public abstract SetObjective buildListObjectivesFromUser(int idUser) throws Exception;
	
	public abstract Objective buildObjective(int idObjective, String title, String description, String deadline,
											int facultativIdActivity, int idCategory, int idUser) throws ErrorConnectionException, AlertDriver;
	public abstract Objective buildObjectiveFromId(int idObjective) throws Exception;
}
