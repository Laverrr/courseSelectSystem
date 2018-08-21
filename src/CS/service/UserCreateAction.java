package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.bean.User;
import CS.dao.CollegeDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserCreateAction extends ActionSupport implements ModelDriven<User>{
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	private List<College> colleges=new ArrayList<College>();
	
	private User user=new User();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CollegeDaoImpl collegeDao= new CollegeDaoImpl();
		String identify=request.getParameter("identify");
		String coid=request.getParameter("coid");
		College college=collegeDao.findCollege(coid);
		System.out.println(user);
		if(identify.equals("student")){
			Student stu=new Student();
			stu.setSid(user.getId());
			stu.setSname(user.getName());
			stu.setPassword1(user.getPassword1());
			stu.setPassword2(user.getPassword2());
			stu.setScollege(college);
			request.setAttribute("student", stu);
			return "student";
		}else{
			Teacher tea=new Teacher();
			tea.setTid(user.getId());
			tea.setTname(user.getName());
			tea.setPassword1(user.getPassword1());
			tea.setPassword2(user.getPassword2());
			tea.setTcollege(college);
			request.setAttribute("teacher", tea);
			return "teacher";
		}
		
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		CollegeDaoImpl collegeDao = new CollegeDaoImpl();
		colleges=collegeDao.CollegeList();
		String identify=request.getParameter("identify");
		if(identify.equals("student")){
			if(!user.getId().substring(0, 1).equals("S")||user.getId().length()!=4)
			this.addFieldError("iderror", "ID格式有誤");
		}
		if(identify.equals("teacher")){
			if(!user.getId().substring(0, 1).equals("T")||user.getId().length()!=4)
				this.addFieldError("iderror", "ID格式有誤");
		}
		if(user.getId().equals("")||user.getId()==null){
			this.addFieldError("idERROR", "ID不能为空");
		}
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
