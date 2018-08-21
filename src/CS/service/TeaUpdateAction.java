package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import CS.bean.College;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.bean.User;
import CS.dao.CollegeDaoImpl;
import CS.dao.StudentDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeaUpdateAction extends ActionSupport implements ModelDriven<User>{

	private List<College> colleges=new ArrayList<College>();
	
		private User user= new User();
	
		@Override
		@SkipValidation
		public String execute() throws Exception {
			CollegeDaoImpl collegeDao = new CollegeDaoImpl();
			colleges=collegeDao.CollegeList();
			return super.execute();
		}

		public String  update() throws Exception {
			TeacherDaoImpl TeaDao=new TeacherDaoImpl();
			CollegeDaoImpl collegeDao= new CollegeDaoImpl();
			HttpServletRequest request=ServletActionContext.getRequest();
			String coid=request.getParameter("coid");
			College college=collegeDao.findCollege(coid);
			Teacher tea=TeaDao.login(user.getId());
			tea.setTname(user.getName());
			tea.setPassword1(user.getPassword1());
			tea.setPassword2(user.getPassword2());
			tea.setTcollege(college);
			return SUCCESS;
		}
		
		@Override
		public void validate() {
			CollegeDaoImpl collegeDao = new CollegeDaoImpl();
			colleges=collegeDao.CollegeList();
			if(user.getName().equals("")||user.getName()==null){
				this.addFieldError("nameERROR", "姓名不能为空");
			}
			if(user.getPassword1().equals("")||user.getPassword1()==null){
				this.addFieldError("pwd1ERROR", "密码不能为空");
			}
			if(user.getPassword2().equals("")||user.getPassword2()==null){
				this.addFieldError("pwd2ERROR","确认密码不能为空");
			}
			if(!user.getPassword1().equals(user.getPassword2())){
				this.addFieldError("pwdERROR", "两次密码输入不一致");
			}
		}
		
		@Override
		public User getModel() {
			// TODO Auto-generated method stub
			return user;
		}

		public List<College> getColleges() {
			return colleges;
		}

		public void setColleges(List<College> colleges) {
			this.colleges = colleges;
		}
		
}
