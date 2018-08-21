package CS.dao;

import java.util.List;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Pager;


public interface CollegeDao {
	public List<College> CollegeList();

	public College findCollege(String Coid);

	public Pager<College> findCollege(College searchModel, int pageNum);
	
	public void delCollege(String Coid);
	
	public void addCollege(College college);
	
	public void updateCollege(College college);
}
