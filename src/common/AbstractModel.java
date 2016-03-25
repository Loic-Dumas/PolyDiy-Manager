package common;

public abstract class AbstractModel {
	public abstract Boolean isExisting() throws Exception;
	
	public abstract void loadFromIntKey(String name, int value) throws Exception;
	public abstract void loadFromStringKey(String name, String value) throws Exception;
	
	public abstract void insert() throws Exception;
	
	public abstract void update() throws Exception;
	
	public abstract void delete() throws Exception;
}
