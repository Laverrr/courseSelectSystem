package CS.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.dao.CollegeDaoImpl;
import CS.dao.CourseDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class DelCollegeAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String Coid=request.getParameter("Coid");
		CollegeDaoImpl collegeDao=new CollegeDaoImpl(); 
		collegeDao.delCollege(Coid);
		return super.execute();
	}

}
