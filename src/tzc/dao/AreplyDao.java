package tzc.dao;

import java.util.List;

import tzc.bean.Areply;
import tzc.util.Page;

public interface AreplyDao {
	public void addAreply(Areply areply);
	public List<Areply> findAreplyByAid(int aid,Page page);
	public List<Areply> findAllAreplys(Page page);
	public int findAllCount();
	public int findAllCountByAid(int aid);
	public void deleteAreply(int id);
	public void update(Areply areply);
	public List<Areply> selectByAid(int aid);
}
