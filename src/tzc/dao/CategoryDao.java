package tzc.dao;

import java.util.List;

import tzc.bean.Category;
import tzc.util.Page;

public interface CategoryDao {
	public List<Category> getAll();
	public int findAllCount();
	public void add(Category category);
	public void delete(int id);
	public List<Category> findAllCategorys(Page page);
	public void update(Category category);
}
