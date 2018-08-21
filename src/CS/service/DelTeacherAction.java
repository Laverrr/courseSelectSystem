package CS.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.dao.StudentDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DelTeacherAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String Tid=request.getParameter("Tid");
		TeacherDaoImpl teaDao=new TeacherDaoImpl(); 
		teaDao.DelTea(Tid);
		return super.execute();
	}

}
