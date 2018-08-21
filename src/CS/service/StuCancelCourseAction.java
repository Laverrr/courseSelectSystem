package CS.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Student;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class StuCancelCourseAction extends ActionSupport{

	private String Cid;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("student");
		String Sid=student.getSid();
		StudentDaoImpl stuDao=new StudentDaoImpl();
		stuDao.cancelCourse(Sid, Cid);
		return super.execute();
	}

	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}
	
	
}
