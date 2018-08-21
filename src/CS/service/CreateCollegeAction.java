package CS.service;

import CS.bean.College;
import CS.dao.CollegeDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CreateCollegeAction extends ActionSupport implements ModelDriven<College>{
	
	private College college=new College();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CollegeDaoImpl collegeDao=new CollegeDaoImpl();
		collegeDao.addCollege(college);
		return super.execute();
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(!college.getCoid().substring(0, 2).equals("Co")||college.getCoid().length()!=4)
			this.addFieldError("idERROR", "学院ID格式有誤");
		if(college.getCoid().equals("")||college.getConame()==null){
			this.addFieldError("idERROR", "学院ID不能为空");
		}
		if(college.getConame().equals("")||college.getConame()==null){
			this.addFieldError("nameERROR", "学院名称不能为空");
		}
	}
	
	@Override
	public College getModel() {
		// TODO Auto-generated method stub
		return college;
	}

}
