package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Course;
import CS.bean.Student;
import CS.dao.CourseDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StuSelectedAction extends ActionSupport implements ModelDriven<Course>{
	
	private Course course = new Course();
	
	private List<Course> SelCourses=new ArrayList<Course>();
	
//	private String sid;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
//		request.setAttribute("sid", sid);
		HttpSession session=request.getSession();
		Student stu=(Student) session.getAttribute("student");
		CourseDaoImpl CourseDao= new CourseDaoImpl();
		SelCourses=CourseDao.StuCourses(stu.getSid());
		return super.execute();
	}

	public List<Course> getSelCourses() {
		return SelCourses;
	}

	public void setSelCourses(List<Course> selCourses) {
		SelCourses = selCourses;
	}

//	public String getSid() {
//		return sid;
//	}
//
//	public void setSid(String sid) {
//		this.sid = sid;
//	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

}
