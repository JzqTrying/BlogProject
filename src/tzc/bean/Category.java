package tzc.bean;

import java.sql.Date;
import java.util.List;

public class Category {
	private int id;
	private String name;
	private Date createDate;
	private List<Article> articles;
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Category() {
		
	}
	
	public Category(int id, Date createDate) {
		super();
		this.id = id;
		this.createDate = createDate;
	}

	public Category(String name) {
		super();
		this.name=name;
	}
	
	public Category(Date createDate) {
		super();
		this.createDate = createDate;
	}
	public Category(String name, java.sql.Date createDate) {
		super();
		this.name = name;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
