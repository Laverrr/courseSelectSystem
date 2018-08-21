package CS.service;

import CS.bean.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<User>{
	
	User user=new User();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String result=SUCCESS;
		
		if(!user.getId().equals("admin")){
			this.addFieldError("error", "用户名或密码不正确");
			result="input";
		}
		if(!user.getId().equals(user.getPassword1())){
			this.addFieldError("error", "用户名或密码不正确");
			result="input";
		}
		return result;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
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
