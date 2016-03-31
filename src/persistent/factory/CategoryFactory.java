package persistent.factory;

import persistent.abstractclass.ActivityCategory;
import persistent.abstractclass.Category;

public abstract class CategoryFactory {
	public abstract Category buildCategoryById(int idCategory) throws Exception;
	
	public abstract ActivityCategory buildActivityCategoryById(int idActivityCategory) throws Exception;
}
