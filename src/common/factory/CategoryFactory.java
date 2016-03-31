package common.factory;

import persistent.ActivityCategory;
import persistent.Category;

public abstract class CategoryFactory {
	public abstract Category buildCategoryById(int idCategory) throws Exception;
	
	public abstract ActivityCategory buildActivityCategoryById(int idActivityCategory) throws Exception;
}
