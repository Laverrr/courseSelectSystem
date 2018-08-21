package CS.dao;

import java.util.List;

import CS.bean.Pager;
import CS.bean.Student;
import CS.bean.Teacher;


public interface TeacherDao {
	
	void Update(Teacher t);

	public List<Teacher> TeacherList();

	public List<Teacher> TeacherList(String coid);

	public Teacher login(String Tid);

	public void addTea(Teacher tea);

	public Pager<Teacher> findTeacher(Teacher searchModel, int pageNum);
	
	public void DelTea(String Tid);
}
