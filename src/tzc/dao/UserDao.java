package tzc.dao;

import tzc.bean.User;


public interface UserDao {
 public void addUser(User user);
 public boolean isValid(String username,String password);
 public void deleteUser(int id);
}
