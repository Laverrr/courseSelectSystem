package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Teacher;
import CS.dao.CollegeDaoImpl;
import CS.dao.CourseDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class addCourseAction extends ActionSupport implements ModelDriven<Course>{
	
	private Course course= new Course();
	
	private List<Teacher> teachers=new ArrayList<Teacher>();
	
	private List<College> colleges=new ArrayList<College>();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String Coid=request.getParameter("coid");
		System.out.println(Coid);
		CollegeDaoImpl collegeDao = new CollegeDaoImpl();
		course.setCcollege(collegeDao.findCollege(Coid));
		String Tid=request.getParameter("tid");
		System.out.println(Tid);
		TeacherDaoImpl teaDao=new TeacherDaoImpl();
		course.setTeacher(teaDao.login(Tid));
		CourseDaoImpl courseDao=new CourseDaoImpl();
		courseDao.addCourse(course);
		return super.execute();
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		TeacherDaoImpl teaDao=new TeacherDaoImpl();
		teachers=teaDao.TeacherList();
		CollegeDaoImpl collegeDao = new CollegeDaoImpl();
		colleges=collegeDao.CollegeList();
		if(!course.getCid().substring(0, 1).equals("C")||course.getCid().length()!=3)
			this.addFieldError("idERROR", "课程ID格式有誤");
		if(course.getCid().equals("")||course.getCid()==null){
			this.addFieldError("idERROR", "课程ID不能为空");
		}
		if(course.getCname().equals("")||course.getCname()==null){
			this.addFieldError("nameERROR", "课程名称不能为空");
		}
	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
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
