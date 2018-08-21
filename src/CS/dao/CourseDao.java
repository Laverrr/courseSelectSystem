package CS.dao;

import java.util.List;

import CS.bean.Course;
import CS.bean.Pager;
import CS.bean.Student;


public interface CourseDao {
	public List<Course> CourseList();

	public List<Course> CourseList(String college);

	public List<Course> StuCourses(String sid);

	public List<Course> TeaCourses(String tid);

	public Pager<Course> findCourse(Course searchModel, int pageNum, String Tname);
	
	public void delCourse(String Cid);
	
	public void addCourse(Course course);
	
	public Course findCourse(String coid);
}
