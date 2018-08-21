package CS.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import CS.bean.Teacher;
import CS.bean.User;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<User>{
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	private User user=new User();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
			String result = null;
		
			TeacherDaoImpl teaDao=new TeacherDaoImpl();
			Teacher tea=teaDao.login(user.getId());
			try {
				if(tea.getPassword1().equals(user.getPassword1())){
					session.setAttribute("teacher", tea);
					result=SUCCESS;
				}
			} catch (Exception e) {
				// TODO: handle exception
				this.addFieldError("error", "用户名或密码不正确");
				result="input";
			}
				return result;
			
//			if(tea.getPassword1().equals(user.getPassword1())){
//				session.setAttribute("teacher", tea);
//				return SUCCESS;
//			}else {
//				this.addFieldError("error", "用户名密码不正确");
//				return "input";
//			}
		
	}
	@SkipValidation
	public String jumpTeacherTable(){
		return SUCCESS;
	}
	@Override
	public void validate() {
		if(user.getId().equals("")||user.getId()==null){
			this.addFieldError("IDERROR", "ID不能为空");
		}
		if(user.getPassword1().equals("")||user.getPassword1()==null){
			this.addFieldError("pwdERROR", "密码不能为空");
		}
	}
	@SkipValidation
	public String logout(){
		if(session!=null){
			session.removeAttribute("teacher");
		}
		return SUCCESS;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	



}
