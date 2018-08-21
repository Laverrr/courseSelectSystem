package CS.service;

import java.util.ArrayList;
import java.util.List;

import CS.bean.College;
import CS.dao.CollegeDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport{
	
	private List<College> colleges=new ArrayList<College>();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CollegeDaoImpl collegeDao = new CollegeDaoImpl();
		colleges=collegeDao.CollegeList();
		return super.execute();
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

}
