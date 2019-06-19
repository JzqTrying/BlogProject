package tzc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import tzc.bean.Blog;
import tzc.bean.Category;
import tzc.dao.BlogDao;
import tzc.util.DBConn;

public class BlogDaoImpl implements BlogDao {

	@Override
	public int findAllCount() {
		Connection conn=DBConn.getConnection();
		String sql="select count(*) from blog";
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
	public void addBlog(Blog blog) {

		Connection conn=DBConn.getConnection();
		String addSql="insert into blog(username,content,createDate) values (?,?,?)";
		PreparedStatement stmt=null;
		try {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            String data=s.format(blog.getCreateDate());
			stmt=conn.prepareStatement(addSql);
			stmt.setString(1, blog.getUsername());
			stmt.setString(2, blog.getContent());
			stmt.setString(3, data);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt);
			DBConn.close(conn);
		}
	}

	@Override
	public List<Blog> findAllBlogs(tzc.util.Page page) {
		Connection conn=DBConn.getConnection();
		String sql="select * from blog order by createDate desc limit ?,?,?";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Blog> blogs=new ArrayList<Blog>();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());
			rs=stmt.executeQuery();
			while(rs.next()) {
				Blog blog=new Blog();
				blog.setUsername(rs.getString(2));
				blog.setContent(rs.getString(3));
				blog.setCreateDate(rs.getDate(4));
				blogs.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return blogs;
	}

	@Override
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Blog> getAll() {
		Connection conn=DBConn.getConnection();
		String sql="select * from blog";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Blog> blogs=new ArrayList<Blog>();
	    try {
	    	stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getInt("id"));
				blog.setUsername(rs.getString("username"));
				blog.setContent(rs.getString("content"));
				blog.setCreateDate(rs.getDate("createDate"));
				blogs.add(blog);
			}
	        }catch (SQLException e) {	  
	            e.printStackTrace();
	        }finally {
				DBConn.close(stmt);
				DBConn.close(conn);
			}
	    return blogs;
	}



}