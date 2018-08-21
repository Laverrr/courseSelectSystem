package CS.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Course;
import CS.bean.Student;
import CS.dao.CourseDaoImpl;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;


public class StuSelectAction extends ActionSupport{
	
	private String Cid;
	private List<Course> stuCourses;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("student");
		CourseDaoImpl courseDao=new CourseDaoImpl();
		Course course=courseDao.findCourse(Cid);
		StudentDaoImpl stuDao=new StudentDaoImpl();
		stuCourses = courseDao.StuCourses(student.getSid());
		for(Course c:stuCourses){
			if(c.getCid().equals(Cid)){
				return super.execute();
			}
		}
		stuDao.addCourse(student.getSid(),course);
		return super.execute();
	}

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}
	
	

}
