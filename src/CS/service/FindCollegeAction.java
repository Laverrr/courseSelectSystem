package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.College;
import CS.bean.Course;
import CS.bean.Pager;
import CS.dao.CollegeDaoImpl;
import CS.dao.CourseDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindCollegeAction extends ActionSupport implements ModelDriven<College>{

	private College college=new College();
	
	private List<College> colleges=new ArrayList<College>();
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session= request.getSession();

		String Coid=college.getCoid();
		String Coname = college.getConame(); //学生姓名
		
		//设置当前页，默认为第一页
		String pageNumStr = request.getParameter("pageNum"); 
		int pageNum = Pager.defaultPage; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		// 组装查询条件
		College searchModel = new College(); 
		searchModel.setCoid(Coid);
		searchModel.setConame(Coname);
		/*
		 * 通過老師姓名查找還沒寫
		 * */
		
		//调用dao 获取查询结果
		CollegeDaoImpl collegeDao=new CollegeDaoImpl();
		Pager<College> result = collegeDao.findCollege(searchModel,pageNum);
		session.setAttribute("result", result);
		colleges=result.getDataList();
		return super.execute();
	}
	
	@Override
	public College getModel() {
		// TODO Auto-generated method stub
		return college;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

}
