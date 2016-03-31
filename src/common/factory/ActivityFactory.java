package common.factory;

import common.exception.AlertDriver;
import common.exception.ErrorConnectionException;
import persistent.Activity;
import persistent.Objective;
import persistent.Task;
import persistent.list.SetActivity;
import persistent.list.SetObjective;
import persistent.list.SetTask;

public abstract class ActivityFactory {
	public abstract SetActivity buildListActivitiesFromUser(int idUser) throws Exception;
	
	public abstract Activity buildActivity(int idActivity, String title, String description, String deadline,
											int idActivityCategory, int idUser) throws ErrorConnectionException, AlertDriver;
	

	public abstract SetTask buildListTasksFromUser(int idUser) throws Exception;
	
	public abstract Task buildTask(int idTask, String title, int idActivity, int idCategory, int idUser) 
			throws ErrorConnectionException, AlertDriver;

	public abstract SetObjective buildListObjectivesFromUser(int idUser) throws Exception;
	
	public abstract Objective buildObjective(int idObjective, String title, String description, String deadline,
											int facultativIdActivity, int idCategory, int idUser) throws ErrorConnectionException, AlertDriver;
}
