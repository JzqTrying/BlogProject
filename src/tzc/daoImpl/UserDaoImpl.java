package tzc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tzc.bean.User;
import tzc.dao.UserDao;
import tzc.util.DBConn;

public class UserDaoImpl implements UserDao{
 public void addUser(User user) {
	 String sql = "insert into users values(null,?,?)";
        try (Connection c = DBConn.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, user.username);
            ps.setString(2, user.password); 
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.id = id;
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
 }
 public boolean isValid(String username,String password) {
	boolean valid=false;
	try (Connection conn=DBConn.getConnection();PreparedStatement stat=conn.prepareStatement("select * from users where username=? and password=?");){
		stat.setString(1,username);
		stat.setString(2,password);
		ResultSet rs=stat.executeQuery();
		if (rs.next()) {
			valid=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return valid;
	
}
@Override
public void deleteUser(int id) {
	Connection conn = DBConn.getConnection();
	Statement stmt=null;		
	try {
		stmt = conn.createStatement();
        String sql = "delete from users where id = " + id;

        stmt.execute(sql);

    } catch (SQLException e) { 
        e.printStackTrace();
    } finally {
    	DBConn.close(conn);
    }
}
}
