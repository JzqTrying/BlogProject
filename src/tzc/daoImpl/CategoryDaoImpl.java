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

import tzc.bean.Category;
import tzc.dao.CategoryDao;
import tzc.util.DBConn;
import tzc.util.Page;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public int findAllCount() {
		Connection conn=DBConn.getConnection();
		String sql="select count(*) from categories";
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
	public void add(Category category) {
		Connection conn=DBConn.getConnection();
		String addSql="insert into categories(name,createDate)values(?,?)";
		PreparedStatement stmt=null;
		try {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            String data=s.format(category.getCreateDate());
			stmt=conn.prepareStatement(addSql);
			stmt.setString(1, category.getName());
			stmt.setDate(2, category.getCreateDate());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt);
			DBConn.close(conn);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = DBConn.getConnection();
		Statement stmt=null;		
		try {
			stmt = conn.createStatement();
            String sql = "delete from categories where id = " + id;
  
            stmt.execute(sql);
  
        } catch (SQLException e) { 
            e.printStackTrace();
        } finally {
        	DBConn.close(conn);
        }
	}

	@Override
	public List<Category> findAllCategorys(Page page) {
		Connection conn=DBConn.getConnection();
		String sql="select * from categories order by createDate desc limit ?,?";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Category> categorys=new ArrayList<Category>();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, page.getBeginIndex());
			stmt.setInt(2, page.getEveryPage());
			rs=stmt.executeQuery();
			while(rs.next()) {
				Category category=new Category();
				category.setName(rs.getString(1));
				category.setCreateDate(rs.getDate(2));
				categorys.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return categorys;
	}

	@Override
	public void update(Category category) {
		Connection conn=DBConn.getConnection();
		String sql="update categories set name= ?, createDate = ? where id = ?";
		PreparedStatement stmt=null;
	    try {
	    	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            String data=s.format(category.getCreateDate());
	    	stmt=conn.prepareStatement(sql);
	    	stmt.setString(1, category.getName());
	    	System.out.println(category.getName().toString());
	    	stmt.setDate(2, (java.sql.Date) category.getCreateDate());
	    	stmt.setInt(3, category.getId());
	    	stmt.execute();
	        }catch (SQLException e) {	  
	            e.printStackTrace();
	        }finally {
				DBConn.close(stmt);
				DBConn.close(conn);
			}
	}

	@Override
	public List<Category> getAll() {
		Connection conn=DBConn.getConnection();
		String sql="select * from categories";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Category> categorys=new ArrayList<Category>();
	    try {
	    	stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Category category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setCreateDate(rs.getDate("createDate"));
				categorys.add(category);
			}
	        }catch (SQLException e) {	  
	            e.printStackTrace();
	        }finally {
				DBConn.close(stmt);
				DBConn.close(conn);
			}
	    return categorys;
	}

}
