package common;

import java.util.List;

/**
 * @author IsilinBN
 * Declare an interface for data models. A model should implements constructors, getters, setters, 
 * and the following methods.
 */
public interface InterfaceModel {
	/**
	 * Check if a tuple with same primary keys is register.
	 * @return True if a tuple exists with the same primary key, else false.
	 * @throws Exception
	 */
	public abstract Boolean isExisting() throws Exception;
	
	/**
	 * @return True if there is a tuple with same primary key, but different values, else false.
	 * @throws Exception
	 */
	public abstract Boolean hasChanged() throws Exception;
	
	/**
	 * Load model from database by looking for the primary keys.
	 * @param arguments List of primary keys
	 * @throws Exception
	 */
	public abstract void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception;
	
	/**
	 * If the model doesn't already exist, create a tuple.
	 * @throws Exception
	 */
	public abstract void insert() throws Exception;
	
	/**
	 * If the model already exists as a tuple but has changed, update it.
	 * @throws Exception
	 */
	public abstract void update() throws Exception;
	
	/**
	 * If the model is registered, delete it.
	 * @throws Exception
	 */
	public abstract void delete() throws Exception;
}
