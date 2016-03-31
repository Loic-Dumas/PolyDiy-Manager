package logic.user;

import java.util.Collection;

import persistent.abstractclass.Category;
import persistent.abstractclass.Objective;
import persistent.abstractclass.list.SetObjective;
import persistent.factory.ActivityFactory;
import persistent.factory.CategoryFactory;
import persistent.factory.jdbcFactory.JDBCActivityFactory;
import persistent.factory.jdbcFactory.JDBCCategoryFactory;

public class ObjectiveHandler {
	private SetObjective objectives = null;
	private Objective objective = null;
	
	public ObjectiveHandler() {
	}
	
	public void loadObjectives(int idUser) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.objectives = factory.buildListObjectivesFromUser(idUser);
	}
	
	public void loadObjective(int idObjective) throws Exception {
		ActivityFactory factory = new JDBCActivityFactory();
		this.objective = factory.buildObjectiveFromId(idObjective);
	}
	
	public int getNumberOfObjectives() {
		return this.objectives.count();
	}
	
	public Collection<Objective> getObjectives() {
		return this.objectives.getAllElements();
	}
	
	public Objective getObjective() {
		return this.objective;
	}

	public Category getObjectiveCategory() throws Exception {
		CategoryFactory factory = new JDBCCategoryFactory();
		return factory.buildCategoryById(this.objective.getIdCategory());
	}

	public void updateObjective() throws Exception {
		if(this.objective.getIdObjective() == -1) {
			this.objective.insert();
		} else {
			this.objective.update();
		}
		
	}

	public void deleteObjective() throws Exception {
		if(this.objective.getIdObjective() != -1) {
			this.objective.delete();
		}
	}
}
