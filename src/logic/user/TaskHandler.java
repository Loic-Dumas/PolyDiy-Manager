package logic.user;

import java.util.Collection;

import common.factory.ActivityFactory;
import common.factory.jdbcFactory.JDBCActivityFactory;
import persistent.Task;
import persistent.list.SetTask;

public class TaskHandler {
	public SetTask tasks = null;
	
	public TaskHandler() {
	}
	
	public void loadTasks(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.tasks = factory.buildListTasksFromUser(idUser);
	}
	
	public int getNumberOfTasks() {
		return this.tasks.count();
	}
	
	public Collection<Task> getTasks() {
		return this.tasks.getAllElements();
	}
}
