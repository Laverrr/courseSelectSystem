package CS.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.dao.CourseDaoImpl;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DelCourseAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String Cid=request.getParameter("Cid");
		CourseDaoImpl courseDao=new CourseDaoImpl(); 
		courseDao.delCourse(Cid);
		return super.execute();
	}

}
