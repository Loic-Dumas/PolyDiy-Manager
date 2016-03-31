package logic.user;

import java.util.Collection;

import common.factory.ActivityFactory;
import common.factory.jdbcFactory.JDBCActivityFactory;
import persistent.Objective;
import persistent.list.SetObjective;

public class ObjectiveHandler {
	public SetObjective objectives = null;
	
	public ObjectiveHandler() {
	}
	
	public void loadObjectives(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.objectives = factory.buildListObjectivesFromUser(idUser);
	}
	
	public int getNumberOfObjectives() {
		return this.objectives.count();
	}
	
	public Collection<Objective> getObjectives() {
		return this.objectives.getAllElements();
	}
}
