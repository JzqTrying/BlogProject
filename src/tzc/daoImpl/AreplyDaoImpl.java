package tzc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import tzc.bean.Areply;
import tzc.dao.AreplyDao;
import tzc.util.DBConn;
import tzc.util.Page;

public class AreplyDaoImpl implements AreplyDao{

	@Override
	public void addAreply(Areply areply) {
		Connection conn=DBConn.getConnection();
		String addSql="insert into areply(aid,content,username,createDate)values(?,?,?,?)";
		PreparedStatement stmt=null;
		try {
//			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//            String data=s.format(areply.getCreateDate());
			stmt=conn.prepareStatement(addSql);
			stmt.setInt(1, areply.getAid());
			stmt.setString(2, areply.getContent());
			stmt.setString(3, areply.getUsername());
			stmt.setDate(4, areply.getCreateDate());;
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(stmt);
			DBConn.close(conn);
		}
	}

	@Override
	public List<Areply> findAreplyByAid(int aid,Page page) {
		Connection conn=DBConn.getConnection();
		String sql="select * from(select areply.*,ROWNUM rn from areply where aid="+aid+" and ROWNUM <="
		+(page.getBeginIndex()+page.getEveryPage())+")  where rn>"+page.getBeginIndex();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Areply> areplys=new ArrayList<Areply>();
		try {
			stmt=conn.prepareStatement(sql);
//			stmt.setInt(2, page.getBeginIndex());
//			stmt.setInt(3, page.getEveryPage());
			rs=stmt.executeQuery();
			while(rs.next()) {
				Areply areply=new Areply();
				areply.setId(rs.getInt(1));
				areply.setAid(rs.getInt(2));
				areply.setContent(rs.getString(3));
				areply.setUsername(rs.getString(4));
				areply.setCreateDate(rs.getDate(5));
				areplys.add(areply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return areplys;
	}

	@Override
	public List<Areply> findAllAreplys(Page page) {
		Connection conn=DBConn.getConnection();
		String sql="select * from(select areply.*,ROWNUM rn from areply where ROWNUM <="+(page.getBeginIndex()+page.getEveryPage())+")  where rn>"+page.getBeginIndex();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Areply> areplys=new ArrayList<Areply>();
		try {
			stmt=conn.prepareStatement(sql);
//			stmt.setInt(1, page.getBeginIndex());
//			stmt.setInt(2, page.getEveryPage());

			rs=stmt.executeQuery();
			while(rs.next()) {
				Areply areply=new Areply();
				areply.setId(rs.getInt(1));
				areply.setAid(rs.getInt(2));
				areply.setContent(rs.getString(3));
				areply.setUsername(rs.getString(4));
				areply.setCreateDate(rs.getDate(5));
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3));
				areplys.add(areply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return areplys;
	}

	@Override
	public int findAllCount() {
		Connection conn=DBConn.getConnection();
		String sql="select count(*) from areply";
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
	public void deleteAreply(int id) {
		Connection conn = DBConn.getConnection();
		Statement stmt=null;		
		try {
			stmt = conn.createStatement();
            String sql = "delete from areply where id = " + id;
  
            stmt.execute(sql);
  
        } catch (SQLException e) { 
            e.printStackTrace();
        } finally {
        	DBConn.close(conn);
        }
	}

	@Override
	public void update(Areply areply) {
		Connection conn=DBConn.getConnection();
		String sql="update areply set aid= ?, content = ?,username= ?,createDate=? where id = ?";
		PreparedStatement stmt=null;
	    try {
	    	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            String data=s.format(areply.getCreateDate());
	    	stmt=conn.prepareStatement(sql);
	    	stmt.setInt(1, areply.getAid());
	    	stmt.setString(2, areply.getContent());
	    	stmt.setString(3, areply.getUsername());
	    	stmt.setString(4, data);
	    	stmt.setInt(5, areply.getId());
	        }catch (SQLException e) {	  
	            e.printStackTrace();
	        }finally {
				DBConn.close(stmt);
				DBConn.close(conn);
			}
	}

	@Override
	public List<Areply> selectByAid(int aid) {
		Connection conn=DBConn.getConnection();
		String sql="select * from areply where aid="+aid;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Areply> areplys=new ArrayList<Areply>();
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Areply areply=new Areply();
				areply.setId(rs.getInt(1));
				areply.setAid(rs.getInt(2));
				areply.setContent(rs.getString(3));
				areply.setUsername(rs.getString(4));
				areply.setCreateDate(rs.getDate(5));
				areplys.add(areply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);	
			DBConn.close(stmt);
			DBConn.close(conn);
		}
		return areplys;
	}

	@Override
	public int findAllCountByAid(int aid) {
		Connection conn=DBConn.getConnection();
		String sql="select count(*) from areply where aid="+aid;
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
	
}
