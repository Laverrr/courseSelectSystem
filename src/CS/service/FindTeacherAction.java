package CS.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import CS.bean.Pager;
import CS.bean.Student;
import CS.bean.Teacher;
import CS.dao.CollegeDaoImpl;
import CS.dao.StudentDaoImpl;
import CS.dao.TeacherDaoImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindTeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	
	private Teacher tea=new Teacher();
	
	private List<Teacher> teachers=new ArrayList<Teacher>();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session= request.getSession();

		String Tid=tea.getTid();
		String Tname = tea.getTname(); //学生姓名
		String Coid=request.getParameter("coid");
		
		//设置当前页，默认为第一页
		String pageNumStr = request.getParameter("pageNum"); 
		int pageNum = Pager.defaultPage; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		// 组装查询条件
		Teacher searchModel = new Teacher(); 
		searchModel.setTid(Tid);
		searchModel.setTname(Tname);
		CollegeDaoImpl collegeDao=new CollegeDaoImpl(); 
		searchModel.setTcollege(collegeDao.findCollege(Coid));
		//调用dao 获取查询结果
		TeacherDaoImpl teaDao=new TeacherDaoImpl();
		Pager<Teacher> result = teaDao.findTeacher(searchModel,pageNum);
		session.setAttribute("result", result);
		teachers=result.getDataList();
		return super.execute();
	}
	
	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		
		return tea;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
