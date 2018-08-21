package CS.service;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.dao.CollegeDaoImpl;
import CS.dao.StudentDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateTeaAction extends ActionSupport{
	
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		TeacherDaoImpl TeaDao=new TeacherDaoImpl();
		request=ServletActionContext.getRequest();
		Teacher tea=(Teacher) request.getAttribute("teacher");
		TeaDao.addTea(tea);
		return super.execute();
	}


}
