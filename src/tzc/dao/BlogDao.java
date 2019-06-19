package tzc.dao;

import java.util.List;

import tzc.bean.Blog;
import tzc.util.Page;
public interface BlogDao {
	public List<Blog> getAll();
	public void addBlog(Blog blog);
	public List<Blog> findAllBlogs(Page page);
	public void deleteBlog(int id);
	public int findAllCount();				
}
