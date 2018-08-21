package CS.service;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Student;
import CS.dao.CollegeDaoImpl;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateStuAction extends ActionSupport{
	
	private HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		StudentDaoImpl StuDao=new StudentDaoImpl();
		request=ServletActionContext.getRequest();
		Student stu=(Student) request.getAttribute("student");
		System.out.println(stu);
		StuDao.addStu(stu);
		return super.execute();
	}


}
