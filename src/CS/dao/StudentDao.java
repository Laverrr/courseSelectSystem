package CS.dao;

import java.util.List;

import CS.bean.Course;
import CS.bean.Pager;
import CS.bean.Student;


public interface StudentDao {
	public void update(Student s);

	public Student login(String Sid);

	public List<Student> StudentList();

	public List<Student> StudentList(String coid);

	public void addStu(Student stu);

	public Pager<Student> findStudent(Student searchModel, int pageNum);

	public void delStu(String Sid);
	
	public void addCourse(String Sid, Course course);
	
	public void cancelCourse(String Sid, String Cid);
	
}
