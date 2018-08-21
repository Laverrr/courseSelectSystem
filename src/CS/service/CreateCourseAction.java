package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Teacher;
import CS.dao.CollegeDaoImpl;
import CS.dao.CourseDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateCourseAction extends ActionSupport {
	
	
	private List<Teacher> teachers=new ArrayList<Teacher>();
	
	private List<College> colleges=new ArrayList<College>();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpSession session=request.getSession();
		TeacherDaoImpl teaDao=new TeacherDaoImpl();
		teachers=teaDao.TeacherList();
		CollegeDaoImpl collegeDao = new CollegeDaoImpl();
		colleges=collegeDao.CollegeList();
		return super.execute();
	}


	public List<College> getColleges() {
		return colleges;
	}


	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}


	public List<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
	

}
