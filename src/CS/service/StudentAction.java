package CS.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import CS.bean.Student;
import CS.bean.User;
import CS.dao.StudentDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class StudentAction extends ActionSupport implements ModelDriven<User>{
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	private User user=new User();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
			String result=null;
			StudentDaoImpl stuDao=new StudentDaoImpl();
			Student stu=stuDao.login(user.getId());
			try {
				if(stu.getPassword1().equals(user.getPassword1())){
					session.setAttribute("student", stu);
					result=SUCCESS;
				}
			} catch (Exception e) {
				// TODO: handle exception
				this.addFieldError("error", "用户名或密码不正确");
				result="input";
			}
				return result;
	}
	@SkipValidation
	public String jumpStudentTable(){
		return SUCCESS;
	}


	
	@SkipValidation
	public String logout(){
		if(session!=null){
			session.removeAttribute("student");
		}
		return SUCCESS;
	}
	@Override
	public void validate() {
		if(user.getId().equals("")||user.getId()==null){
			this.addFieldError("IDERROR", "ID不能为空");
		}
		if(user.getPassword1().equals("")||user.getPassword1()==null){
			this.addFieldError("PWDERROR", "密码不能为空");
		}
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}


}
