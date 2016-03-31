package common.factory.jdbcFactory;

import java.util.Arrays;

import common.factory.CategoryFactory;
import persistent.ActivityCategory;
import persistent.Category;
import persistent.jdbc.JDBCActivityCategory;
import persistent.jdbc.JDBCCategory;

public class JDBCCategoryFactory extends CategoryFactory {

	@Override
	public Category buildCategoryById(int idCategory) throws Exception {
		Category category = new JDBCCategory();
		category.loadFromKeys(Arrays.asList("id_category"), Arrays.asList(Integer.toString(idCategory)));
		return category;
	}

	@Override
	public ActivityCategory buildActivityCategoryById(int idActivityCategory) throws Exception{
		ActivityCategory activityCategory = new JDBCActivityCategory();
		activityCategory.loadFromKeys(Arrays.asList("id_activity_category"), Arrays.asList(Integer.toString(idActivityCategory)));
		return activityCategory;
	}

}
