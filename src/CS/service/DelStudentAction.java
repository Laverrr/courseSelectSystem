package CS.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DelStudentAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String Sid=request.getParameter("Sid");
		StudentDaoImpl stuDao=new StudentDaoImpl(); 
		stuDao.delStu(Sid);
		return super.execute();
	}

}
