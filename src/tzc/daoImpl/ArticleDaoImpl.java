package tzc.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tzc.bean.Article;
import tzc.bean.Category;
import tzc.dao.ArticleDao;
import tzc.util.DBConn;
import tzc.util.Page;

public class ArticleDaoImpl implements ArticleDao {

	
	@Override
	public int findAllCount() {
		Connection conn=DBConn.getConnection();
		String sql="select count(*) from article";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		
		return count;
	}

	@Override
	public void addArticle(Article article) {
		Connection conn=DBConn.getConnection();
		String addSql="insert into article(title,createDate,content)values(?,?,?)";
		PreparedStatement stmt=null;
		try {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            String data=s.format(article.getCreateDate());
			stmt=conn.prepareStatement(addSql);
			stmt.setString(1, article.getTitle());
			stmt.setString(2, data);
			stmt.setString(3, article.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt);
			DBConn.close(conn);
		}
	}

	@Override
	public Article findArticleByTitle(String title) {
		Connection conn=DBConn.getConnection();
		String findSql="select id,title,createDate,count,content from article where title=?";
		PreparedStatement stmt = null;	
		ResultSet rs = null;
		Article article=null;
		try {
			stmt=conn.prepareStatement(findSql);
			stmt.setString(1, title);
			rs=stmt.executeQuery();
			if(rs.next()) {
				article=new Article();
				article.setId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setCreateDate(rs.getDate(3));
				article.setCount(rs.getInt(4));
				article.setContent(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		System.out.println(article.getTitle());
		return article;
	}

	@Override
	public Article findArticleById(int id) {
		Connection conn=DBConn.getConnection();
		String findSql="select * from article where id=?";
		PreparedStatement stmt = null;	
		ResultSet rs = null;
		Article article=null;
		try {
			stmt=conn.prepareStatement(findSql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs.next()) {
				article=new Article();
				article.setId(rs.getInt(1));
				article.setCid(rs.getInt(2));
				article.setTitle(rs.getString(3));
				article.setCount(rs.getInt(4));
				article.setCreateDate(rs.getDate(5));
				article.setContent(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return article;
	}

	@Override
	public List<Article> findAllArticles(Page page) {
		Connection conn=DBConn.getConnection();
		String sql="select * from article order by createDate desc limit ?,?";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Article> articles=new ArrayList<Article>();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());
			rs=stmt.executeQuery();
			while(rs.next()) {
				Article article=new Article();
				article.setId(rs.getInt(1));
				article.setCid(rs.getInt(2));
				article.setTitle(rs.getString(3));
				article.setCount(rs.getInt(4));
				article.setCreateDate(rs.getDate(5));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return articles;
	}

	@Override
	public void delete(int id) {
		Connection conn = DBConn.getConnection();
		Statement stmt=null;		
		try {
			stmt = conn.createStatement();
            String sql = "delete from article where id = " + id;
  
            stmt.execute(sql);
  
        } catch (SQLException e) { 
            e.printStackTrace();
        } finally {
        	DBConn.close(conn);
        }
	}

	@Override
	public void update(Article article) {
		Connection conn=DBConn.getConnection();
		String sql="update article set cid= ?, title = ?,count= ?,createDate=?,content=? where id = ?";
		PreparedStatement stmt=null;
	    try {
	    	System.out.println(article.getId()+" "+article.getCid()+" "+article.getTitle()+" "+article.getContent()+" "+article.getCount()+" "+article.getCreateDate());
	    	//SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
           // String data=s.format(article.getCreateDate());
	    	stmt=conn.prepareStatement(sql);
	    	stmt.setInt(1, article.getCid());
	    	stmt.setString(2, article.getTitle());
	    	stmt.setInt(3, article.getCount());
	    	stmt.setDate(4, (Date) article.getCreateDate());
	    	stmt.setString(5,article.getContent());
	    	stmt.setInt(6, article.getId());
	    	stmt.execute();
	        }catch (SQLException e) {	  
	            e.printStackTrace();
	        }finally {
				DBConn.close(stmt);
				DBConn.close(conn);
			}
	}

	@Override
	public List<Article> getall() {
		Connection conn=DBConn.getConnection();
		String sql="select * from article";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Article> articles=new ArrayList<Article>();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Article article=new Article();
				article.setId(rs.getInt(1));
				article.setCid(rs.getInt(2));
				article.setTitle(rs.getString(3));
				article.setCount(rs.getInt(4));
				article.setCreateDate(rs.getDate(5));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return articles;
	}

	@Override
	public List<Article> selectByCid(int cid) {
		Connection conn=DBConn.getConnection();
		String sql="select * from article where cid="+cid;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Article> articles=new ArrayList<Article>();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Article article=new Article();
				article.setId(rs.getInt(1));
				article.setCid(rs.getInt(2));
				article.setTitle(rs.getString(3));
				article.setCount(rs.getInt(4));
				article.setCreateDate(rs.getDate(5));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return articles;
	}

}