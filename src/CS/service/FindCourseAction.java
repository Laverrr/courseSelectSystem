package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Course;
import CS.bean.Pager;
import CS.bean.Student;
import CS.dao.CollegeDaoImpl;
import CS.dao.CourseDaoImpl;
import CS.dao.StudentDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindCourseAction extends ActionSupport implements ModelDriven<Course>{

	private Course course=new Course();
	
	private List<Course> courses=new ArrayList<Course>();
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session= request.getSession();
//		Student student=(Student) session.getAttribute("student");

		String Cid=course.getCid();
		String Cname = course.getCname(); //
		String Coid=request.getParameter("coid");
		String Tname=request.getParameter("Tname");
		
		//设置当前页，默认为第一页
		String pageNumStr = request.getParameter("pageNum"); 
		int pageNum = Pager.defaultPage; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		// 组装查询条件
		Course searchModel = new Course(); 
		searchModel.setCid(Cid);
		searchModel.setCname(Cname);
		CollegeDaoImpl collegeDao=new CollegeDaoImpl(); 
		searchModel.setCcollege(collegeDao.findCollege(Coid));
		/*
		 * 通過老師姓名查找還沒寫
		 * */
		
		//调用dao 获取查询结果
		CourseDaoImpl courseDao=new CourseDaoImpl();
		Pager<Course> result = courseDao.findCourse(searchModel,pageNum,Tname);
		session.setAttribute("result", result);
		courses=result.getDataList();
		return super.execute();
	}
	
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


}
