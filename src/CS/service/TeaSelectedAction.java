package CS.service;

import java.util.ArrayList;
import java.util.List;

import CS.bean.Course;
import CS.dao.CourseDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class TeaSelectedAction extends ActionSupport{
	
	private List<Course> SelCourses=new ArrayList<Course>();
	
	private String tid;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CourseDaoImpl CourseDao= new CourseDaoImpl();
		SelCourses=CourseDao.TeaCourses(tid);
		return super.execute();
	}
	public List<Course> getSelCourses() {
		return SelCourses;
	}
	public void setSelCourses(List<Course> selCourses) {
		SelCourses = selCourses;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}

	
	
}
