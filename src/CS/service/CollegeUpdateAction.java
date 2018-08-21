package CS.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.dao.CollegeDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CollegeUpdateAction extends ActionSupport implements ModelDriven<College>{

	private College college=new College();
	
	private String Coid;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CollegeDaoImpl collegeDao= new CollegeDaoImpl();
		collegeDao.updateCollege(college);
		return super.execute();
	}
	
	public String update(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String coid=request.getParameter("Coid");
		CollegeDaoImpl collegeDao= new CollegeDaoImpl();
		College college=collegeDao.findCollege(coid);
		request.setAttribute("Coname", college.getConame());
		return SUCCESS;
	}
	
	@Override
	public College getModel() {
		// TODO Auto-generated method stub
		return college;
	}

	public String getCoid() {
		return Coid;
	}

	public void setCoid(String coid) {
		Coid = coid;
	}


}
