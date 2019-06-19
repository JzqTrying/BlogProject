package tzc.bean;

import java.sql.Date;
import java.util.List;

public class Article {
	
	private int id;
	private int cid;
	private List<Areply> areplys;
	
	public List<Areply> getAreplys() {
		return areplys;
	}
	public void setAreplys(List<Areply> areplys) {
		this.areplys = areplys;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	private String title;
	private int count;
	private Date createDate;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
		
	
}
