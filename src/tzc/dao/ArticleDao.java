package tzc.dao;

import java.util.List;

import tzc.bean.Article;
import tzc.util.Page;

public interface ArticleDao {
	
	public void addArticle(Article article);   
	public Article findArticleByTitle(String title);
	public Article findArticleById(int id); 
	public List<Article> findAllArticles(Page page);
	public int findAllCount();		
	public void delete(int id);
	public void update(Article article);
	public List<Article> getall();
	public List<Article> selectByCid(int cid);
}